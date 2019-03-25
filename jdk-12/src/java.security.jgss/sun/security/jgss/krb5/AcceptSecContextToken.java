/*
 * Copyright (c) 2000, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.jgss.krb5;

import org.ietf.jgss.*;
import java.io.InputStream;
import java.io.IOException;

import sun.security.action.GetBooleanAction;
import sun.security.krb5.*;

class AcceptSecContextToken extends InitialToken {

    private KrbApRep apRep = null;

    /**
     * Creates an AcceptSecContextToken for the context acceptor to send to
     * the context initiator.
     */
    public AcceptSecContextToken(Krb5Context context,
                                 KrbApReq apReq)
        throws KrbException, IOException, GSSException {

        boolean useSubkey = GetBooleanAction
                .privilegedGetProperty("sun.security.krb5.acceptor.subkey");

        boolean useSequenceNumber = true;

        EncryptionKey subKey = null;
        if (useSubkey) {
            subKey = new EncryptionKey(apReq.getCreds().getSessionKey());
            context.setKey(Krb5Context.ACCEPTOR_SUBKEY, subKey);
        }
        apRep = new KrbApRep(apReq, useSequenceNumber, subKey);

        context.resetMySequenceNumber(apRep.getSeqNumber().intValue());

        /*
         * Note: The acceptor side context key was set when the
         * InitSecContextToken was received.
         */
    }

    /**
     * Creates an AcceptSecContextToken at the context initiator's side
     * using the bytes received from  the acceptor.
     */
    public AcceptSecContextToken(Krb5Context context,
                                 Credentials serviceCreds, KrbApReq apReq,
                                 InputStream is)
        throws IOException, GSSException, KrbException  {

        int tokenId = ((is.read()<<8) | is.read());

        if (tokenId != Krb5Token.AP_REP_ID)
            throw new GSSException(GSSException.DEFECTIVE_TOKEN, -1,
                                   "AP_REP token id does not match!");

        byte[] apRepBytes =
            new sun.security.util.DerValue(is).toByteArray();

        KrbApRep apRep = new KrbApRep(apRepBytes, serviceCreds, apReq);

        /*
         * Allow the context acceptor to set a subkey if desired, even
         * though our context acceptor will not do so.
         */
        EncryptionKey subKey = apRep.getSubKey();
        if (subKey != null) {
            context.setKey(Krb5Context.ACCEPTOR_SUBKEY, subKey);
            /*
            System.out.println("\n\nSub-Session key from AP-REP is: " +
                               getHexBytes(subKey.getBytes()) + "\n");
            */
        }

        Integer apRepSeqNumber = apRep.getSeqNumber();
        int peerSeqNumber = (apRepSeqNumber != null ?
                             apRepSeqNumber.intValue() :
                             0);
        context.resetPeerSequenceNumber(peerSeqNumber);
    }

    public final byte[] encode() throws IOException {
        byte[] apRepBytes = apRep.getMessage();
        byte[] retVal = new byte[2 + apRepBytes.length];
        writeInt(Krb5Token.AP_REP_ID, retVal, 0);
        System.arraycopy(apRepBytes, 0, retVal, 2, apRepBytes.length);
        return retVal;
    }
}
