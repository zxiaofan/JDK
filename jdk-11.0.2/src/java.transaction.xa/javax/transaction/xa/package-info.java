/*
 * Copyright (c) 2001, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * Provides the API that defines the contract between the transaction manager
 * and the resource manager, which allows the transaction manager to enlist
 * and delist resource objects (supplied by the resource manager driver) in
 * JTA transactions. The driver vendor for a specific resource manager provides
 * the implementation of this API.
 *
 * @since 1.4
 */

package javax.transaction.xa;
