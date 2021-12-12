/*
 * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package jdk.jpackage.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Map;

public class WinExeBundler extends AbstractBundler {

    static {
        System.loadLibrary("jpackage");
    }

    public static final BundlerParamInfo<Path> EXE_IMAGE_DIR
            = new StandardBundlerParam<>(
                    "win.exe.imageDir",
                    Path.class,
                    params -> {
                        Path imagesRoot = IMAGES_ROOT.fetchFrom(params);
                        if (!Files.exists(imagesRoot)) {
                            try {
                                Files.createDirectories(imagesRoot);
                            } catch (IOException ioe) {
                                return null;
                            }
                        }
                        return imagesRoot.resolve("win-exe.image");
                    },
                    (s, p) -> null);

    private static final String EXE_WRAPPER_NAME = "msiwrapper.exe";

    @Override
    public String getName() {
        return I18N.getString("exe.bundler.name");
    }

    @Override
    public String getID() {
        return "exe";
    }

    @Override
    public String getBundleType() {
        return "INSTALLER";
    }

    @Override
    public Path execute(Map<String, ? super Object> params,
            Path outputParentDir) throws PackagerException {
        return bundle(params, outputParentDir);
    }

    @Override
    public boolean supported(boolean platformInstaller) {
        return msiBundler.supported(platformInstaller);
    }

    @Override
    public boolean isDefault() {
        return true;
    }

    @Override
    public boolean validate(Map<String, ? super Object> params)
            throws ConfigException {
        return msiBundler.validate(params);
    }

    public Path bundle(Map<String, ? super Object> params, Path outdir)
            throws PackagerException {

        IOUtils.writableOutputDir(outdir);

        Path exeImageDir = EXE_IMAGE_DIR.fetchFrom(params);

        // Write msi to temporary directory.
        Path msi = msiBundler.execute(params, exeImageDir);

        try {
            new ScriptRunner()
            .setDirectory(msi.getParent())
            .setResourceCategoryId("resource.post-msi-script")
            .setScriptNameSuffix("post-msi")
            .setEnvironmentVariable("JpMsiFile", msi.toAbsolutePath().toString())
            .run(params);

            return buildEXE(params, msi, outdir);
        } catch (IOException ex) {
            Log.verbose(ex);
            throw new PackagerException(ex);
        }
    }

    private Path buildEXE(Map<String, ? super Object> params, Path msi,
            Path outdir) throws IOException {

        Log.verbose(MessageFormat.format(
                I18N.getString("message.outputting-to-location"),
                outdir.toAbsolutePath().toString()));

        // Copy template msi wrapper next to msi file
        final Path exePath = IOUtils.replaceSuffix(msi, ".exe");
        try (InputStream is = OverridableResource.readDefault(EXE_WRAPPER_NAME)) {
            Files.copy(is, exePath);
        }

        new ExecutableRebrander().addAction((resourceLock) -> {
            // Embed msi in msi wrapper exe.
            embedMSI(resourceLock, msi.toAbsolutePath().toString());
        }).rebrandInstaller(params, exePath);

        Path dstExePath = outdir.toAbsolutePath().resolve(exePath.getFileName());
        Files.deleteIfExists(dstExePath);

        Files.copy(exePath, dstExePath);

        dstExePath.toFile().setWritable(true, true);

        Log.verbose(MessageFormat.format(
                I18N.getString("message.output-location"),
                outdir.toAbsolutePath().toString()));

        return dstExePath;
    }

    private final WinMsiBundler msiBundler = new WinMsiBundler();

    private static native int embedMSI(long resourceLock, String msiPath);
}
