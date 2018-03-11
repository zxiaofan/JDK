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
import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.management.Descriptor;
import javax.management.DescriptorAccess;
import javax.management.*;

import com.sun.jmx.mbeanserver.GetPropertyAction;
import com.sun.jmx.trace.Trace;         

/**
 * The ModelMBeanAttributeInfo object describes an attribute of the ModelMBean.
 * It is a subclass of MBeanAttributeInfo with the addition of an associated Descriptor
 * and an implementation of the DescriptorAccess interface.
 * <P>
 * The fields in the descriptor are defined, but not limited to, the following: <P>
 * <PRE>
 * name           : attribute name  
 * descriptorType : must be "attribute"   
 * value          : current value for attribute 
 * default        : default value for attribute 
 * displayName    : name of attribute to be used in displays 
 * getMethod      : name of operation descriptor for get method  
 * setMethod      : name of operation descriptor for set method 
 * protocolMap    : object which implements the Descriptor interface: mappings must be appropriate for the attribute
 *                  and entries can be updated or augmented at runtime.
 * persistPolicy  : OnUpdate|OnTimer|NoMoreOftenThan|OnUnregister|Always|Never  
 * persistPeriod  : seconds - frequency of persist cycle. Used when persistPolicy is"OnTimer" or "NoMoreOftenThan".  
 * currencyTimeLimit : how long value is valid, &lt;0 never, =0 always, &gt;0 seconds
 * lastUpdatedTimeStamp : when value was set  
 * visibility     : 1-4 where 1: always visible 4: rarely visible  
 * presentationString : xml formatted string to allow presentation of data 
 * </PRE>
 * The default descriptor contains the name, descriptorType and displayName fields.
 *
 * <p><b>Note:</b> because of inconsistencies in previous versions of
 * this specification, it is recommended not to use negative or zero
 * values for <code>currencyTimeLimit</code>.  To indicate that a
 * cached value is never valid, omit the
 * <code>currencyTimeLimit</code> field.  To indicate that it is
 * always valid, use a very large number for this field.</p>
 *
 * <p>The <b>serialVersionUID</b> of this class is <code>6181543027787327345L</code>.
 * 
 * @since 1.5
 */


