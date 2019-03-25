/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.utilities.soql;

import javax.script.Invocable;
import javax.script.ScriptException;

/**
 * This Callable implementation invokes a script
 * function of given name when called. If the target
 * object is non-null, script "method" is invoked, else
 * a "global" script function is invoked.
 */
public class InvocableCallable implements Callable {
  private Object target;
  private String name;
  private Invocable invocable;

  public InvocableCallable(Object target, String name,
    Invocable invocable) {
    this.target = target;
    this.name = name;
    this.invocable = invocable;
  }

  public Object call(Object[] args) throws ScriptException {
    try {
      if (target == null) {
        return invocable.invokeFunction(name, args);
      } else {
        return invocable.invokeMethod(target, name, args);
      }
    } catch (NoSuchMethodException nme) {
      throw new ScriptException(nme);
    }
  }
}
