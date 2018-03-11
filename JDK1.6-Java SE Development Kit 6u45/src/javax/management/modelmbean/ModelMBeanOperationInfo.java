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
 * The ModelMBeanOperationInfo object describes a management operation of the ModelMBean.
 * It is a subclass of MBeanOperationInfo with the addition of an associated Descriptor
 * and an implementation of the DescriptorAccess interface.
 * <P>
 * <PRE>
 * The fields in the descriptor are defined, but not limited to, the following: 
 * name           : operation name 
 * descriptorType : must be "operation"    
 * class          : class where method is defined (fully qualified) 
 * role           : must be "operation", "getter", or "setter
 * targetObject   : object on which to execute this method          
 * targetType     : type of object reference for targetObject. Can be: ObjectReference | Handle | EJBHandle | IOR | RMIReference.
 * value          : cached value for operation                   
 * currencyTimeLimit : how long cached value is valid               
 * lastUpdatedTimeStamp : when cached value was set                
 * visibility            : 1-4 where 1: always visible 4: rarely visible 
 * presentationString :  xml formatted string to describe how to present operation 
 * </PRE>
 * The default descriptor will have name, descriptorType, displayName and role fields set.
 *
 * <p><b>Note:</b> because of inconsistencies in previous versions of
 * this specification, it is recommended not to use negative or zero
 * values for <code>currencyTimeLimit</code>.  To indicate that a
 * cached value is never valid, omit the
 * <code>currencyTimeLimit</code> field.  To indicate that it is
 * always valid, use a very large number for this field.</p>
 *
 * <p>The <b>serialVersionUID</b> of this class is <code>6532732096650090465L</code>.
 * 
 * @since 1.5
 */

