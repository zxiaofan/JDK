/*
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

/*
 *
 *
 *
 *
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

/**
 * A small toolkit of classes that support lock-free thread-safe
 * programming on single variables.  Instances of Atomic classes
 * maintain values that are accessed and updated using methods
 * otherwise available for fields using associated atomic {@link
 * java.lang.invoke.VarHandle} operations.
 *
 * <p>Instances of classes
 * {@link java.util.concurrent.atomic.AtomicBoolean},
 * {@link java.util.concurrent.atomic.AtomicInteger},
 * {@link java.util.concurrent.atomic.AtomicLong}, and
 * {@link java.util.concurrent.atomic.AtomicReference}
 * each provide access and updates to a single variable of the
 * corresponding type.  Each class also provides appropriate utility
 * methods for that type.  For example, classes {@code AtomicLong} and
 * {@code AtomicInteger} provide atomic increment methods.  One
 * application is to generate sequence numbers, as in:
 *
 * <pre> {@code
 * class Sequencer {
 *   private final AtomicLong sequenceNumber
 *     = new AtomicLong(17);
 *   public long next() {
 *     return sequenceNumber.getAndIncrement();
 *   }
 * }}</pre>
 *
 * <p>Arbitrary transformations of the contained value are provided both
 * by low-level read-modify-write operations such as {@code compareAndSet}
 * and by higher-level methods such as {@code getAndUpdate}.
 *
 * <p>These classes are not general purpose replacements for {@code
 * java.lang.Integer} and related classes.  They do <em>not</em>
 * define methods such as {@code equals}, {@code hashCode} and {@code
 * compareTo}.  Because atomic variables are expected to be mutated,
 * they are poor choices for hash table keys.
 *
 * <p>The
 * {@link java.util.concurrent.atomic.AtomicIntegerArray},
 * {@link java.util.concurrent.atomic.AtomicLongArray}, and
 * {@link java.util.concurrent.atomic.AtomicReferenceArray} classes
 * further extend atomic operation support to arrays of these types.
 * These classes are also notable in providing {@code volatile} access
 * semantics for their array elements.
 *
 * <p>In addition to classes representing single values and arrays,
 * this package contains <em>Updater</em> classes that can be used to
 * obtain {@code compareAndSet} and related operations on any selected
 * {@code volatile} field of any selected class. These classes
 * predate the introduction of {@link
 * java.lang.invoke.VarHandle}, and are of more limited use.
 * {@link java.util.concurrent.atomic.AtomicReferenceFieldUpdater},
 * {@link java.util.concurrent.atomic.AtomicIntegerFieldUpdater}, and
 * {@link java.util.concurrent.atomic.AtomicLongFieldUpdater} are
 * reflection-based utilities that provide access to the associated
 * field types.  These are mainly of use in atomic data structures in
 * which several {@code volatile} fields of the same node (for
 * example, the links of a tree node) are independently subject to
 * atomic updates.  These classes enable greater flexibility in how
 * and when to use atomic updates, at the expense of more awkward
 * reflection-based setup, less convenient usage, and weaker
 * guarantees.
 *
 * <p>The {@link java.util.concurrent.atomic.AtomicMarkableReference}
 * class associates a single boolean with a reference.  For example, this
 * bit might be used inside a data structure to mean that the object
 * being referenced has logically been deleted.
 *
 * The {@link java.util.concurrent.atomic.AtomicStampedReference}
 * class associates an integer value with a reference.  This may be
 * used for example, to represent version numbers corresponding to
 * series of updates.
 *
 * @since 1.5
 */
package java.util.concurrent.atomic;
