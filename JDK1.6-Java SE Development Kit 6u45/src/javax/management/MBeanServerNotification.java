/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.management;


/**
 * Represents a notification emitted by the MBean server through the MBeanServerDelegate MBean. 
 * The MBean Server emits the following types of notifications: MBean registration, MBean
 * de-registration.
 * <P>
 * To receive to MBeanServerNotifications, you need to be declared as listener to
 * the {@link javax.management.MBeanServerDelegate javax.management.MBeanServerDelegate} MBean
 * that represents the MBeanServer. The ObjectName of the MBeanServerDelegate is:
 * <CODE>JMImplementation:type=MBeanServerDelegate</CODE>.
 *
 * @since 1.5
 */
 public class MBeanServerNotification extends Notification   { 
     

     /* Serial version */
     private static final long serialVersionUID = 2876477500475969677L;

     /**
      * Notification type denoting that an MBean has been registered. Value is "JMX.mbean.registered".
      */  
     public static final String REGISTRATION_NOTIFICATION = "JMX.mbean.registered" ;
     
     /**
      * Notification type denoting that an MBean has been unregistered. Value is "JMX.mbean.unregistered".
      */  
     public static final String UNREGISTRATION_NOTIFICATION = "JMX.mbean.unregistered" ;
          

     /** 
      * @serial The object names of the MBeans concerned by this notification 
      */
     private final ObjectName objectName;
     

     /**
      * Creates an MBeanServerNotification object specifying object names of
      * the MBeans that caused the notification and the specified notification type.
      *
      * @param type A string denoting the type of the
      * notification. Set it to one these values: {@link
      * #REGISTRATION_NOTIFICATION}, {@link
      * #UNREGISTRATION_NOTIFICATION}.
      * @param source The MBeanServerNotification object responsible
      * for forwarding MBean server notification.
      * @param sequenceNumber A sequence number that can be used to order
      * received notifications.
      * @param objectName The object name of the MBean that caused the notification.
      *
      */          
     public MBeanServerNotification(String type, Object source, long sequenceNumber, ObjectName objectName ) { 
	 super (type,source,sequenceNumber) ;
	 this.objectName =  objectName ;
     } 
     
     /**
      * Returns the  object name of the MBean that caused the notification.
      *
      * @return the object name of the MBean that caused the notification.
      */
     public ObjectName getMBeanName()  { 
	 return objectName ;
     } 

 }
