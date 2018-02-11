/*
 * Copyright (c) 1998, 2007, Oracle and/or its affiliates. All rights reserved.
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
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 */

package sun.rmi.rmic.iiop;

import java.util.Vector;
import sun.tools.java.CompilerError;
import sun.tools.java.ClassDefinition;
import sun.tools.java.ClassNotFound;

/**
 * RemoteType represents any non-special interface which inherits
 * from java.rmi.Remote.
 * <p>
 * The static forRemote(...) method must be used to obtain an instance, and will
 * return null if the ClassDefinition is non-conforming.
 * @author      Bryan Atsatt
 */
public class RemoteType extends InterfaceType {

    //_____________________________________________________________________
    // Public Interfaces
    //_____________________________________________________________________

    /**
     * Create an RemoteType for the given class.
     *
     * If the class is not a properly formed or if some other error occurs, the
     * return value will be null, and errors will have been reported to the
     * supplied BatchEnvironment.
     */
    public static RemoteType forRemote(ClassDefinition classDef,
                                       ContextStack stack,
                                       boolean quiet) {

        if (stack.anyErrors()) return null;

        boolean doPop = false;
        RemoteType result = null;

        try {
            // Do we already have it?

            sun.tools.java.Type theType = classDef.getType();
            Type existing = getType(theType,stack);

            if (existing != null) {

                if (!(existing instanceof RemoteType)) return null; // False hit.

                                // Yep, so return it...

                return (RemoteType) existing;
            }

            // Could this be a remote type?

            if (couldBeRemote(quiet,stack,classDef)) {

                // Yes, so check it...

                RemoteType it = new RemoteType(stack,classDef);
                putType(theType,it,stack);
                stack.push(it);
                doPop = true;

                if (it.initialize(quiet,stack)) {
                    stack.pop(true);
                    result = it;
                } else {
                    removeType(theType,stack);
                    stack.pop(false);
                }
            }
        } catch (CompilerError e) {
            if (doPop) stack.pop(false);
        }

        return result;
    }

    /**
     * Return a string describing this type.
     */
    public String getTypeDescription () {
        return "Remote interface";
    }

    //_____________________________________________________________________
    // Internal/Subclass Interfaces
    //_____________________________________________________________________

    /**
     * Create a RemoteType instance for the given class.  The resulting
     * object is not yet completely initialized.
     */
    protected RemoteType(ContextStack stack, ClassDefinition classDef) {
        super(stack,classDef,TYPE_REMOTE | TM_INTERFACE | TM_COMPOUND);
    }

    /**
     * Create a RemoteType instance for the given class.  The resulting
     * object is not yet completely initialized.
     */
    protected RemoteType(ContextStack stack, ClassDefinition classDef, int typeCode) {
        super(stack,classDef,typeCode);
    }

    //_____________________________________________________________________
    // Internal Interfaces
    //_____________________________________________________________________


    private static boolean couldBeRemote (boolean quiet, ContextStack stack,
                                          ClassDefinition classDef) {

        boolean result = false;
        BatchEnvironment env = stack.getEnv();

        try {
            if (!classDef.isInterface()) {
                failedConstraint(16,quiet,stack,classDef.getName());
            } else {
                result = env.defRemote.implementedBy(env,classDef.getClassDeclaration());
                if (!result) failedConstraint(1,quiet,stack,classDef.getName());
            }
        } catch (ClassNotFound e) {
            classNotFound(stack,e);
        }

        return result;
    }


    /**
     * Initialize this instance.
     */
    private boolean initialize (boolean quiet,ContextStack stack) {

        boolean result = false;

        // Go check it out and gather up the info we need...

        Vector directInterfaces = new Vector();
        Vector directMethods = new Vector();
        Vector directConstants = new Vector();

        if (isConformingRemoteInterface(directInterfaces,
                                        directMethods,
                                        directConstants,
                                        quiet,
                                        stack)){

            // We're ok, so pass 'em up...

            result = initialize(directInterfaces,directMethods,directConstants,stack,quiet);
        }

        return result;
    }

    /**
     * Check to ensure that the interface and all it's methods and arguments
     * conforms to the RMI/IDL java subset for remote interfaces as defined
     * by the "Java to IDL Mapping" specification, section 4.
     * @param directInterfaces All directly implmented interfaces will be
     *   added to this list.
     * @param directMethods All directly implemented methods (other than
     *  constructors and initializers) will be added to this list.
     * @param directConstants All constants defined by theInterface will be
     *  added to this list.
     * @param quiet True if should not report constraint failures.
     * @return true if constraints satisfied, false otherwise.
     */
    private boolean isConformingRemoteInterface (       Vector directInterfaces,
                                                        Vector directMethods,
                                                        Vector directConstants,
                                                        boolean quiet,
                                                        ContextStack stack) {

        ClassDefinition theInterface = getClassDefinition();

        try {

            // Get all remote interfaces...

            if (addRemoteInterfaces(directInterfaces,false,stack) == null ) {
                return false;
            }

            // Make sure all constants are conforming...

            if (!addAllMembers(directConstants,true,quiet,stack)) {
                return false;
            }

            // Now, collect up all methods...

            if (addAllMethods(theInterface,directMethods,true,quiet,stack) == null) {
                // Failed a constraint check...
                return false;
            }

            // Now walk 'em, ensuring each is a valid remote method...

            boolean methodsConform = true;
            for (int i = 0; i < directMethods.size(); i++) {
                if (! isConformingRemoteMethod((Method) directMethods.elementAt(i),quiet)) {
                    methodsConform = false;
                }
            }
            if (!methodsConform) {
                return false;
            }
        } catch (ClassNotFound e) {
            classNotFound(stack,e);
            return false;
        }

        return true;
    }
}
