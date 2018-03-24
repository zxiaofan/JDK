/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Defines a subset of the Java Transaction API (JTA) to support CORBA interoperation.
 * <P>
 * The subset consists of RMI exception types which are mapped to CORBA system
 * exceptions by the <em>Java Language to IDL Mapping Specification</em>.
 *
 * @moduleGraph
 * @since 9
 */
@Deprecated(since="9", forRemoval=true)
module java.transaction {
    requires transitive java.rmi;

    exports javax.transaction;
}

