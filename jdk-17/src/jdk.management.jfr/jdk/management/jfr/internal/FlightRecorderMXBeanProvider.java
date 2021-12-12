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

package jdk.management.jfr.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

import jdk.jfr.internal.management.ManagementSupport;
import jdk.management.jfr.FlightRecorderMXBean;
import jdk.management.jfr.SettingDescriptorInfo;
import sun.management.spi.PlatformMBeanProvider;

public final class FlightRecorderMXBeanProvider extends PlatformMBeanProvider {

    private static final class SingleMBeanComponent
            implements PlatformComponent<FlightRecorderMXBean> {
        private final String objectName;
        private final Class<FlightRecorderMXBean> mbeanInterface;

        public SingleMBeanComponent(String objectName,
                                    Class<FlightRecorderMXBean> mbeanInterface) {
            this.objectName = objectName;
            this.mbeanInterface = mbeanInterface;
        }

        @Override
        public Set<String> mbeanInterfaceNames() {
            return Collections.singleton(mbeanInterface.getName());
        }

        @Override
        public Map<String, FlightRecorderMXBean> nameToMBeanMap() {
            FlightRecorderMXBean bean = getFlightRecorderMXBean();
            if (bean != null) {
                return Collections.singletonMap(objectName, bean);
            } else {
                return Collections.emptyMap();
            }
        }

        @Override
        public String getObjectNamePattern() {
            return objectName;
        }

        @Override
        public Set<Class<? extends FlightRecorderMXBean>> mbeanInterfaces() {
            return Collections.singleton(mbeanInterface);
        }
    }

    private static Callable<FlightRecorderMXBean> flightRecorderMXBeanFactory;

    private static volatile FlightRecorderMXBean flightRecorderMXBean;

    private static FlightRecorderMXBean getFlightRecorderMXBean() {
        FlightRecorderMXBean bean = flightRecorderMXBean;
        if (bean == null) {
            SettingDescriptorInfo.from(null); // Sets flightRecorderMXBeanFactory under <clinit> lock
            synchronized (flightRecorderMXBeanFactory) {
                bean = flightRecorderMXBean;
                if (bean != null) {
                    return bean;
                }
                try {
                    bean = flightRecorderMXBean = flightRecorderMXBeanFactory.call();
                } catch (Exception e) {
                    ManagementSupport.logError("Could not create Flight Recorder "
                            + "instance for MBeanServer. " + e.getMessage());
                }
            }
        }
        return bean;
    }

    public static void setFlightRecorderMXBeanFactory(Callable<FlightRecorderMXBean> factory) {
        flightRecorderMXBeanFactory = factory;
    }

    @Override
    public List<PlatformComponent<?>> getPlatformComponentList() {
        String objectName = FlightRecorderMXBean.MXBEAN_NAME;
        Class<FlightRecorderMXBean> mbeanInterface = FlightRecorderMXBean.class;
        return Collections.singletonList(new SingleMBeanComponent(objectName, mbeanInterface));
    }
}
