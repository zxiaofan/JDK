/*
 * %Z%file      %M%
 * %Z%author    IBM Corp.
 * %Z%version   %I%
 * %Z%lastedit      %E%
 */
/*
 * Copyright IBM Corp. 1999-2000.  All rights reserved.
 * 
 * The program is provided "as is" without any warranty express or implied,
 * including the warranty of non-infringement and the implied warranties of
 * merchantibility and fitness for a particular purpose. IBM will not be
 * liable for any damages suffered by you or any third party claim against 
 * you regarding the Program.
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * This software is the proprietary information of Sun Microsystems, Inc.
 * Use is subject to license terms.
 * 
 * Copyright 2006 Sun Microsystems, Inc.  Tous droits reserves.
 * Ce logiciel est propriete de Sun Microsystems, Inc.
 * Distribue par des licences qui en restreignent l'utilisation. 
 *
 */



package javax.management.modelmbean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.PrivilegedAction;

import com.sun.jmx.mbeanserver.GetPropertyAction;

/**
 * Exception thrown when an invalid target object type is specified.
 *    
 *
 * <p>The <b>serialVersionUID</b> of this class is <code>1190536278266811217L</code>.
 * 
 * @since 1.5
 */

public class InvalidTargetObjectTypeException  extends Exception
{

    // Serialization compatibility stuff:
    // Two serial forms are supported in this class. The selected form depends
    // on system property "jmx.serial.form":
    //  - "1.0" for JMX 1.0
    //  - any other value for JMX 1.1 and higher
    //
    // Serial version for old serial form 
    private static final long oldSerialVersionUID = 3711724570458346634L;
    //
    // Serial version for new serial form 
    private static final long newSerialVersionUID = 1190536278266811217L;
    //
    // Serializable fields in old serial form
    private static final ObjectStreamField[] oldSerialPersistentFields = 
    {
      new ObjectStreamField("msgStr", String.class),
      new ObjectStreamField("relatedExcept", Exception.class)
    };
    //
    // Serializable fields in new serial form
    private static final ObjectStreamField[] newSerialPersistentFields = 
    {
      new ObjectStreamField("exception", Exception.class)
    };
    //
    // Actual serial version and serial form
    private static final long serialVersionUID;
    /**
     * @serialField exception Exception Encapsulated {@link Exception}
     */
    private static final ObjectStreamField[] serialPersistentFields;
    private static boolean compat = false;  
    static {
	try {
	    GetPropertyAction act = new GetPropertyAction("jmx.serial.form");
	    String form = AccessController.doPrivileged(act);
	    compat = (form != null && form.equals("1.0"));
	} catch (Exception e) {
	    // OK: No compat with 1.0
	}
	if (compat) {
	    serialPersistentFields = oldSerialPersistentFields;
	    serialVersionUID = oldSerialVersionUID;
	} else {
	    serialPersistentFields = newSerialPersistentFields;
	    serialVersionUID = newSerialVersionUID;
	}
    }
    //
    // END Serialization compatibility stuff

    /**
     * @serial Encapsulated {@link Exception}
     */
    Exception exception;


    /**
     * Default constructor.
     */
    public InvalidTargetObjectTypeException ()
    {
      super("InvalidTargetObjectTypeException: ");
      exception = null;
    }


    /**
     * Constructor from a string.
     *
     * @param s String value that will be incorporated in the message for
     *    this exception. 
     */

    public InvalidTargetObjectTypeException (String s)
    {
      super("InvalidTargetObjectTypeException: " + s);
      exception = null;
    }


    /**
     * Constructor taking an exception and a string.
     *
     * @param e Exception that we may have caught to reissue as an
     *    InvalidTargetObjectTypeException.  The message will be used, and we may want to
     *    consider overriding the printStackTrace() methods to get data
     *    pointing back to original throw stack. 
     * @param s String value that will be incorporated in message for
     *    this exception. 
     */

    public InvalidTargetObjectTypeException (Exception e, String s)
    {
      super("InvalidTargetObjectTypeException: " + 
            s +
            ((e != null)?("\n\t triggered by:" + e.toString()):""));
      exception = e;
    }

    /**
     * Deserializes an {@link InvalidTargetObjectTypeException} from an {@link ObjectInputStream}.
     */
    private void readObject(ObjectInputStream in)
	    throws IOException, ClassNotFoundException {
      if (compat)
      {
        // Read an object serialized in the old serial form
        //
        ObjectInputStream.GetField fields = in.readFields();
	exception = (Exception) fields.get("relatedExcept", null);
	if (fields.defaulted("relatedExcept"))
        {
          throw new NullPointerException("relatedExcept");
        }
      }
      else
      {
        // Read an object serialized in the new serial form
        //
        in.defaultReadObject();
      }
    }


    /**
     * Serializes an {@link InvalidTargetObjectTypeException} to an {@link ObjectOutputStream}.
     */
    private void writeObject(ObjectOutputStream out)
	    throws IOException {
      if (compat)
      {
        // Serializes this instance in the old serial form
        //
        ObjectOutputStream.PutField fields = out.putFields();
	fields.put("relatedExcept", exception);
	fields.put("msgStr", ((exception != null)?exception.getMessage():""));
	out.writeFields();
      }
      else
      {
        // Serializes this instance in the new serial form
        //
        out.defaultWriteObject();
      }
    }
}

