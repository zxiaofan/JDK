/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws;

import java.util.Map;
import java.util.concurrent.Future;

/** The {@code Response} interface provides methods used to obtain the
 *  payload and context of a message sent in response to an operation
 *  invocation.
 *
 *  <p>For asynchronous operation invocations it provides additional methods
 *  to check the status of the request. The {@code get(...)} methods may
 *  throw the standard
 *  set of exceptions and their cause may be a {@code RemoteException} or a
 *  {@link WebServiceException} that represents the error that occurred during the
 *  asynchronous method invocation.</p>
 *
 * @param <T> The type of the response
 *  @since 1.6, JAX-WS 2.0
**/
public interface Response<T> extends Future<T> {
    /** Gets the contained response context.
     *
     * @return The contained response context. May be {@code null} if a
     * response is not yet available.
     *
    **/
    Map<String,Object> getContext();
}