public class ModelMBeanOperationInfo extends MBeanOperationInfo 
	 implements DescriptorAccess
{

    // Serialization compatibility stuff:
    // Two serial forms are supported in this class. The selected form depends
    // on system property "jmx.serial.form":
    //  - "1.0" for JMX 1.0
    //  - any other value for JMX 1.1 and higher
    //
    // Serial version for old serial form 
    private static final long oldSerialVersionUID = 9087646304346171239L;
    //
    // Serial version for new serial form 
    private static final long newSerialVersionUID = 6532732096650090465L;
    //
    // Serializable fields in old serial form
    private static final ObjectStreamField[] oldSerialPersistentFields = 
    {
      new ObjectStreamField("operationDescriptor", Descriptor.class),
      new ObjectStreamField("currClass", String.class)
    };
    //
    // Serializable fields in new serial form
    private static final ObjectStreamField[] newSerialPersistentFields = 
    {
      new ObjectStreamField("operationDescriptor", Descriptor.class)
    };
    //
    // Actual serial version and serial form
    private static final long serialVersionUID;
    /**
     * @serialField operationDescriptor Descriptor The descriptor containing the appropriate metadata for this instance
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
         * @serial The descriptor containing the appropriate metadata for this instance
         */
	private Descriptor operationDescriptor = createDefaultDescriptor();

	private static final String currClass = "ModelMBeanOperationInfo";

	/**
	 * Constructs a ModelMBeanOperationInfo object with a default
	 * descriptor. The {@link Descriptor} of the constructed
	 * object will include fields contributed by any annotations
	 * on the {@code Method} object that contain the {@link
	 * DescriptorKey} meta-annotation.
	 *
	 * @param operationMethod The java.lang.reflect.Method object
	 * describing the MBean operation.
	 * @param description A human readable description of the operation.
	 */

	public ModelMBeanOperationInfo(String description,
				       Method operationMethod)
	{
		super(description, operationMethod);
		// create default descriptor
		if (tracing())
		{
			trace("ModelMBeanOperationInfo(String,Method)","Executed");
		}
		operationDescriptor = createDefaultDescriptor();


	}

	/**
	 * Constructs a ModelMBeanOperationInfo object. The {@link
	 * Descriptor} of the constructed object will include fields
	 * contributed by any annotations on the {@code Method} object
	 * that contain the {@link DescriptorKey} meta-annotation.
         *
	 * @param operationMethod The java.lang.reflect.Method object
	 * describing the MBean operation.
	 * @param description A human readable description of the
	 * operation.
	 * @param descriptor An instance of Descriptor containing the
	 * appropriate metadata for this instance of the
	 * ModelMBeanOperationInfo.  If it is null a default
	 * descriptor will be created. If the descriptor does not
	 * contain the fields "displayName" or "role" these fields are
	 * added in the descriptor with their default values.
	 *
	 * @exception RuntimeOperationsException Wraps an
	 * IllegalArgumentException. The descriptor is invalid; or
	 * descriptor field "name" is not equal to operation name; or
	 * descriptor field "DescriptorType" is not equal to
	 * "operation"; or descriptor optional field "role" is not equal to
	 * "operation", "getter", or "setter".
	 *
	 */

	public ModelMBeanOperationInfo(String description,
				       Method operationMethod,
				       Descriptor descriptor)
	{

		super(description, operationMethod);
		if (tracing())
		{
			trace("ModelMBeanOperationInfo(String,Method,Descriptor)","Executed");
		}
		if (descriptor == null)
		{
			if (tracing())
			{
				trace("ModelMBeanOperationInfo()","Received null for new descriptor value, setting descriptor to default values");
			}
			operationDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(descriptor))
			{
				operationDescriptor = (Descriptor) descriptor.clone();
			} else
			{
				operationDescriptor = createDefaultDescriptor();
				throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanOperationInfo constructor"));
			}
		}
	}

	/**
	* Constructs a ModelMBeanOperationInfo object with a default descriptor.
	*
	* @param name The name of the method.
	* @param description A human readable description of the operation.
	* @param signature MBeanParameterInfo objects describing the parameters(arguments) of the method.
	* @param type The type of the method's return value.
	* @param impact The impact of the method, one of INFO, ACTION, ACTION_INFO, UNKNOWN.
	*/

	public ModelMBeanOperationInfo(String name,
				       String description,
				       MBeanParameterInfo[] signature, 
				       String type,
				       int impact)
	{

		super(name, description, signature, type, impact);
		// create default descriptor
		if (tracing())
		{
			trace("ModelMBeanOperationInfo(String,String,MBeanParameterInfo[],String,int)","Executed");
		}
		operationDescriptor = createDefaultDescriptor();

	}

	/**
	* Constructs a ModelMBeanOperationInfo object.
	*
	* @param name The name of the method.
	* @param description A human readable description of the operation.
	* @param signature MBeanParameterInfo objects describing the parameters(arguments) of the method.
	* @param type The type of the method's return value.
	* @param impact The impact of the method, one of INFO, ACTION, ACTION_INFO, UNKNOWN.
	* @param descriptor An instance of Descriptor containing the appropriate metadata.
	* for this instance of the MBeanOperationInfo.If it is null then a default descriptor will be created.
	* If the descriptor does not contain the fields 
	* "displayName" or "role" these fields are added in the descriptor with their default values.
	*
	* @exception RuntimeOperationsException Wraps an
	* IllegalArgumentException. The descriptor is invalid; or
	* descriptor field "name" is not equal to operation name; or
	* descriptor field "DescriptorType" is not equal to
	* "operation"; or descriptor optional field "role" is not equal to
	* "operation", "getter", or "setter".
	*/

	public ModelMBeanOperationInfo(String name,
				       String description,
				       MBeanParameterInfo[] signature, 
				       String type,
				       int impact,
				       Descriptor descriptor)
	{
		super(name, description, signature, type, impact);
		if (tracing())
		{
			trace("ModelMBeanOperationInfo(String,String,MBeanParameterInfo[],String,int,Descriptor)","Executed");
		}
		if (descriptor == null)
		{
			if (tracing())
			{
				trace("ModelMBeanOperationInfo()","Received null for new descriptor value, setting descriptor to default values");
			}
			operationDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(descriptor))
			{
				operationDescriptor = (Descriptor) descriptor.clone();
			} else
			{
				operationDescriptor = createDefaultDescriptor();
				throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanOperationInfo constructor"));
			}

		}
	}

	/**
	 * Constructs a new ModelMBeanOperationInfo object from this ModelMBeanOperation Object.
	 *
	 * @param inInfo the ModelMBeanOperationInfo to be duplicated
	 *
	 */

	public ModelMBeanOperationInfo(ModelMBeanOperationInfo inInfo)
	{
		super(inInfo.getName(), 
			  inInfo.getDescription(), 
			  inInfo.getSignature(),
			  inInfo.getReturnType(), 
			  inInfo.getImpact());
		if (tracing())
		{
			trace("ModelMBeanOperationInfo(ModelMBeanOperationInfo)","Executed");
		}
		Descriptor newDesc = inInfo.getDescriptor();
		if (newDesc == null)
		{
			operationDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(newDesc))
			{
				operationDescriptor = (Descriptor) newDesc.clone();
			} else
			{
				operationDescriptor = createDefaultDescriptor();
				throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanOperationInfo constructor"));
			}

		}
	}

	/**
	* Creates and returns a new ModelMBeanOperationInfo which is a duplicate of this ModelMBeanOperationInfo.
	*
	*/

	public Object clone ()
	{
		if (tracing())
		{
			trace("ModelMBeanOperationInfo.clone()","Executed");
		}
		return(new ModelMBeanOperationInfo(this)) ;
	}

	/** 
	 * Returns a copy of the associated Descriptor of the
	 * ModelMBeanOperationInfo.
	 *
	 * @return Descriptor associated with the
	 * ModelMBeanOperationInfo object.
	 *
	 * @see #setDescriptor
	 */

	public Descriptor getDescriptor()
	{
		if (tracing())
		{
			trace("ModelMBeanOperationInfo.getDescriptor()","Executed");
		}
		if (operationDescriptor == null)
		{
			operationDescriptor = createDefaultDescriptor();
		}

		return((Descriptor) operationDescriptor.clone());
	}

	/**
	 * Sets associated Descriptor (full replace) for the
	 * ModelMBeanOperationInfo If the new Descriptor is null, then
	 * the associated Descriptor reverts to a default descriptor.
	 * The Descriptor is validated before it is assigned.  If the
	 * new Descriptor is invalid, then a
	 * RuntimeOperationsException wrapping an
	 * IllegalArgumentException is thrown.
	 *
	 * @param inDescriptor replaces the Descriptor associated with the 
	 * ModelMBeanOperation.	 	 
	 *
	 * @exception RuntimeOperationsException Wraps an
	 * IllegalArgumentException for invalid Descriptor.
	 *
	 * @see #getDescriptor
	 */
	public void setDescriptor(Descriptor inDescriptor)
	{
		if (tracing())
		{
			trace("ModelMBeanOperationInfo.setDescriptor(Descriptor)","Executed");
		}
		if (inDescriptor == null)
		{
			if (tracing())
			{
				trace("ModelMBeanOperationInfo.setDescriptor()","Received null for new descriptor value, setting descriptor to default values");
			}
			operationDescriptor = createDefaultDescriptor();
		} else
		{
			if (isValid(inDescriptor))
			{
				operationDescriptor = (Descriptor) inDescriptor.clone();
			} else
			{
				throw new RuntimeOperationsException(new IllegalArgumentException("Invalid descriptor passed in parameter"), ("Exception occurred in ModelMBeanOperationInfo setDescriptor"));
			}
		}
	}

	/**
	* Returns a string containing the entire contents of the ModelMBeanOperationInfo in human readable form.
	*/
	public String toString()
	{
		if (tracing())
		{
			trace("ModelMBeanConstructorInfo.toString()","Executed");
		}
		String retStr =
		    "ModelMBeanOperationInfo: " + this.getName() +
		    " ; Description: " + this.getDescription() +
		    " ; Descriptor: " + this.getDescriptor() +
		    " ; ReturnType: " + this.getReturnType() +
		    " ; Signature: ";
		MBeanParameterInfo[] pTypes = this.getSignature();
		for (int i=0; i < pTypes.length; i++)
		{
			retStr = retStr.concat((pTypes[i]).getType() + ", ");
		}
		return retStr;
	}
	/**
	* Creates default descriptor for operation as follows:
	* descriptorType=operation,role=operation, name=this.getName(),displayname=this.getName().
	*/
	private Descriptor createDefaultDescriptor()
	{
		if (tracing())
		{
			trace("ModelMBeanOperationInfo.createDefaultDescriptor()","Executed");
		}
		return new DescriptorSupport(new String[] {"descriptorType=operation",
							       ("name=" + this.getName()),
							       "role=operation",
							       ("displayname=" + this.getName())});
	}


	/**
	* Tests that the descriptor is valid and adds appropriate
	* default fields not already specified.  Field values must be
	* correct for field names.  descriptorType field must be
	* "operation".  We do not check the targetType because a
	* custom implementation of ModelMBean could recognize
	* additional types beyond the "standard" ones.  The following
	* fields will be defaulted if they are not already set:
	* role=operation,displayName=this.getName()
	*/
	private boolean isValid(Descriptor inDesc)
	{
		boolean results = true;
		String badField = "none";
		// if name != this.getName
		// if (descriptorType != operation)
		// look for displayName, persistPolicy, visibility and add in
		if (inDesc == null)
		{
			results = false;
		}

		else if (!inDesc.isValid())
		{	 // checks for empty descriptors, null,
			// checks for empty name and descriptorType
			// and valid values for fields.
			results = false;
		} else
		{
			if (! ((String)inDesc.getFieldValue("name")).equalsIgnoreCase(this.getName()))
			{
				results = false;
			}
			if (! ((String)inDesc.getFieldValue("descriptorType")).equalsIgnoreCase("operation"))
			{
				results = false;
			}
			Object roleValue = inDesc.getFieldValue("role");
			if (roleValue == null)
			{
				inDesc.setField("role","operation");
			} else {
			    final String role = (String)roleValue;
			    if (!(role.equalsIgnoreCase("operation")
				  || role.equalsIgnoreCase("setter")
				  || role.equalsIgnoreCase("getter"))) {
				results = false;
				badField="role";
			    }
			}

			Object targetValue = inDesc.getFieldValue("targetType");
			if (targetValue != null) {
			    if (!(targetValue instanceof java.lang.String)) {
				results = false;
				badField="targetType";
				
			    }
			}
			if ((inDesc.getFieldValue("displayName")) == null)
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
		//      return false;
		return Trace.isSelected(Trace.LEVEL_TRACE, Trace.INFO_MODELMBEAN);
	}

	private void trace(String inClass, String inMethod, String inText)
	{
		//      System.out.println("TRACE: " + inClass + ":" + inMethod + ": " + inText);
		Trace.send(Trace.LEVEL_TRACE, Trace.INFO_MODELMBEAN, inClass,
				   inMethod,  Integer.toHexString(this.hashCode()) + " " + inText); 
	}

	private void trace(String inMethod, String inText)
	{
		trace(currClass, inMethod, inText);
	}

    /**
     * Deserializes a {@link ModelMBeanOperationInfo} from an {@link ObjectInputStream}.
     */
    private void readObject(ObjectInputStream in)
	    throws IOException, ClassNotFoundException {
      // New serial form ignores extra field "currClass"
      in.defaultReadObject();
    }


    /**
     * Serializes a {@link ModelMBeanOperationInfo} to an {@link ObjectOutputStream}.
     */
    private void writeObject(ObjectOutputStream out)
	    throws IOException {
      if (compat)
      {
        // Serializes this instance in the old serial form
        //
        ObjectOutputStream.PutField fields = out.putFields();
	fields.put("operationDescriptor", operationDescriptor);
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
