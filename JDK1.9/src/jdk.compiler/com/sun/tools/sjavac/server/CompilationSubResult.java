/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.server;

import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sun.tools.javac.main.Main.Result;
import com.sun.tools.sjavac.pubapi.PubApi;

/**
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class CompilationSubResult implements Serializable {

    static final long serialVersionUID = 46739181113L;

    public Result result;
    public Map<String, Set<URI>> packageArtifacts = new HashMap<>();
    public Map<String, Map<String, Set<String>>> packageDependencies = new HashMap<>();
    public Map<String, Map<String, Set<String>>> packageCpDependencies = new HashMap<>();
    public Map<String, PubApi> packagePubapis = new HashMap<>();
    public Map<String, PubApi> dependencyPubapis = new HashMap<>();
    public String stdout = "";
    public String stderr = "";

    public CompilationSubResult(Result result) {
        this.result = result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