public class ModelMBeanAttributeInfo
    extends MBeanAttributeInfo
    implements DescriptorAccess {

    // Serialization compatibility stuff:
    // Two serial forms are supported in this class. The selected form depends
    // on system property "jmx.serial.form":
    //  - "1.0" for JMX 1.0
    //  - any other value for JMX 1.1 and higher
    //
    // Serial version for old serial form 
    private static final long oldSerialVersionUID = 7098036920755973145L;
    //
    // Serial version for new serial form 
    private static final long newSerialVersionUID = 6181543027787327345L;
    //
    // Serializable fields in old serial form
    private static final ObjectStreamField[] oldSerialPersistentFields = 
    {
      new ObjectStreamField("attrDescriptor", Descriptor.class),
      new ObjectStreamField("currClass", String.class)
    };
    //
    // Serializable fields in new serial form
    private static final ObjectStreamField[] newSerialPersistentFields = 
    {
      new ObjectStreamField("attrDescriptor", Descriptor.class)
    };
    //
    // Actual serial version and serial form
    private static final long serialVersionUID;
    /**
     * @serialField attrDescriptor Descriptor The {@link Descriptor} containing the metadata corresponding to
     *              this attribute
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
         * @serial The {@link Descriptor} containing the metadata corresponding to
         * this attribute
         */
        private Descriptor attrDescriptor = createDefaultDescriptor();

	private final static String currClass = "ModelMBeanAttributeInfo";

	/**
	 * Constructs a ModelMBeanAttributeInfo object with a default
	 * descriptor. The {@link Descriptor} of the constructed
	 * object will include fields contributed by any annotations
	 * on the {@code Method} objects that contain the {@link
	 * DescriptorKey} meta-annotation.
         *
	 * @param name The name of the attribute.
	 * @param description A human readable description of the attribute. Optional.
	 * @param getter The method used for reading the attribute value.
	 *          May be null if the property is write-only.
	 * @param setter The method used for writing the attribute value.
	 *          May be null if the attribute is read-only.
	 * @exception IntrospectionException There is a consistency problem in the definition of this attribute.
	 *
	 */

	public ModelMBeanAttributeInfo(String name,
				       String description,
				       Method getter,
				       Method setter) 
	throws javax.management.IntrospectionException {
		super(name, description, getter, setter);
		if (tracing())
		{
			trace("ModelMBeanAttributeInfo(" + name + ",String,Method,Method)","Entry");
		}

		attrDescriptor = createDefaultDescriptor();
		// put getter and setter methods in operations list 
		// create default descriptor

	}

	/**
	 * Constructs a ModelMBeanAttributeInfo object.  The {@link
	 * Descriptor} of the constructed object will include fields
	 * contributed by any annotations on the {@code Method}
	 * objects that contain the {@link DescriptorKey}
	 * meta-annotation.
         *
	 * @param name The name of the attribute.
	 * @param description A human readable description of the attribute. Optional.
	 * @param getter The method used for reading the attribute value.
	 *          May be null if the property is write-only.
	 * @param setter The method used for writing the attribute value.
	 *          May be null if the attribute is read-only.
	 * @param descriptor An instance of Descriptor containing the appropriate metadata
	 *                   for this instance of the Attribute. If it is null, then a default descriptor will be created.
	 * If the descriptor does not contain the field "displayName" this field is added in the descriptor with its default value.
	 *
	 * @exception IntrospectionException There is a consistency problem in the definition of this attribute.
	 * @exception RuntimeOperationsException Wraps an IllegalArgumentException. The descriptor is invalid, or descriptor field "name" is not
	 * equal  to name parameter, or descriptor field "DescriptorType" is not equal to "attribute". 
	 *
	 */

	public ModelMBeanAttributeInfo(String name,
				       String description,
				       Method getter,
				       Method setter,
				       Descriptor descriptor) 
	throws javax.management.IntrospectionException {

		super(name, description, getter, setter);
		// put getter and setter methods in operations list
		if (tracing())
		{
			trace("ModelMBeanAttributeInfo(" + name + ", String, Method, Method, Descriptor)","Entry");
		}
		if (descriptor == null)
		{
			attrDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(descriptor))
			{
				attrDescriptor = (Descriptor) descriptor.clone();
			} else
			{ 
				throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanAttributeInfo constructor"));
			}
		}
	}

	/**
	 * Constructs a ModelMBeanAttributeInfo object with a default descriptor.
	 *
	 * @param name The name of the attribute
	 * @param type The type or class name of the attribute
	 * @param description A human readable description of the attribute.
	 * @param isReadable True if the attribute has a getter method, false otherwise.
	 * @param isWritable True if the attribute has a setter method, false otherwise.
	 * @param isIs True if the attribute has an "is" getter, false otherwise.
	 *
	 */   
	public ModelMBeanAttributeInfo(String name,
				       String type,
				       String description,
				       boolean isReadable,
				       boolean isWritable,
				       boolean isIs)
    {

		super(name, type, description, isReadable, isWritable, isIs);
		// create default descriptor
		if (tracing())
		{
			trace("ModelMBeanAttributeInfo(" + name + ",String,String,boolean,boolean)","Entry");
		}
		attrDescriptor = createDefaultDescriptor();

	}
	/**
	 * Constructs a ModelMBeanAttributeInfo object with a default descriptor.
	 *
	 * @param name The name of the attribute
	 * @param type The type or class name of the attribute
	 * @param description A human readable description of the attribute.
	 * @param isReadable True if the attribute has a getter method, false otherwise.
	 * @param isWritable True if the attribute has a setter method, false otherwise.
	 * @param isIs True if the attribute has an "is" getter, false otherwise.
	 * @param descriptor An instance of Descriptor containing the appropriate metadata
	 *                   for this instance of the Attribute. If it is null then a default descriptor will be created.
	 * If the descriptor does not contain the field "displayName" this field is added in the descriptor with its default value.
	 *
	 * @exception RuntimeOperationsException Wraps an IllegalArgumentException. The descriptor is invalid, or descriptor field "name" is not
	 * equal  to name parameter,  or descriptor field "DescriptorType" is not equal to "attribute".
	 *
	 */       
	public ModelMBeanAttributeInfo(String name,
				       String type,
				       String description,
				       boolean isReadable,
				       boolean isWritable,
				       boolean isIs,
				       Descriptor descriptor)
	{
		super(name, type, description, isReadable, isWritable, isIs);
		if (tracing())
		{
			trace("ModelMBeanAttributeInfo(" + name + ",String,String,boolean,boolean,Descriptor)","Entry");

		}

		if (descriptor == null)
		{
			attrDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(descriptor))
			{
				attrDescriptor = (Descriptor) descriptor.clone();
			} else
			{ 
			    throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanAttributeInfo constructor"));
			}
		}

	}

	/**
	 * Constructs a new ModelMBeanAttributeInfo object from this ModelMBeanAttributeInfo Object.
	 * A default descriptor will be created.
	 *
	 * @param inInfo the ModelMBeanAttributeInfo to be duplicated
	 */

	public ModelMBeanAttributeInfo(ModelMBeanAttributeInfo inInfo)
	{
		super(inInfo.getName(), 
			  inInfo.getType(), 
			  inInfo.getDescription(), 
			  inInfo.isReadable(), 
			  inInfo.isWritable(),
			  inInfo.isIs());
		if (tracing())
		{
			trace("ModelMBeanAttributeInfo(ModelMBeanAttributeInfo)","Entry");
		}
		Descriptor newDesc = inInfo.getDescriptor();

		//Descriptor newDesc = inInfo.attrDescriptor;

		if ((newDesc != null) && (isValid(newDesc)))
		{
			attrDescriptor = newDesc;
		} else
		{
			attrDescriptor = createDefaultDescriptor();
		}
	}
	/** 
	 * Gets a copy of the associated Descriptor for the
	 * ModelMBeanAttributeInfo.
	 *
	 * @return Descriptor associated with the
	 * ModelMBeanAttributeInfo object.
	 *
	 * @see #setDescriptor
	 */

	public Descriptor getDescriptor()
	{
		if (tracing())
		{
			trace("ModelMBeanAttributeInfo.getDescriptor()","Entry");
		}
		if (attrDescriptor == null)
		{
			attrDescriptor = createDefaultDescriptor();
		}
		return((Descriptor)attrDescriptor.clone());
	}


	/** 
	* Sets associated Descriptor (full replace) for the
	* ModelMBeanAttributeDescriptor.  If the new Descriptor is
	* null, then the associated Descriptor reverts to a default
	* descriptor.  The Descriptor is validated before it is
	* assigned.  If the new Descriptor is invalid, then a
	* RuntimeOperationsException wrapping an
	* IllegalArgumentException is thrown.
	*
	* @param inDescriptor replaces the Descriptor associated with the 
	* ModelMBeanAttributeInfo
	* 
	* @exception RuntimeOperationsException Wraps an
	* IllegalArgumentException for an invalid Descriptor
	*
	* @see #getDescriptor
	*/
	public void setDescriptor(Descriptor inDescriptor)
	{
		if (inDescriptor != null) {
            if (tracing()) {
                trace("ModelMBeanAttributeInfo.setDescriptor()","Executed for " + inDescriptor.toString());
            }
        }
		if (inDescriptor == null) {
            if (tracing()) {
                trace("ModelMBeanAttributeInfo.setDescriptor()",
                      "Received null for new descriptor value, setting descriptor to default values");
            }
            attrDescriptor = createDefaultDescriptor();
        } 
        else {
            if (isValid(inDescriptor)) {
                attrDescriptor =  (Descriptor) inDescriptor.clone();
            } 
            else {
                throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), 
                                                     ("Exception occurred in ModelMBeanAttributeInfo setDescriptor"));
            }
        }
	}

	/**
	* Creates and returns a new ModelMBeanAttributeInfo which is a duplicate of this ModelMBeanAttributeInfo.
	*
	* @exception RuntimeOperationsException for illegal value for field Names or field Values.
	*              If the descriptor construction fails for any reason, this exception will be thrown.
	*/

	public Object clone()
	{
		if (tracing())
		{
			trace("ModelMBeanAttributeInfo.clone()","Entry");
		}
		return(new ModelMBeanAttributeInfo(this));
	}

	/**
	* Returns a human-readable version of the
	* ModelMBeanAttributeInfo instance.
	*/
	public String toString()
	{
	    return
		"ModelMBeanAttributeInfo: " + this.getName() +
		" ; Description: " + this.getDescription() +
		" ; Types: " + this.getType() + 
		" ; isReadable: " + this.isReadable() +
		" ; isWritable: " + this.isWritable() + 
		" ; Descriptor: " + this.getDescriptor();
	}

	/** 
	* Creates and returns a Descriptor with default values set: 
	*  descriptorType=attribute,name=this.getName(),displayName=this.getName(),
	* 		persistPolicy=never,visibility=1
	*/

	private Descriptor createDefaultDescriptor()
	{
		if (tracing())
		{
			trace("ModelMBeanAttributeInfo.createDefaultDescriptor()","Entry");
		}
		return new DescriptorSupport(
                         new String[] {"descriptorType=attribute",
                                       ("name=" + this.getName()),
                                       ("displayName=" + this.getName())
                         });
	}
	/**
	* Tests that the descriptor is valid and adds appropriate default fields not already
	* specified. Field values must be correct for field names. 
	* Descriptor must have the same name as the attribute,the descriptorType field must be "attribute",
	* The following fields will be defaulted if they are not already set:
	* displayName=this.getName(),persistPolicy=never,visibility=1
	*/
	private boolean isValid(Descriptor inDesc)
	{
		// name and descriptor type must be correct
		// add in displayName, persistPolicy, visibility if they apply
		boolean results=true;
		String badField="none";
		if (inDesc == null)
		{
			badField="nullDescriptor";
			results = false;
		}

		else if (!inDesc.isValid())
		{	 // checks for empty descriptors, null,
			// checks for empty name and descriptorType adn valid values for fields.
			badField="inValidDescriptor";
			results = false;
		}

		else if (! ((String)inDesc.getFieldValue("name")).equalsIgnoreCase(this.getName()))
		{
			badField="name";
			results = false;
		} else
		{

			if (! ((String)inDesc.getFieldValue("descriptorType")).equalsIgnoreCase("attribute"))
			{
				badField="desriptorType";
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
     * Deserializes a {@link ModelMBeanAttributeInfo} from an {@link ObjectInputStream}.
     */
    private void readObject(ObjectInputStream in)
	    throws IOException, ClassNotFoundException {
      // New serial form ignores extra field "currClass"
      in.defaultReadObject();
    }


    /**
     * Serializes a {@link ModelMBeanAttributeInfo} to an {@link ObjectOutputStream}.
     */
    private void writeObject(ObjectOutputStream out)
	    throws IOException {
      if (compat)
      {
        // Serializes this instance in the old serial form
        //
        ObjectOutputStream.PutField fields = out.putFields();
	fields.put("attrDescriptor", attrDescriptor);
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
