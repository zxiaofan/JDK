/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * <h1>JAX-WS 2.1 Tools</h1>
 * This document describes the tools included with JAX-WS 2.0.1.
 *
 * <h2>ANT Tasks</h2>
   <d1>
 *  <dt>{@link com.sun.tools.internal.ws.ant.AnnotationProcessingTask AnnotationProcessing}
 *  <dd>An ANT task to invoke <a href="http://download.oracle.com/javase/6/docs/api/javax/annotation/processing/package-summary.html">Annotation Processing</a>.

 *  <dt>{@link com.sun.tools.internal.ws.ant.WsGen2 WsGen}
 *  <dd>
 *    An ANT task to invoke {@link com.sun.tools.internal.ws.WsGen WsGen}

 *  <dt>{@link com.sun.tools.internal.ws.ant.WsImport2 WsImport}
 *  <dd>
 *    An ANT task to invoke {@link com.sun.tools.internal.ws.WsImport WsImport}
 *
 *  </d1>
 * <h2>Command-line Tools</h2>
   <d1>
 *  <dt><a href="http://download.oracle.com/javase/6/docs/api/javax/annotation/processing/package-summary.html">AP</a>
 <dd>A Java SE tool and framework for processing annotations. Annotation processing will invoke a JAX-WS AnnotationProcossor for
 *   processing Java source  files with javax.jws.* annotations and making them web services.
 *   Annotation processing will compile the Java source files and generate any additional classes needed to make an javax.jws.WebService
 *   annotated class a Web service.
 *
 *  <dt>{@link com.sun.tools.internal.ws.WsGen WsGen}
 *  <dd>Tool to process a compiled javax.jws.WebService annotated class and to generate the necessary classes to make
 *  it a Web service.

 *  <dt>{@link com.sun.tools.internal.ws.ant.WsImport2 WsImport}
 *  <dd>
 *    Tool to import a WSDL and to generate an SEI (a javax.jws.WebService) interface that can be either implemented
 *    on the server to build a web service, or can be used on the client to invoke the web service.
 *  </d1>
 * <h2>Implementation Classes</h2>
 *  <d1>
 *    <dt>{@link com.sun.tools.internal.ws.processor.model.Model Model}
 *    <dd>The model is used to represent the entire Web Service.  The JAX-WS ProcessorActions can process
 *    this Model to generate Java artifacts such as the service interface.
 *
 *
 *    <dt>{@link com.sun.tools.internal.ws.processor.modeler.Modeler Modeler}
 *    <dd>A Modeler is used to create a Model of a Web Service from a particular Web
 *    Web Service description such as a WSDL
 *    file.
 *
 *    <dt>{@link com.sun.tools.internal.ws.processor.modeler.wsdl.WSDLModeler WSDLModeler}
 *    <dd>The WSDLModeler processes a WSDL to create a Model.
 *
 *    <dt>{@link com.sun.tools.internal.ws.processor.modeler.annotation.WebServiceAp WebServiceAp}
 *    <dd>WebServiceAp is a AnnotationProcessor for processing javax.jws.* and
 *    javax.xml.ws.* annotations. This class is used either by the WsGen (CompileTool) tool or
 *    idirectly via the {@link com.sun.istack.internal.ws.WSAP WSAP} when invoked by Annotation Processing.
 *   </d1>
 *
 **/
package com.sun.tools.internal.ws;
