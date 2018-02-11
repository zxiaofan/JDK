/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime;

import java.lang.invoke.SwitchPoint;

/**
 * This class represents a property map that can be shared among multiple prototype objects, allowing all inheriting
 * top-level objects to also share one property map. This class is only used for prototype objects, the
 * top-level objects use ordinary {@link PropertyMap}s with the {@link PropertyMap#sharedProtoMap} field
 * set to the expected shared prototype map.
 *
 * <p>When an instance of this class is evolved because a property is added, removed, or modified in an object
 * using it, the {@link #invalidateSwitchPoint()} method is invoked to signal to all callsites and inheriting
 * objects that the assumption of a single shared prototype map is no longer valid. The property map resulting
 * from the modification will no longer be an instance of this class.</p>
 */
public final class SharedPropertyMap extends PropertyMap {

    private SwitchPoint switchPoint;

    private static final long serialVersionUID = 2166297719721778876L;

    /**
     * Create a new shared property map from the given {@code map}.
     * @param map property map to copy
     */
    public SharedPropertyMap(final PropertyMap map) {
        super(map);
        this.switchPoint = new SwitchPoint();
    }

    @Override
    public void propertyAdded(final Property property, final boolean isSelf) {
        if (isSelf) {
            invalidateSwitchPoint();
        }
        super.propertyAdded(property, isSelf);
    }

    @Override
    public void propertyDeleted(final Property property, final boolean isSelf) {
        if (isSelf) {
            invalidateSwitchPoint();
        }
        super.propertyDeleted(property, isSelf);
    }

    @Override
    public void propertyModified(final Property oldProperty, final Property newProperty, final boolean isSelf) {
        if (isSelf) {
            invalidateSwitchPoint();
        }
        super.propertyModified(oldProperty, newProperty, isSelf);
    }

    @Override
    synchronized boolean isValidSharedProtoMap() {
        return switchPoint != null;
    }

    @Override
    synchronized SwitchPoint getSharedProtoSwitchPoint() {
        return switchPoint;
    }

    /**
     * Invalidate the shared prototype switch point if this is a shared prototype map.
     */
    synchronized void invalidateSwitchPoint() {
        if (switchPoint != null) {
            assert !switchPoint.hasBeenInvalidated();
            SwitchPoint.invalidateAll(new SwitchPoint[]{ switchPoint });
            switchPoint = null;
        }
    }
}
