/*
 * Copyright (c) 2004, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jconsole.inspector;

import javax.management.*;
import java.util.ArrayList;

import sun.tools.jconsole.MBeansTab;

@SuppressWarnings("serial")
public class XMBeanOperations extends XOperations {

    public XMBeanOperations(MBeansTab mbeansTab) {
        super(mbeansTab);
    }

    protected MBeanOperationInfo[] updateOperations(MBeanOperationInfo[] operations) {
        //remove get,set and is
        ArrayList<MBeanOperationInfo> mbeanOperations =
        new ArrayList<MBeanOperationInfo>(operations.length);
        for(MBeanOperationInfo operation : operations) {
            if (!( (operation.getSignature().length == 0 &&
                    operation.getName().startsWith("get") &&
                    !operation.getReturnType().equals("void"))  ||
                   (operation.getSignature().length == 1 &&
                    operation.getName().startsWith("set") &&
                    operation.getReturnType().equals("void")) ||
                   (operation.getName().startsWith("is") &&
                    operation.getReturnType().equals("boolean"))
                   ) ) {
                mbeanOperations.add(operation);
            }
        }
        return mbeanOperations.toArray(new MBeanOperationInfo[0]);
    }

}
