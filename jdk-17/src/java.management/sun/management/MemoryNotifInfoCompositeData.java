/*
 * Copyright (c) 2004, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.management.MemoryNotificationInfo;
import java.lang.management.MemoryUsage;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.OpenDataException;

/**
 * A CompositeData for MemoryNotificationInfo for the local management support.
 * This class avoids the performance penalty paid to the
 * construction of a CompositeData use in the local case.
 */
public class MemoryNotifInfoCompositeData extends LazyCompositeData {
    @SuppressWarnings("serial") // Not statically typed as Serializable
    private final MemoryNotificationInfo memoryNotifInfo;

    private MemoryNotifInfoCompositeData(MemoryNotificationInfo info) {
        this.memoryNotifInfo = info;
    }

    public MemoryNotificationInfo getMemoryNotifInfo() {
        return memoryNotifInfo;
    }

    public static CompositeData toCompositeData(MemoryNotificationInfo info) {
        MemoryNotifInfoCompositeData mnicd =
            new MemoryNotifInfoCompositeData(info);
        return mnicd.getCompositeData();
    }

    protected CompositeData getCompositeData() {
        // CONTENTS OF THIS ARRAY MUST BE SYNCHRONIZED WITH
        // memoryNotifInfoItemNames!
        final Object[] memoryNotifInfoItemValues = {
            memoryNotifInfo.getPoolName(),
            MemoryUsageCompositeData.toCompositeData(memoryNotifInfo.getUsage()),
            memoryNotifInfo.getCount(),
        };

        try {
            return new CompositeDataSupport(memoryNotifInfoCompositeType,
                                            memoryNotifInfoItemNames,
                                            memoryNotifInfoItemValues);
        } catch (OpenDataException e) {
            // Should never reach here
            throw new AssertionError(e);
        }
    }

    private static final CompositeType memoryNotifInfoCompositeType;
    static {
        try {
            memoryNotifInfoCompositeType = (CompositeType)
                MappedMXBeanType.toOpenType(MemoryNotificationInfo.class);
        } catch (OpenDataException e) {
            // Should never reach here
            throw new AssertionError(e);
        }
    }

    private static final String POOL_NAME = "poolName";
    private static final String USAGE     = "usage";
    private static final String COUNT     = "count";
    private static final String[] memoryNotifInfoItemNames = {
        POOL_NAME,
        USAGE,
        COUNT,
    };


    public static String getPoolName(CompositeData cd) {
        String poolname = getString(cd, POOL_NAME);
        if (poolname == null) {
            throw new IllegalArgumentException("Invalid composite data: " +
                "Attribute " + POOL_NAME + " has null value");
        }
        return poolname;
    }

    public static MemoryUsage getUsage(CompositeData cd) {
        CompositeData usageData = (CompositeData) cd.get(USAGE);
        return MemoryUsage.from(usageData);
    }

    public static long getCount(CompositeData cd) {
        return getLong(cd, COUNT);
    }

    /** Validate if the input CompositeData has the expected
     * CompositeType (i.e. contain all attributes with expected
     * names and types).
     */
    public static void validateCompositeData(CompositeData cd) {
        if (cd == null) {
            throw new NullPointerException("Null CompositeData");
        }

        if (!isTypeMatched(memoryNotifInfoCompositeType, cd.getCompositeType())) {
            throw new IllegalArgumentException(
                "Unexpected composite type for MemoryNotificationInfo");
        }
    }

    private static final long serialVersionUID = -1805123446483771291L;
}
