/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (C) 2004-2011
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sun.xml.internal.rngom.binary;

import org.xml.sax.SAXException;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public abstract class BinaryPattern extends Pattern {
  protected final Pattern p1;
  protected final Pattern p2;

  BinaryPattern(boolean nullable, int hc, Pattern p1, Pattern p2) {
    super(nullable, Math.max(p1.getContentType(), p2.getContentType()), hc);
    this.p1 = p1;
    this.p2 = p2;
  }

  void checkRecursion(int depth) throws SAXException {
    p1.checkRecursion(depth);
    p2.checkRecursion(depth);
  }

  void checkRestrictions(int context, DuplicateAttributeDetector dad, Alphabet alpha)
    throws RestrictionViolationException {
    p1.checkRestrictions(context, dad, alpha);
    p2.checkRestrictions(context, dad, alpha);
  }

  boolean samePattern(Pattern other) {
    if (getClass() != other.getClass())
      return false;
    BinaryPattern b = (BinaryPattern)other;
    return p1 == b.p1 && p2 == b.p2;
  }

  public final Pattern getOperand1() {
    return p1;
  }

  public final Pattern getOperand2() {
    return p2;
  }

  /**
   * Adds all the children of this pattern to the given collection.
   *
   * <p>
   * For example, if this pattern is (A|B|C), it adds A, B, and C
   * to the collection, even though internally it's represented
   * as (A|(B|C)).
   */
  public final void fillChildren( Collection col ) {
    fillChildren(getClass(),p1,col);
    fillChildren(getClass(),p2,col);
  }

  /**
   * Same as {@link #fillChildren(Collection)} but returns an array.
   */
  public final Pattern[] getChildren() {
      List lst = new ArrayList();
      fillChildren(lst);
      return (Pattern[]) lst.toArray(new Pattern[lst.size()]);
  }

  private void fillChildren( Class c, Pattern p, Collection col ) {
    if(p.getClass()==c) {
      BinaryPattern bp = (BinaryPattern)p;
      bp.fillChildren(c,bp.p1,col);
      bp.fillChildren(c,bp.p2,col);
    } else {
      col.add(p);
    }
  }
}
