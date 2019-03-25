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

import java.lang.reflect.Method;
import javax.script.ScriptException;

/**
 * An implementation of Callable interface that
 * invokes an instance or static Java method when
 * called.
 */
public class MethodCallable implements Callable {
  private Object target;
  private Method method;
  private boolean wrapArgs;

  // "wrapArgs" tells whether the underlying java Method
  // accepts one Object[] argument or it wants usual way of
  // passing arguments. The former method is used when you
  // want to implement a Callable that is variadic.
  public MethodCallable(Object target, Method method, boolean wrapArgs) {
    this.method = method;
    this.target = target;
    this.wrapArgs = wrapArgs;
  }

  public MethodCallable(Object target, Method method) {
    this(target, method, true);
  }

  public Object call(Object[] args) throws ScriptException {
    try {
      if (wrapArgs) {
        return method.invoke(target, new Object[] { args });
      } else {
        return method.invoke(target, args);
      }
    } catch (RuntimeException re) {
      throw re;
    } catch (Exception exp) {
      throw new ScriptException(exp);
    }
  }
}
