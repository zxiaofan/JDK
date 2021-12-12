/*
 * Copyright (c) 2012, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.management;

import java.lang.management.LockInfo;
import java.util.Map;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.OpenDataException;

/**
 * A CompositeData for LockInfo for the local management support.
 * This class avoids the performance penalty paid to the
 * construction of a CompositeData use in the local case.
 */
public class LockInfoCompositeData extends LazyCompositeData {
    @SuppressWarnings("serial") // Not statically typed as Serializable
    private final LockInfo lock;

    private LockInfoCompositeData(LockInfo li) {
        this.lock = li;
    }

    public LockInfo getLockInfo() {
        return lock;
    }

    public static CompositeData toCompositeData(LockInfo li) {
        if (li == null) {
            return null;
        }

        LockInfoCompositeData licd = new LockInfoCompositeData(li);
        return licd.getCompositeData();
    }

    protected CompositeData getCompositeData() {
        Map<String,Object> items = Map.of(
            CLASS_NAME,         lock.getClassName(),
            IDENTITY_HASH_CODE, lock.getIdentityHashCode()
        );

        try {
            return new CompositeDataSupport(LOCK_INFO_COMPOSITE_TYPE, items);
        } catch (OpenDataException e) {
            // Should never reach here
            throw Util.newException(e);
        }
    }

    private static final CompositeType LOCK_INFO_COMPOSITE_TYPE;
    static {
        try {
            LOCK_INFO_COMPOSITE_TYPE = (CompositeType)
                MappedMXBeanType.toOpenType(LockInfo.class);
        } catch (OpenDataException e) {
            // Should never reach here
            throw Util.newException(e);
        }
    }

    static CompositeType compositeType() {
        return LOCK_INFO_COMPOSITE_TYPE;
    }

    private static final String CLASS_NAME         = "className";
    private static final String IDENTITY_HASH_CODE = "identityHashCode";

    /*
     * Returns a LockInfo object mapped from the given CompositeData.
     */
    public static LockInfo toLockInfo(CompositeData cd) {
        if (cd == null) {
            throw new NullPointerException("Null CompositeData");
        }

        if (!isTypeMatched(LOCK_INFO_COMPOSITE_TYPE, cd.getCompositeType())) {
            throw new IllegalArgumentException(
                "Unexpected composite type for LockInfo");
        }

        String className = getString(cd, CLASS_NAME);
        int identityHashCode = getInt(cd, IDENTITY_HASH_CODE);
        return new LockInfo(className, identityHashCode);
    }

    private static final long serialVersionUID = -6374759159749014052L;
}
