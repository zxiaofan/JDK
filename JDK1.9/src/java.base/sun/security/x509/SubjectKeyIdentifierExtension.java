/*
 * Copyright (c) 1997, 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import sun.security.util.*;

/**
 * Represent the Subject Key Identifier Extension.
 *
 * This extension, if present, provides a means of identifying the particular
 * public key used in an application.  This extension by default is marked
 * non-critical.
 *
 * <p>Extensions are addiitonal attributes which can be inserted in a X509
 * v3 certificate. For example a "Driving License Certificate" could have
 * the driving license number as a extension.
 *
 * <p>Extensions are represented as a sequence of the extension identifier
 * (Object Identifier), a boolean flag stating whether the extension is to
 * be treated as being critical and the extension value itself (this is again
 * a DER encoding of the extension value).
 *
 * @author Amit Kapoor
 * @author Hemma Prafullchandra
 * @see Extension
 * @see CertAttrSet
 */
public class SubjectKeyIdentifierExtension extends Extension
implements CertAttrSet<String> {
    /**
     * Identifier for this attribute, to be used with the
     * get, set, delete methods of Certificate, x509 type.
     */
    public static final String IDENT =
                         "x509.info.extensions.SubjectKeyIdentifier";
    /**
     * Attribute names.
     */
    public static final String NAME = "SubjectKeyIdentifier";
    public static final String KEY_ID = "key_id";

    // Private data member
    private KeyIdentifier id = null;

    // Encode this extension value
    private void encodeThis() throws IOException {
        if (id == null) {
            this.extensionValue = null;
            return;
        }
        DerOutputStream os = new DerOutputStream();
        id.encode(os);
        this.extensionValue = os.toByteArray();
    }

    /**
     * Create a SubjectKeyIdentifierExtension with the passed octet string.
     * The criticality is set to False.
     * @param octetString the octet string identifying the key identifier.
     */
    public SubjectKeyIdentifierExtension(byte[] octetString)
    throws IOException {
        id = new KeyIdentifier(octetString);

        this.extensionId = PKIXExtensions.SubjectKey_Id;
        this.critical = false;
        encodeThis();
    }

    /**
     * Create the extension from the passed DER encoded value.
     *
     * @param critical true if the extension is to be treated as critical.
     * @param value an array of DER encoded bytes of the actual value.
     * @exception ClassCastException if value is not an array of bytes
     * @exception IOException on error.
     */
    public SubjectKeyIdentifierExtension(Boolean critical, Object value)
    throws IOException {
        this.extensionId = PKIXExtensions.SubjectKey_Id;
        this.critical = critical.booleanValue();
        this.extensionValue = (byte[]) value;
        DerValue val = new DerValue(this.extensionValue);
        this.id = new KeyIdentifier(val);
    }

    /**
     * Returns a printable representation.
     */
    public String toString() {
        return super.toString() +
            "SubjectKeyIdentifier [\n" + id + "]\n";
    }

    /**
     * Write the extension to the OutputStream.
     *
     * @param out the OutputStream to write the extension to.
     * @exception IOException on encoding errors.
     */
    public void encode(OutputStream out) throws IOException {
        DerOutputStream tmp = new DerOutputStream();
        if (extensionValue == null) {
            extensionId = PKIXExtensions.SubjectKey_Id;
            critical = false;
            encodeThis();
        }
        super.encode(tmp);
        out.write(tmp.toByteArray());
    }

    /**
     * Set the attribute value.
     */
    public void set(String name, Object obj) throws IOException {
        if (name.equalsIgnoreCase(KEY_ID)) {
            if (!(obj instanceof KeyIdentifier)) {
              throw new IOException("Attribute value should be of" +
                                    " type KeyIdentifier.");
            }
            id = (KeyIdentifier)obj;
        } else {
          throw new IOException("Attribute name not recognized by " +
                "CertAttrSet:SubjectKeyIdentifierExtension.");
        }
        encodeThis();
    }

    /**
     * Get the attribute value.
     */
    public KeyIdentifier get(String name) throws IOException {
        if (name.equalsIgnoreCase(KEY_ID)) {
            return (id);
        } else {
          throw new IOException("Attribute name not recognized by " +
                "CertAttrSet:SubjectKeyIdentifierExtension.");
        }
    }

    /**
     * Delete the attribute value.
     */
    public void delete(String name) throws IOException {
        if (name.equalsIgnoreCase(KEY_ID)) {
            id = null;
        } else {
          throw new IOException("Attribute name not recognized by " +
                "CertAttrSet:SubjectKeyIdentifierExtension.");
        }
        encodeThis();
    }

    /**
     * Return an enumeration of names of attributes existing within this
     * attribute.
     */
    public Enumeration<String> getElements() {
        AttributeNameEnumeration elements = new AttributeNameEnumeration();
        elements.addElement(KEY_ID);

        return (elements.elements());
    }

    /**
     * Return the name of this attribute.
     */
    public String getName() {
        return (NAME);
    }
}
