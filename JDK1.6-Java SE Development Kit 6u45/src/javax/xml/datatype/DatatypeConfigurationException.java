/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://jaxp.dev.java.net/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://jaxp.dev.java.net/CDDLv1.0.html
 * If applicable add the following below this CDDL HEADER
 * with the fields enclosed by brackets "[]" replaced with
 * your own identifying information: Portions Copyright
 * [year] [name of copyright owner]
 */

/*
 * $Id: XMLEntityReader.java,v 1.3 2005/11/03 17:02:21 jeffsuttor Exp $
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 */

package javax.xml.datatype;

/**
 * <p>Indicates a serious configuration error.</p>
 *
 * @author <a href="mailto:Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 1.3 $, $Date: 2005/09/14 21:57:16 $
 * @since 1.5
 */

public class DatatypeConfigurationException extends Exception {

    /**
     * <p>Create a new <code>DatatypeConfigurationException</code> with
     * no specified detail mesage and cause.</p>
     */

    public DatatypeConfigurationException() {
        super();
    }

    /**
     * <p>Create a new <code>DatatypeConfigurationException</code> with
	 * the specified detail message.</p>
     *
	 * @param message The detail message.
     */
    
    public DatatypeConfigurationException(String message) {
        super(message);
    }

	/**
	 * <p>Create a new <code>DatatypeConfigurationException</code> with
	 * the specified detail message and cause.</p>
	 *
	 * @param message The detail message.
	 * @param cause The cause.  A <code>null</code> value is permitted, and indicates that the cause is nonexistent or unknown.
	 */
    
	public DatatypeConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * <p>Create a new <code>DatatypeConfigurationException</code> with
	 * the specified cause.</p>
	 *
	 * @param cause The cause.  A <code>null</code> value is permitted, and indicates that the cause is nonexistent or unknown.
	 */
    
	public DatatypeConfigurationException(Throwable cause) {
		super(cause);
	}
}
