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
 * $Id: DetailEntry.java,v 1.3 2005/04/05 20:34:16 mk125090 Exp $
 * $Revision: 1.3 $
 * $Date: 2005/04/05 20:34:16 $
 */


package javax.xml.soap;

/**
 * The content for a <code>Detail</code> object, giving details for
 * a <code>SOAPFault</code> object.  A <code>DetailEntry</code> object,
 * which carries information about errors related to the <code>SOAPBody</code>
 * object that contains it, is application-specific.
 */
public interface DetailEntry extends SOAPElement {

}
