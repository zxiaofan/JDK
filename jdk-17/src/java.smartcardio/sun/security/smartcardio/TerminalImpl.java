/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.smartcardio;

import java.util.*;

import javax.smartcardio.*;

import static sun.security.smartcardio.PCSC.*;

/**
 * CardTerminal implementation.
 *
 * @since   1.6
 * @author  Andreas Sterbenz
 */
final class TerminalImpl extends CardTerminal {

    // native SCARDCONTEXT
    final long contextId;

    // the name of this terminal (native PC/SC name)
    final String name;

    private CardImpl card;

    TerminalImpl(long contextId, String name) {
        this.contextId = contextId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized Card connect(String protocol) throws CardException {
        @SuppressWarnings("removal")
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new CardPermission(name, "connect"));
        }
        if (card != null) {
            if (card.isValid()) {
                String cardProto = card.getProtocol();
                if (protocol.equals("*") || protocol.equalsIgnoreCase(cardProto)) {
                    return card;
                } else {
                    throw new CardException("Cannot connect using " + protocol
                        + ", connection already established using " + cardProto);
                }
            } else {
                card = null;
            }
        }
        try {
            card = new CardImpl(this, protocol);
            return card;
        } catch (PCSCException e) {
            if (e.code == SCARD_W_REMOVED_CARD || e.code == SCARD_E_NO_SMARTCARD) {
                throw new CardNotPresentException("No card present", e);
            } else {
                throw new CardException("connect() failed", e);
            }
        }
    }

    public boolean isCardPresent() throws CardException {
        try {
            int[] status = SCardGetStatusChange(contextId, 0,
                    new int[] {SCARD_STATE_UNAWARE}, new String[] {name});
            return (status[0] & SCARD_STATE_PRESENT) != 0;
        } catch (PCSCException e) {
            throw new CardException("isCardPresent() failed", e);
        }
    }

    private boolean waitForCard(boolean wantPresent, long timeout) throws CardException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout must not be negative");
        }
        if (timeout == 0) {
            timeout = TIMEOUT_INFINITE;
        }
        int[] status = new int[] {SCARD_STATE_UNAWARE};
        String[] readers = new String[] {name};
        try {
            // check if card status already matches
            status = SCardGetStatusChange(contextId, 0, status, readers);
            boolean present = (status[0] & SCARD_STATE_PRESENT) != 0;
            if (wantPresent == present) {
                return true;
            }
            // no match, wait (until timeout expires)
            long end = System.currentTimeMillis() + timeout;
            while (wantPresent != present && timeout != 0) {
              // set remaining timeout
              if (timeout != TIMEOUT_INFINITE) {
                timeout = Math.max(end - System.currentTimeMillis(), 0l);
              }
              status = SCardGetStatusChange(contextId, timeout, status, readers);
              present = (status[0] & SCARD_STATE_PRESENT) != 0;
            }
            return wantPresent == present;
        } catch (PCSCException e) {
            if (e.code == SCARD_E_TIMEOUT) {
                return false;
            } else {
                throw new CardException("waitForCard() failed", e);
            }
        }
    }

    public boolean waitForCardPresent(long timeout) throws CardException {
        return waitForCard(true, timeout);
    }

    public boolean waitForCardAbsent(long timeout) throws CardException {
        return waitForCard(false, timeout);
    }

    public String toString() {
        return "PC/SC terminal " + name;
    }
}
