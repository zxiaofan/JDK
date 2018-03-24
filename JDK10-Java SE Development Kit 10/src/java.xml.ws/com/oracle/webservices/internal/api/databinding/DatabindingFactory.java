/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.oracle.webservices.internal.api.databinding;

import java.util.Map;

/**
 * {@code DatabindingFactory} is the entry point of all the WebService
 * Databinding APIs. A DatabindingFactory instance can be used to create
 * <code>Databinding.Builder</code> instances, and <code>Databinding.Builder</code>
 * instances are used to configure and build <code>Databinding</code> instances.
 * <p>
 * </P>
 * <blockquote>
 * Following is an example that creates a {@code Databinding} which provides the
 * operations to serialize/deserialize a JavaCallInfo to/from a SOAP message:<br/>
 * <pre>
 * DatabindingFactory factory = DatabindingFactory.newInstance();
 * Databinding.Builder builder = factory.createBuilder(seiClass, endpointClass);
 * Databinding databinding = builder.build();
 * </pre>
 * </blockquote>
 *
 * @see com.oracle.webservices.internal.api.databinding.Databinding
 *
 * @author shih-chang.chen@oracle.com
 */
public abstract class DatabindingFactory {

  /**
   * Creates a new instance of a <code>Databinding.Builder</code> which is
   * initialized with the specified contractClass and endpointClass. The most
   * importance initial states of a Builder object is the contract class which
   * is also called "service endpoint interface" or "SEI" in JAX-WS and JAX-RPC,
   * and the implementation bean class (endpointClass). The the implementation
   * bean class (endpointClass) should be null if the Builder is to create
   * the client side proxy databinding.
   *
   * @param contractClass The service endpoint interface class
   * @param endpointClass The service implementation bean class
   *
   * @return New instance of a <code>Databinding.Builder</code>
   */
  abstract public Databinding.Builder createBuilder(Class<?> contractClass, Class<?> endpointClass);

  /**
   * Access properties on the <code>DatabindingFactory</code> instance.
   *
   * @return properties of this WsFactory
   */
   abstract public Map<String, Object> properties();

        /**
         * The default implementation class name.
         */
   static final String ImplClass = "com.sun.xml.internal.ws.db.DatabindingFactoryImpl";

  /**
   * Create a new instance of a <code>DatabindingFactory</code>. This static method
   * creates a new factory instance.
   *
   * Once an application has obtained a reference to a <code>DatabindingFactory</code>
   * it can use the factory to obtain and configure a <code>Databinding.Builder</code>
   * to build a <code>Databinding</code> instances.
   *
   * @return New instance of a <code>DatabindingFactory</code>
   */
        static public DatabindingFactory newInstance() {
                try {
                        Class<?> cls = Class.forName(ImplClass);
                        return convertIfNecessary(cls);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;
        }

    @SuppressWarnings("deprecation")
    private static DatabindingFactory convertIfNecessary(Class<?> cls) throws InstantiationException, IllegalAccessException {
        return (DatabindingFactory) cls.newInstance();
    }
}
