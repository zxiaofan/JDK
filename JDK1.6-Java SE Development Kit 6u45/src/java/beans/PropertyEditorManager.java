/*
 * %W% %E%
 *
 * Copyright (c) 1996, 2010, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.beans;

import java.util.Hashtable;

/**
 * The PropertyEditorManager can be used to locate a property editor for
 * any given type name.  This property editor must support the
 * java.beans.PropertyEditor interface for editing a given object.
 * <P>
 * The PropertyEditorManager uses three techniques for locating an editor
 * for a given type.  First, it provides a registerEditor method to allow
 * an editor to be specifically registered for a given type.  Second it
 * tries to locate a suitable class by adding "Editor" to the full 
 * qualified classname of the given type (e.g. "foo.bah.FozEditor").
 * Finally it takes the simple classname (without the package name) adds
 * "Editor" to it and looks in a search-path of packages for a matching
 * class.
 * <P>
 * So for an input class foo.bah.Fred, the PropertyEditorManager would
 * first look in its tables to see if an editor had been registered for
 * foo.bah.Fred and if so use that.  Then it will look for a
 * foo.bah.FredEditor class.  Then it will look for (say) 
 * standardEditorsPackage.FredEditor class.
 * <p>
 * Default PropertyEditors will be provided for the Java primitive types
 * "boolean", "byte", "short", "int", "long", "float", and "double"; and
 * for the classes java.lang.String. java.awt.Color, and java.awt.Font.
 */

public class PropertyEditorManager {

    /**
     * Register an editor class to be used to edit values of
     * a given target class.
     * 
     * <p>First, if there is a security manager, its <code>checkPropertiesAccess</code> 
     * method is called. This could result in a SecurityException.
     * 
     * @param targetType the Class object of the type to be edited
     * @param editorClass the Class object of the editor class.  If
     *	   this is null, then any existing definition will be removed.
     * @exception  SecurityException  if a security manager exists and its  
     *             <code>checkPropertiesAccess</code> method doesn't allow setting
     *              of system properties.
     * @see SecurityManager#checkPropertiesAccess
     */

    public static void registerEditor(Class<?> targetType, Class<?> editorClass) {
	SecurityManager sm = System.getSecurityManager();
	if (sm != null) {
	    sm.checkPropertiesAccess();
	}
	if (editorClass == null) {
            getRegistry().remove(targetType);
	} else {
            getRegistry().put(targetType, editorClass);
	}
    }

    /**
     * Locate a value editor for a given target type.
     *
     * @param targetType  The Class object for the type to be edited
     * @return An editor object for the given target class. 
     * The result is null if no suitable editor can be found.
     */

    public static PropertyEditor findEditor(Class<?> targetType) {
	Class editorClass = (Class) getRegistry().get(targetType);
	if (editorClass != null) {
	    try {
		Object o = editorClass.newInstance();
        	return (PropertyEditor)o;
	    } catch (Exception ex) {
	 	System.err.println("Couldn't instantiate type editor \"" +
			editorClass.getName() + "\" : " + ex);
	    }
	}

	// Now try adding "Editor" to the class name.

	String editorName = targetType.getName() + "Editor";
	try {
	    return (PropertyEditor) Introspector.instantiate(targetType, editorName);
	} catch (Exception ex) {
	   // Silently ignore any errors.
	}

	// Now try looking for <searchPath>.fooEditor
	editorName = targetType.getName();
   	while (editorName.indexOf('.') > 0) {
	    editorName = editorName.substring(editorName.indexOf('.')+1);
	}
        String[] searchPath = getEditorSearchPath();
	for (int i = 0; i < searchPath.length; i++) {
	    String name = searchPath[i] + "." + editorName + "Editor";
	    try {
	        return (PropertyEditor) Introspector.instantiate(targetType, name);
	    } catch (Exception ex) {
	       // Silently ignore any errors.
	    }
	}

	// We couldn't find a suitable Editor.
	return null;
    }

    /**
     * Gets the package names that will be searched for property editors.
     *
     * @return  The array of package names that will be searched in
     *		order to find property editors.
     * <p>     The default value for this array is implementation-dependent,
     *         e.g. Sun implementation initially sets to  {"sun.beans.editors"}.
     */
    public static synchronized String[] getEditorSearchPath() {
	// Return a copy of the searchPath.
	String result[] = new String[searchPath.length];
	for (int i = 0; i < searchPath.length; i++) {
	    result[i] = searchPath[i];
	}
	return result;
    }

    /**
     * Change the list of package names that will be used for
     *		finding property editors.
     * 
     * <p>First, if there is a security manager, its <code>checkPropertiesAccess</code> 
     * method is called. This could result in a SecurityException.
     *
     * @param path  Array of package names.
     * @exception  SecurityException  if a security manager exists and its  
     *             <code>checkPropertiesAccess</code> method doesn't allow setting
     *              of system properties.
     * @see SecurityManager#checkPropertiesAccess
     */

    public static synchronized void setEditorSearchPath(String path[]) {
	SecurityManager sm = System.getSecurityManager();
	if (sm != null) {
	    sm.checkPropertiesAccess();
	}
	getRegistry();
	if (path == null) {
	    path = new String[0];
	}
	searchPath = path;
    }

    private static void load(Class targetType, String name) {
	String editorName = name;
	for (int i = 0; i < searchPath.length; i++) {
	    try {
	        editorName = searchPath[i] + "." + name;
	        Class cls = Class.forName(editorName);
	        registry.put(targetType, cls);
		return;
	    } catch (Exception ex) {
		// Drop through and try next package.
	    }
	}
	// This shouldn't happen.
	System.err.println("load of " + editorName + " failed");
    }


    private static synchronized Hashtable getRegistry() {
	if (registry != null) {
            return registry;
	}
	registry = new Hashtable();
	load(Byte.TYPE, "ByteEditor");
	load(Short.TYPE, "ShortEditor");
	load(Integer.TYPE, "IntEditor");
	load(Long.TYPE ,"LongEditor");
	load(Boolean.TYPE, "BoolEditor");
	load(Float.TYPE, "FloatEditor");
	load(Double.TYPE, "DoubleEditor");
        return registry;
    }

    private static String[] searchPath = { "sun.beans.editors" };
    private static Hashtable registry;
}
