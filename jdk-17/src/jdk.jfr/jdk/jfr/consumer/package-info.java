/*
 * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
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

/**
 * This package contains classes for consuming Flight Recorder data.
 * <p>
 * In the following example, the program prints a histogram of all method samples in a recording.
 * <pre>{@literal
 * public static void main(String[] args) throws IOException {
 *     if (args.length != 1) {
 *         System.err.println("Must specify a recording file.");
 *         return;
 *     }
 *
 *     RecordingFile.readAllEvents(Path.of(args[0])).stream()
 *         .filter(e -> e.getEventType().getName().equals("jdk.ExecutionSample"))
 *         .map(e -> e.getStackTrace())
 *         .filter(s -> s != null)
 *         .map(s -> s.getFrames().get(0))
 *         .filter(f -> f.isJavaFrame())
 *         .map(f -> f.getMethod())
 *         .collect(
 *             Collectors.groupingBy(m -> m.getType().getName() + "." + m.getName() + " " + m.getDescriptor(),
 *             Collectors.counting()))
 *         .entrySet()
 *         .stream()
 *         .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
 *         .forEach(e -> System.out.printf("%8d %s\n", e.getValue(), e.getKey()));
 *     }
 * }</pre>
 * <p>
 * <b>Null-handling</b>
 * <p>
 * All methods define whether they accept or return {@code null} in the Javadoc.
 * Typically this is expressed as {@code "not null"}. If a {@code null}
 * parameter is used where it is not allowed, a
 * {@code java.lang.NullPointerException} is thrown. If a {@code null}
 * parameters is passed to a method that throws other exceptions, such as
 * {@code java.io.IOException}, the {@code java.lang.NullPointerException} takes
 * precedence, unless the Javadoc for the method explicitly states how
 * {@code null} is handled, i.e. by throwing {@code java.lang.IllegalArgumentException}.
 *
 * @since 9
 */
package jdk.jfr.consumer;
