/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Registers Graal Compiler specific management interfaces for the JVM.
 *
 * @moduleGraph
 * @since 10
 */
module jdk.internal.vm.compiler.management {
    // source file: file:///scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/open/src/jdk.internal.vm.compiler.management/share/classes/module-info.java
    //              file:///scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/build/linux-x64/support/gensrc/jdk.internal.vm.compiler.management/module-info.java.extra
    requires java.management;
    requires jdk.management;
    requires jdk.internal.vm.ci;
    requires jdk.internal.vm.compiler;

    provides org.graalvm.compiler.hotspot.HotSpotGraalManagementRegistration with org.graalvm.compiler.hotspot.management.HotSpotGraalManagement;
    provides org.graalvm.compiler.serviceprovider.JMXService with org.graalvm.compiler.hotspot.management.JMXServiceProvider;
}
