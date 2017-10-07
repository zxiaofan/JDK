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

import sun.tools.java.ClassNotFound;
import sun.tools.java.CompilerError;
import sun.tools.java.Identifier;
import sun.tools.java.ClassDefinition;

/**
 * SpecialClassType represents any one of the following types:
 * <pre>
 *    java.lang.Object
 *    java.lang.String
 * </pre>
 * all of which are treated as special cases.
 * <p>
 * The static forSpecial(...) method must be used to obtain an instance, and
 * will return null if the type is non-conforming.
 *
 * @author      Bryan Atsatt
 */
public class SpecialClassType extends ClassType {

    //_____________________________________________________________________
    // Public Interfaces
    //_____________________________________________________________________

    /**
     * Create a SpecialClassType object for the given class.
     *
     * If the class is not a properly formed or if some other error occurs, the
     * return value will be null, and errors will have been reported to the
     * supplied BatchEnvironment.
     */
    public static SpecialClassType forSpecial (ClassDefinition theClass,
                                               ContextStack stack) {
        if (stack.anyErrors()) return null;

        sun.tools.java.Type type = theClass.getType();

        // Do we already have it?

        String typeKey = type.toString() + stack.getContextCodeString();

        Type existing = getType(typeKey,stack);

        if (existing != null) {

            if (!(existing instanceof SpecialClassType)) return null; // False hit.

            // Yep, so return it...

            return (SpecialClassType) existing;
        }

        // Is it a special type?

        int typeCode = getTypeCode(type,theClass,stack);

        if (typeCode != TYPE_NONE) {

            // Yes...

            SpecialClassType result = new SpecialClassType(stack,typeCode,theClass);
            putType(typeKey,result,stack);
            stack.push(result);
            stack.pop(true);
            return result;

        } else {

            return null;
        }
    }

    /**
     * Return a string describing this type.
     */
    public String getTypeDescription () {
        return "Special class";
    }

    //_____________________________________________________________________
    // Subclass/Internal Interfaces
    //_____________________________________________________________________

    /**
     * Create an SpecialClassType instance for the given class.
     */
    private SpecialClassType(ContextStack stack, int typeCode,
                             ClassDefinition theClass) {
        super(stack,typeCode | TM_SPECIAL_CLASS | TM_CLASS | TM_COMPOUND, theClass);
        Identifier id = theClass.getName();
        String idlName = null;
        String[] idlModuleName = null;
        boolean constant = stack.size() > 0 && stack.getContext().isConstant();

        // Set names...

        switch (typeCode) {
        case TYPE_STRING:   {
            idlName = IDLNames.getTypeName(typeCode,constant);
            if (!constant) {
                idlModuleName = IDL_CORBA_MODULE;
            }
            break;
        }

        case TYPE_ANY:   {
            idlName = IDL_JAVA_LANG_OBJECT;
            idlModuleName = IDL_JAVA_LANG_MODULE;
            break;
        }
        }

        setNames(id,idlModuleName,idlName);

        // Init parents...

        if (!initParents(stack)) {

            // Should not be possible!

            throw new CompilerError("SpecialClassType found invalid parent.");
        }

        // Initialize CompoundType...

        initialize(null,null,null,stack,false);
    }

    private static int getTypeCode(sun.tools.java.Type type, ClassDefinition theClass, ContextStack stack) {
        if (type.isType(TC_CLASS)) {
            Identifier id = type.getClassName();
            if (id == idJavaLangString) return TYPE_STRING;
            if (id == idJavaLangObject) return TYPE_ANY;
        }
        return TYPE_NONE;
    }
}
