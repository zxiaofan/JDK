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

package jdk.jfr;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jdk.jfr.internal.JVMSupport;
import jdk.jfr.internal.jfc.JFC;

/**
 * A collection of settings and metadata describing the configuration.
 *
 * @since 9
 */
public final class Configuration {
    private final Map<String, String> settings;
    private final String label;
    private final String description;
    private final String provider;
    private final String contents;
    private final String name;

    // package private
    Configuration(String name, String label, String description, String provider, Map<String, String> settings, String contents) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.provider = provider;
        this.settings = settings;
        this.contents = contents;
    }

    /**
     * Returns the settings that specifies how a recording is configured.
     * <p>
     * Modifying the returned {@code Map} object doesn't change the
     * configuration.
     *
     * @return settings, not {@code null}
     */
    public Map<String, String> getSettings() {
        return new LinkedHashMap<String, String>(settings);
    }

    /**
     * Returns an identifying name (for example, {@code "default" or "profile")}.
     *
     * @return the name, or {@code null} if it doesn't exist
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a human-readable name (for example, {@code "Continuous" or "Profiling"}}.
     *
     * @return the label, or {@code null} if it doesn't exist
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Returns a short sentence that describes the configuration (for example
     * {@code "Low
     * overhead configuration safe for continuous use in production
     * environments"})
     *
     * @return the description, or {@code null} if it doesn't exist
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns who created the configuration (for example {@code "OpenJDK"}).
     *
     * @return the provider, or {@code null} if it doesn't exist
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Returns a textual representation of the configuration (for example, the
     * contents of a JFC file).
     *
     * @return contents, or {@code null} if it doesn't exist
     *
     * @see Configuration#getContents()
     */
    public String getContents() {
        return contents;
    }

    /**
     * Reads a configuration from a file.
     *
     * @param path the file that contains the configuration, not {@code null}
     * @return the read {@link Configuration}, not {@code null}
     * @throws ParseException if the file can't be parsed
     * @throws IOException if the file can't be read
     * @throws SecurityException if a security manager exists and its
     *         {@code checkRead} method denies read access to the file.
     *
     * @see java.io.File#getPath()
     * @see java.lang.SecurityManager#checkRead(java.lang.String)
     */
    public static Configuration create(Path path) throws IOException, ParseException {
        Objects.requireNonNull(path);
        JVMSupport.ensureWithIOException();
        try (Reader reader = Files.newBufferedReader(path)) {
            return JFC.create(JFC.nameFromPath(path), reader);
        }
    }

    /**
     * Reads a configuration from a character stream.
     *
     * @param reader a {@code Reader} that provides the configuration contents, not
     *        {@code null}
     * @return a configuration, not {@code null}
     * @throws IOException if an I/O error occurs while trying to read contents
     *         from the {@code Reader}
     * @throws ParseException if the file can't be parsed
     */
    public static Configuration create(Reader reader) throws IOException, ParseException {
        Objects.requireNonNull(reader);
        JVMSupport.ensureWithIOException();
        return JFC.create(null, reader);
    }

    /**
     * Returns a predefined configuration.
     * <p>
     * See {@link Configuration#getConfigurations()} for available configuration
     * names.
     *
     * @param name the name of the configuration (for example, {@code "default"} or
     *        {@code "profile"})
     * @return a configuration, not {@code null}
     *
     * @throws IOException if a configuration with the given name does not
     *         exist, or if an I/O error occurs while reading the
     *         configuration file
     * @throws ParseException if the configuration file can't be parsed
     */
    public static Configuration getConfiguration(String name) throws IOException, ParseException {
        JVMSupport.ensureWithIOException();
        return JFC.getPredefined(name);
    }

    /**
     * Returns an immutable list of predefined configurations for this Java Virtual Machine (JVM).
     *
     * @return the list of predefined configurations, not {@code null}
     */
    public static List<Configuration> getConfigurations() {
        if (JVMSupport.isNotAvailable()) {
            return List.of();
        }
        return List.copyOf(JFC.getConfigurations());
    }
}
