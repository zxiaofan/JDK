/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.tools;

import java.util.Set;
import java.io.InputStream;
import java.io.OutputStream;
import javax.lang.model.SourceVersion;

/**
 * Common interface for tools that can be invoked from a program.
 * A tool is traditionally a command line program such as a compiler.
 * The set of tools available with a platform is defined by the
 * vendor.
 *
 * <p>Tools can be located using {@link
 * java.util.ServiceLoader#load(Class)}.
 *
 * @author Neal M Gafter
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface Tool {
    /**
     * Returns the name of this tool, or an empty string if no name is provided.
     *
     * @apiNote It is recommended that the name be the same as would be
     * used on the command line: for example, "javac", "jar", "jlink".
     * @implNote This implementation returns an empty string.
     *
     * @return the name of this tool
     * @since 9
     */
    default String name() {
        return "";
    }

    /**
     * Run the tool with the given I/O channels and arguments. By
     * convention a tool returns 0 for success and nonzero for errors.
     * Any diagnostics generated will be written to either {@code out}
     * or {@code err} in some unspecified format.
     *
     * @param in "standard" input; use System.in if null
     * @param out "standard" output; use System.out if null
     * @param err "standard" error; use System.err if null
     * @param arguments arguments to pass to the tool
     * @return 0 for success; nonzero otherwise
     * @throws NullPointerException if the array of arguments contains
     * any {@code null} elements.
     */
    int run(InputStream in, OutputStream out, OutputStream err, String... arguments);

    /**
     * Returns the source versions of the Java programming language
     * supported by this tool.
     * @return a set of supported source versions
     */
    Set<SourceVersion> getSourceVersions();

}
