/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.management;

import javax.management.openmbean.CompositeData;
import java.util.concurrent.locks.*;
import java.beans.ConstructorProperties;

/**
 * Information about a <em>lock</em>.  A lock can be a built-in object monitor,
 * an <em>ownable synchronizer</em>, or the {@link Condition Condition}
 * object associated with synchronizers.
 * <p>
 * <a name="OwnableSynchronizer">An ownable synchronizer</a> is
 * a synchronizer that may be exclusively owned by a thread and uses
 * {@link AbstractOwnableSynchronizer AbstractOwnableSynchronizer}
 * (or its subclass) to implement its synchronization property.
 * {@link ReentrantLock ReentrantLock} and
 * {@link ReentrantReadWriteLock ReentrantReadWriteLock} are
 * two examples of ownable synchronizers provided by the platform.
 *
 * <h4><a name="MappedType">MXBean Mapping</a></h4>
 * <tt>LockInfo</tt> is mapped to a {@link CompositeData CompositeData}
 * as specified in the <a href="../../../javax/management/MXBean.html#mapping-rules">
 * type mapping rules</a> of {@linkplain javax.management.MXBean MXBeans}.
 *
 * @see java.util.concurrent.locks.AbstractOwnableSynchronizer
 * @see java.util.concurrent.locks.Condition
 *
 * @author  Mandy Chung
 * @since   1.6
 */

public class LockInfo {

    private String className;
    private int    identityHashCode;

    /**
     * Constructs a <tt>LockInfo</tt> object.
     *
     * @param className the fully qualified name of the class of the lock object.
     * @param identityHashCode the {@link System#identityHashCode
     *                         identity hash code} of the lock object.
     */
    @ConstructorProperties({"className", "identityHashCode"})
    public LockInfo(String className, int identityHashCode) {
        if (className == null) {
            throw new NullPointerException("Parameter className cannot be null");
        }
        this.className = className;
        this.identityHashCode = identityHashCode;
    }

    /**
     * package-private constructors
     */
    LockInfo(Object lock) {
        this.className = lock.getClass().getName();
        this.identityHashCode = System.identityHashCode(lock);
    }

    /**
     * Returns the fully qualified name of the class of the lock object.
     *
     * @return the fully qualified name of the class of the lock object.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Returns the identity hash code of the lock object
     * returned from the {@link System#identityHashCode} method.
     *
     * @return the identity hash code of the lock object.
     */
    public int getIdentityHashCode() {
        return identityHashCode;
    }

    /**
     * Returns a string representation of a lock.  The returned
     * string representation consists of the name of the class of the
     * lock object, the at-sign character `@', and the unsigned
     * hexadecimal representation of the <em>identity</em> hash code
     * of the object.  This method returns a string equals to the value of:
     * <blockquote>
     * <pre>
     * lock.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(lock))
     * </pre></blockquote>
     * where <tt>lock</tt> is the lock object.
     *
     * @return the string representation of a lock.
     */
    public String toString() {
        return className + '@' + Integer.toHexString(identityHashCode);
    }
}
