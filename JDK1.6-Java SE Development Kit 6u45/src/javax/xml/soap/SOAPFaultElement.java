/*
 * Copyright (c) 1997, 2008, Oracle and/or its affiliates. All rights reserved.
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
/*
 * $Id: SOAPFaultElement.java,v 1.4 2005/04/05 20:53:20 mk125090 Exp $
 * $Revision: 1.4 $
 * $Date: 2005/04/05 20:53:20 $
 */


package javax.xml.soap;

/**
 * A representation of the contents in 
 * a <code>SOAPFault</code> object.  The <code>Detail</code> interface
 * is a <code>SOAPFaultElement</code>.
 * <P>
 * Content is added to a <code>SOAPFaultElement</code> using the
 * <code>SOAPElement</code> method <code>addTextNode</code>.
 */
public interface SOAPFaultElement extends SOAPElement {
}
