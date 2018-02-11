/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.joptsimple;

import java.util.Collection;

/**
 * Trains the option parser. This interface aids integration with other code which may expose declaration of options but
 * not actual command-line parsing.
 *
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 * @see OptionParser
 */
public interface OptionDeclarer {
    /**
     * Tells the parser to recognize the given option.
     *
     * <p>This method returns an instance of {@link OptionSpecBuilder} to allow the formation of parser directives
     * as sentences in a fluent interface language. For example:</p>
     *
     * <pre><code>
     *   OptionDeclarer parser = new OptionParser();
     *   parser.<strong>accepts( "c" )</strong>.withRequiredArg().ofType( Integer.class );
     * </code></pre>
     *
     * <p>If no methods are invoked on the returned {@link OptionSpecBuilder}, then the parser treats the option as
     * accepting no argument.</p>
     *
     * @param option the option to recognize
     * @return an object that can be used to flesh out more detail about the option
     * @throws OptionException if the option contains illegal characters
     * @throws NullPointerException if the option is {@code null}
     */
    OptionSpecBuilder accepts( String option );

    /**
     * Tells the parser to recognize the given option.
     *
     * @see #accepts(String)
     * @param option the option to recognize
     * @param description a string that describes the purpose of the option. This is used when generating help
     * information about the parser.
     * @return an object that can be used to flesh out more detail about the option
     * @throws OptionException if the option contains illegal characters
     * @throws NullPointerException if the option is {@code null}
     */
    OptionSpecBuilder accepts( String option, String description );

    /**
     * Tells the parser to recognize the given options, and treat them as synonymous.
     *
     * @see #accepts(String)
     * @param options the options to recognize and treat as synonymous
     * @return an object that can be used to flesh out more detail about the options
     * @throws OptionException if any of the options contain illegal characters
     * @throws NullPointerException if the option list or any of its elements are {@code null}
     */
    OptionSpecBuilder acceptsAll( Collection<String> options );

    /**
     * Tells the parser to recognize the given options, and treat them as synonymous.
     *
     * @see #acceptsAll(Collection)
     * @param options the options to recognize and treat as synonymous
     * @param description a string that describes the purpose of the option.  This is used when generating help
     * information about the parser.
     * @return an object that can be used to flesh out more detail about the options
     * @throws OptionException if any of the options contain illegal characters
     * @throws NullPointerException if the option list or any of its elements are {@code null}
     * @throws IllegalArgumentException if the option list is empty
     */
    OptionSpecBuilder acceptsAll( Collection<String> options, String description );

    /**
     * Gives an object that represents an access point for non-option arguments on a command line.
     *
     * @return an object that can be used to flesh out more detail about the non-option arguments
     */
    NonOptionArgumentSpec<String> nonOptions();

    /**
     * Gives an object that represents an access point for non-option arguments on a command line.
     *
     * @see #nonOptions()
     * @param description a string that describes the purpose of the non-option arguments. This is used when generating
     * help information about the parser.
     * @return an object that can be used to flesh out more detail about the non-option arguments
     */
    NonOptionArgumentSpec<String> nonOptions( String description );

    /**
     * Tells the parser whether or not to behave "POSIX-ly correct"-ly.
     *
     * @param setting {@code true} if the parser should behave "POSIX-ly correct"-ly
     */
    void posixlyCorrect( boolean setting );

    /**
     * <p>Tells the parser to treat unrecognized options as non-option arguments.</p>
     *
     * <p>If not called, then the parser raises an {@link OptionException} when it encounters an unrecognized
     * option.</p>
     */
    void allowsUnrecognizedOptions();

    /**
     * Tells the parser either to recognize or ignore <kbd>"-W"</kbd>-style long options.
     *
     * @param recognize {@code true} if the parser is to recognize the special style of long options
     */
    void recognizeAlternativeLongOptions( boolean recognize );
}
