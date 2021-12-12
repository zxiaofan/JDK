/*
 * Copyright (c) 1996, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.x509;

/**
 * CertException indicates one of a variety of certificate problems.
 * @deprecated use one of the Exceptions defined in the
 * java.security.cert package.
 *
 * @author David Brownell
 */
@Deprecated
class CertParseError extends CertException
{
    @java.io.Serial
    private static final long serialVersionUID = -4559645519017017804L;

    CertParseError (String where)
    {
        super (CertException.verf_PARSE_ERROR, where);
    }
}
