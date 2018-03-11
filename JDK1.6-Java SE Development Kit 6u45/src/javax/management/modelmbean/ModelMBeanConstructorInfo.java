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

import javax.management.Descriptor;       
import javax.management.DescriptorAccess; 
import javax.management.*;
import java.lang.reflect.*;

import com.sun.jmx.mbeanserver.GetPropertyAction;
import com.sun.jmx.trace.Trace;         


/**
 * The ModelMBeanConstructorInfo object describes a constructor of the ModelMBean.
 * It is a subclass of MBeanConstructorInfo with the addition of an associated Descriptor
 * and an implementation of the DescriptorAccess interface.
 * <P>
 * <PRE>
 * The fields in the descriptor are defined, but not limited to, the following: <P>
 * name           : constructor name 
 * descriptorType : must be "operation"  
 * role           : must be "constructor"
 * displayName    : human readable name of constructor 
 * visibility            : 1-4 where 1: always visible 4: rarely visible 
 * presentationString :  xml formatted string to describe how to present operation 
 *</PRE>
 *
 * <p>The {@code persistPolicy} and {@code currencyTimeLimit} fields
 * are meaningless for constructors, but are not considered invalid.
 *
 * <p>The default descriptor will have the {@code name}, {@code
 * descriptorType}, {@code displayName} and {@code role} fields.
 *
 * <p>The <b>serialVersionUID</b> of this class is <code>3862947819818064362L</code>.
 * 
 * @since 1.5
 */

