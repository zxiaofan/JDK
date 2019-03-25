/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.cmd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

final class ReconstructCommand extends Command {

    @Override
    public String getOptionSyntax() {
        return "<repository> <file>";
    }

    @Override
    public String getName() {
        return "reconstruct";
    }

    @Override
    public String getDescription() {
        return "Assemble leftover chunks, from a disk repository, into a recording file (.jfr)";
    }

    @Override
    public void displayOptionUsage() {
        println("  <repository>   Directory where the repository is located");
        println();
        println("  <file>         Name of the recording file (.jfr) to create");
    }

    @Override
    public void execute(Deque<String> options) {
        ensureMinArgumentCount(options, 2);
        ensureMaxArgumentCount(options, 2);

        Path repository = Paths.get(options.pop()).toAbsolutePath();
        if (!Files.exists(repository)) {
            userFailed("Could not find disk repository at " + repository);
        }
        if (!Files.isDirectory(repository)) {
            userFailed("Must specify a directory as disk repository");
        }
        Path output = Paths.get(options.pop());
        ensureFileDoesNotExist(output);
        ensureJFRFile(output);

        try (FileOutputStream fos = new FileOutputStream(output.toFile())) {
            List<Path> files = listJFRFiles(repository);
            if (files.isEmpty()) {
                throw new IllegalStateException("No *.jfr files found at " + repository);
            }
            println();
            println("Combining files... ");
            println();
            transferTo(files, output, fos.getChannel());
            println();
            println("Reconstruction complete.");
        } catch (IOException e) {
            userFailed("Could not open destination file " + output + ". " + e.getMessage());
        }
    }

    private List<Path> listJFRFiles(Path path) throws IOException {
        try {
            List<Path> files = new ArrayList<>();
            if (Files.isDirectory(path)) {
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.jfr")) {
                    for (Path p : stream) {
                        if (!Files.isDirectory(p) && Files.isReadable(p)) {
                            files.add(p);
                        }
                    }
                }
            }
            files.sort((u, v) -> u.getFileName().compareTo(v.getFileName()));
            return files;
        } catch (IOException ioe) {
            throw new IllegalStateException("Could not list *.jfr for directory " + path + ". " + ioe.getMessage());
        }
    }

    private void transferTo(List<Path> sourceFiles, Path output, FileChannel out) {
        long pos = 0;
        for (Path p : sourceFiles) {
            println(" " + p.toString());
            try (FileChannel sourceChannel = FileChannel.open(p)) {
                long rem = Files.size(p);
                while (rem > 0) {
                    long n = Math.min(rem, 1024 * 1024);
                    long w = out.transferFrom(sourceChannel, pos, n);
                    pos += w;
                    rem -= w;
                }
            } catch (IOException ioe) {
                throw new IllegalStateException("Could not copy recording chunk " + p + " to new file. " + ioe.getMessage());
            }
        }
    }
}
