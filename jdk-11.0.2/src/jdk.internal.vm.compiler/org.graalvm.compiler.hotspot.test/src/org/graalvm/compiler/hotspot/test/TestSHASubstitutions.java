/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.hotspot.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;

import org.graalvm.compiler.api.test.Graal;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.HotSpotGraalRuntimeProvider;
import org.graalvm.compiler.hotspot.replacements.SHA2Substitutions;
import org.graalvm.compiler.hotspot.replacements.SHA5Substitutions;
import org.graalvm.compiler.hotspot.replacements.SHASubstitutions;
import org.graalvm.compiler.runtime.RuntimeProvider;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Exercise the execution of the SHA digest substitutions.
 */
public class TestSHASubstitutions extends HotSpotGraalCompilerTest {

    public byte[] testDigest(String name, byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance(name, "SUN");
            digest.update(data);
            return digest.digest();
        } catch (NoSuchProviderException e) {
            return null;
        }
    }

    byte[] getData() {
        byte[] data = new byte[1024 * 16];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        return data;
    }

    GraalHotSpotVMConfig getConfig() {
        HotSpotGraalRuntimeProvider rt = (HotSpotGraalRuntimeProvider) Graal.getRequiredCapability(RuntimeProvider.class);
        return rt.getVMConfig();
    }

    @Test
    public void testSha1() {
        if (getConfig().useSHA1Intrinsics()) {
            testWithInstalledIntrinsic("sun.security.provider.SHA", SHASubstitutions.implCompressName, "testDigest", "SHA-1", getData());
        }
    }

    void testWithInstalledIntrinsic(String className, String methodName, String testSnippetName, Object... args) {
        Class<?> c;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            // It's ok to not find the class - a different security provider
            // may have been installed
            return;
        }
        InstalledCode code = null;
        try {
            ResolvedJavaMethod method = getResolvedJavaMethod(testSnippetName);
            Object receiver = method.isStatic() ? null : this;
            Result expect = executeExpected(method, receiver, args);
            code = compileAndInstallSubstitution(c, methodName);
            assertTrue("Failed to install " + methodName, code != null);
            testAgainstExpected(method, expect, receiver, args);
        } catch (AssumptionViolatedException e) {
            // Suppress so that subsequent calls to this method within the
            // same Junit @Test annotated method can proceed.
        }
        if (code != null) {
            code.invalidate();
        }
    }

    @Test
    public void testSha256() {
        if (getConfig().useSHA256Intrinsics()) {
            testWithInstalledIntrinsic("sun.security.provider.SHA2", SHA2Substitutions.implCompressName, "testDigest", "SHA-256", getData());
        }
    }

    @Test
    public void testSha512() {
        if (getConfig().useSHA512Intrinsics()) {
            testWithInstalledIntrinsic("sun.security.provider.SHA5", SHA5Substitutions.implCompressName, "testDigest", "SHA-512", getData());
        }
    }

}