public class ModelMBeanConstructorInfo
    extends MBeanConstructorInfo
    implements DescriptorAccess {

    // Serialization compatibility stuff:
    // Two serial forms are supported in this class. The selected form depends
    // on system property "jmx.serial.form":
    //  - "1.0" for JMX 1.0
    //  - any other value for JMX 1.1 and higher
    //
    // Serial version for old serial form 
    private static final long oldSerialVersionUID = -4440125391095574518L;
    //
    // Serial version for new serial form 
    private static final long newSerialVersionUID = 3862947819818064362L;
    //
    // Serializable fields in old serial form
    private static final ObjectStreamField[] oldSerialPersistentFields = 
    {
      new ObjectStreamField("consDescriptor", Descriptor.class),
      new ObjectStreamField("currClass", String.class)
    };
    //
    // Serializable fields in new serial form
    private static final ObjectStreamField[] newSerialPersistentFields = 
    {
      new ObjectStreamField("consDescriptor", Descriptor.class)
    };
    //
    // Actual serial version and serial form
    private static final long serialVersionUID;
    /**
     * @serialField consDescriptor Descriptor The {@link Descriptor} containing the metadata for this instance
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
         * @serial The {@link Descriptor} containing the metadata for this instance
         */
	private Descriptor consDescriptor = createDefaultDescriptor();

	private final static String currClass = "ModelMBeanConstructorInfo";


	/**
	* Constructs a ModelMBeanConstructorInfo object with a default
	* descriptor.  The {@link Descriptor} of the constructed
	* object will include fields contributed by any annotations on
	* the {@code Constructor} object that contain the {@link
	* DescriptorKey} meta-annotation.
	*
	* @param description A human readable description of the constructor.
	* @param constructorMethod The java.lang.reflect.Constructor object
	* describing the MBean constructor.
	*/
	public ModelMBeanConstructorInfo(String description,
					 Constructor constructorMethod)
    {
		super(description, constructorMethod);

		if (tracing())
		{
			trace("ModelMBeanConstructorInfo(String, Method)","Executed");
		}
		consDescriptor = createDefaultDescriptor();

		// put getter and setter methods in constructors list 
		// create default descriptor

	}

	/**
	* Constructs a ModelMBeanConstructorInfo object.  The {@link
	* Descriptor} of the constructed object will include fields
	* contributed by any annotations on the {@code Constructor}
	* object that contain the {@link DescriptorKey}
	* meta-annotation.
        *
	* @param description A human readable description of the constructor.
	* @param constructorMethod The java.lang.reflect.Constructor object
	* describing the ModelMBean constructor.
	* @param descriptor An instance of Descriptor containing the
	* appropriate metadata for this instance of the
	* ModelMBeanConstructorInfo.  If it is null, then a default
	* descriptor will be created.If the descriptor does not
	* contain the field "displayName" this fields is added in the
	* descriptor with its default value.
	*
	* @exception RuntimeOperationsException Wraps an
	* IllegalArgumentException. The descriptor is invalid, or
	* descriptor field "name" is not equal to name parameter, or
	* descriptor field "DescriptorType" is not equal to
	* "operation" or descriptor field "role" is not equal to
	* "constructor".
	*/
    
	public ModelMBeanConstructorInfo(String description,
					 Constructor constructorMethod,
					 Descriptor descriptor)
	{

		super(description, constructorMethod);
		// put getter and setter methods in constructors list
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo(String, Method, Descriptor)","Executed");
		}
		if (descriptor == null)
		{
			if (tracing())
			{
				trace("ModelMBeanConstructorInfo(String, Method, Descriptor)","Descriptor passed in is null, setting descriptor to default values");
			}

			consDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(descriptor))
			{
				consDescriptor = (Descriptor) descriptor.clone();
			} else
			{  // exception
			    consDescriptor = createDefaultDescriptor();
			    throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanConstructorInfo constructor"));	

			}

		}
	}
	/**
	* Constructs a ModelMBeanConstructorInfo object with a default descriptor.
	*
	* @param name The name of the constructor.
	* @param description A human readable description of the constructor.
	* @param signature MBeanParameterInfo object array describing the parameters(arguments) of the constructor.
	*/

	public ModelMBeanConstructorInfo(String name,
					 String description,
					 MBeanParameterInfo[] signature)
	{

		super(name, description, signature);
		// create default descriptor
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo(String, String, MBeanParameterInfo[])","Executed");
		}
		consDescriptor = createDefaultDescriptor();
	}
	/**
	* Constructs a ModelMBeanConstructorInfo object.
	*
	* @param name The name of the constructor.
	* @param description A human readable description of the constructor.
	* @param signature MBeanParameterInfo objects describing the parameters(arguments) of the constructor.
	* @param descriptor An instance of Descriptor containing the appropriate metadata
	*                   for this instance of the MBeanConstructorInfo. If it is null then a default descriptor will be created.
	* If the descriptor does not contain the field "displayName" this field is added in the descriptor with its default value.
	*
	* @exception RuntimeOperationsException Wraps an IllegalArgumentException. The descriptor is invalid, or descriptor field "name" 
	* is not equal to name parameter, or descriptor field "DescriptorType" is not equal to "operation" or descriptor field "role" 
	* is not equal to "constructor".
	*/

	public ModelMBeanConstructorInfo(String name,
					 String description,
					 MBeanParameterInfo[] signature,
					 Descriptor descriptor)
	{
		super(name, description, signature);
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo(String, String, MBeanParameterInfo[], Descriptor)","Executed");
		}
		if (descriptor == null)
		{
			if (tracing())
			{
				trace("ModelMBeanConstructorInfo(String, Method, Descriptor)","Descriptor passed in is null, setting descriptor to default values");
			}
			consDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(descriptor))
			{
				consDescriptor = (Descriptor) descriptor.clone();
			} else
			{  // exception
				consDescriptor = createDefaultDescriptor();
				throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanConstructorInfo constructor"));								

			}
		}
	}

	/**
	 * Constructs a new ModelMBeanConstructorInfo object from this ModelMBeanConstructor Object.
	 *
	 * @param old the ModelMBeanConstructorInfo to be duplicated
	 *
	 */
	ModelMBeanConstructorInfo(ModelMBeanConstructorInfo old)
	{
		super(old.getName(), old.getDescription(), old.getSignature());
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo(ModelMBeanConstructorInfo)","Executed");
		}
		if (old.consDescriptor == null)
		{
			if (tracing())
			{
				trace("ModelMBeanConstructorInfo(String, Method, Descriptor)","Existing descriptor passed in is null, setting new descriptor to default values");
			}
			consDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(consDescriptor))
			{
				consDescriptor = (Descriptor) old.consDescriptor.clone();
			} else
			{  // exception
				consDescriptor = createDefaultDescriptor();
				throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanConstructorInfo constructor"));	

			}

		}
	}

	/**
	* Creates and returns a new ModelMBeanConstructorInfo which is a duplicate of this ModelMBeanConstructorInfo.
	*
	*/
	public Object clone ()
	{
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo.clone()","Executed");
		}
		return(new ModelMBeanConstructorInfo(this)) ;
	}

	/**
	 * Returns a copy of the associated Descriptor.
	 *
	 * @return Descriptor associated with the
	 * ModelMBeanConstructorInfo object.
	 *
	 * @see #setDescriptor
	 */


	public Descriptor getDescriptor()
	{
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo.getDescriptor()","Executed");
		}
		if (consDescriptor == null)
		{
			consDescriptor = createDefaultDescriptor();
		}
		return((Descriptor)consDescriptor.clone());
	}
	/** 
	* Sets associated Descriptor (full replace) of
	* ModelMBeanConstructorInfo.  If the new Descriptor is null,
	* then the associated Descriptor reverts to a default
	* descriptor.  The Descriptor is validated before it is
	* assigned.  If the new Descriptor is invalid, then a
	* RuntimeOperationsException wrapping an
	* IllegalArgumentException is thrown.
	*
	* @param inDescriptor replaces the Descriptor associated with
	* the ModelMBeanConstructor. If the descriptor does not
	* contain the field "displayName" this field is added in the
	* descriptor with its default value.
	*
	* @exception RuntimeOperationsException Wraps an
	* IllegalArgumentException.  The descriptor is invalid, or
	* descriptor field "name" is not equal to name parameter, or
	* descriptor field "DescriptorType" is not equal to
	* "operation" or descriptor field "role" is not equal to
	* "constructor".
	*
	* @see #getDescriptor
	*/
	public void setDescriptor(Descriptor inDescriptor)
	{
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo.setDescriptor()","Executed");
		}
		if (inDescriptor == null)
		{
			if (tracing())
			{
				trace("ModelMBeanConstructorInfo(String, Method, Descriptor)","Descriptor passed in is null, setting descriptor to default values");
			}
			consDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(inDescriptor))
			{
				consDescriptor = (Descriptor) inDescriptor.clone();
			} else
			{
			    throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanConstructorInfo setDescriptor"));
			}
		}
	}

	/**
	* Returns a string containing the entire contents of the ModelMBeanConstructorInfo in human readable form.
	*/
	public String toString()
	{
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo.toString()","Executed");
		}
		String retStr =
		    "ModelMBeanConstructorInfo: " + this.getName() +
		    " ; Description: " + this.getDescription() +
		    " ; Descriptor: " + this.getDescriptor() +
		    " ; Signature: ";
		MBeanParameterInfo[] pTypes = this.getSignature();
		for (int i=0; i < pTypes.length; i++)
		{
			retStr = retStr.concat((pTypes[i]).getType() + ", ");
		}
		return retStr;
	}
	/**
	* Creates default descriptor for constructor as follows:
	* descriptorType=operation,role=constructor,
	* name=this.getName(),displayname=this.getName(),visibility=1
	*/
	private Descriptor createDefaultDescriptor()
	{
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo.createDefaultDescriptor()","Executed");
		}
		return new DescriptorSupport(new String[] {"descriptorType=operation",
							       "role=constructor",
							       ("name=" + this.getName()),
							       ("displayname=" + this.getName())});
	}

	/**
	* Tests that the descriptor is valid and adds appropriate default fields not already
	* specified. Field values must be correct for field names. 
	* Descriptor must have the same name as the operation,the descriptorType field must 
	* be "operation", the role field must be set to "constructor".
	* The following fields will be defaulted if they are not already set:
	* displayName=this.getName()
	*/
	private boolean isValid(Descriptor inDesc)
	{
		boolean results = true;
		String badField="none";
		// if name != this.getName
		// if (descriptorType != operation)
		// look for displayName, persistPolicy, visibility and add in
		if (inDesc == null)
		{
			badField="nullDescriptor";
			results = false;
		}

		else if (!inDesc.isValid())
		{	 // checks for empty descriptors, null,
			// checks for empty name and descriptorType adn valid values for fields.
			badField="invalidDescriptor";
			results = false;
		}

		else
		{
			if (! ((String)inDesc.getFieldValue("name")).equalsIgnoreCase(this.getName()))
			{
				badField="name";
				results = false;
			}
			if (! ((String)inDesc.getFieldValue("descriptorType")).equalsIgnoreCase("operation"))
			{
				badField="descriptorType";
				results = false;
			}
			if (inDesc.getFieldValue("role") == null)
			{
				inDesc.setField("role","constructor");
			}
			if (! ((String)inDesc.getFieldValue("role")).equalsIgnoreCase("constructor"))
			{
				badField = "role";
				results = false;
			} else if ((inDesc.getFieldValue("displayName")) == null)
			{
				inDesc.setField("displayName",this.getName());
			}
		}
		if (tracing()) trace("isValid()",("Returning " + results + ": Invalid field is " + badField));
		return results;
	}

	// SUN Trace and debug functions
	private boolean tracing()
	{
		//        return false;
		return Trace.isSelected(Trace.LEVEL_TRACE, Trace.INFO_MODELMBEAN);
	}

	private void trace(String inClass, String inMethod, String inText)
	{
		//        System.out.println("TRACE: " + inClass + ":" + inMethod + ": " + inText);
		Trace.send(Trace.LEVEL_TRACE, Trace.INFO_MODELMBEAN, inClass, 
				   inMethod,  Integer.toHexString(this.hashCode()) + " " + inText); 
	}

	private void trace(String inMethod, String inText)
	{
		trace(currClass, inMethod, inText);
	}

    /**
     * Deserializes a {@link ModelMBeanConstructorInfo} from an {@link ObjectInputStream}.
     */
    private void readObject(ObjectInputStream in)
	    throws IOException, ClassNotFoundException {
      // New serial form ignores extra field "currClass"
      in.defaultReadObject();
    }


    /**
     * Serializes a {@link ModelMBeanConstructorInfo} to an {@link ObjectOutputStream}.
     */
    private void writeObject(ObjectOutputStream out)
	    throws IOException {
      if (compat)
      {
        // Serializes this instance in the old serial form
        //
        ObjectOutputStream.PutField fields = out.putFields();
	fields.put("consDescriptor", consDescriptor);
	fields.put("currClass", currClass);
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
