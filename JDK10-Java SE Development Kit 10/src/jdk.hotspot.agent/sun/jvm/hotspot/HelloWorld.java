/*
 * Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot;

import java.lang.reflect.*;

public class HelloWorld {
  private static String helloWorldString = "Hello, world!";
  private static volatile int helloWorldTrigger = 0;
  private static final boolean useMethodInvoke = false;
  private static Object lock = new Object();

  public static void main(String[] args) {
    int foo = a();

    System.out.println("HelloWorld exiting. a() = " + foo);
  }

  private static int a() {
    return 1 + b();
  }

  private static int b() {
    return 1 + c();
  }

  private static int c() {
    return 1 + d("Hi");
  }

  private static int d(String x) {
    System.out.println("HelloWorld.d() received \"" + x + "\" as argument");
    synchronized(lock) {
      if (useMethodInvoke) {
        try {
          Method method = HelloWorld.class.getMethod("e");
          Integer result = (Integer) method.invoke(null, new Object[0]);
          return result.intValue();
        }
        catch (Exception e) {
          throw new RuntimeException(e.toString());
        }
      } else {

        int i = fib(10); // 89
        long l = i;
        float f = i;
        double d = i;
        char c = (char) i;
        short s = (short) i;
        byte b = (byte) i;

        int ret = e();

        System.out.println("Tenth Fibonacci number in all formats: " +
                           i + ", " +
                           l + ", " +
                           f + ", " +
                           d + ", " +
                           c + ", " +
                           s + ", " +
                           b);

        return ret;
      }
    }
  }

  public static int e() {
    System.out.println("Going to sleep...");

    int i = 0;

    while (helloWorldTrigger == 0) {
      if (++i == 1000000) {
        System.gc();
      }
    }

    System.out.println(helloWorldString);

    while (helloWorldTrigger != 0) {
    }

    return i;
  }

  // Tree-recursive implementation for test
  public static int fib(int n) {
    if (n < 2) {
      return 1;
    }
    return fib(n - 1) + fib(n - 2);
  }
}
