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

import com.sun.xml.internal.rngom.binary.visitor.PatternFunction;
import com.sun.xml.internal.rngom.binary.visitor.PatternVisitor;
import com.sun.xml.internal.rngom.nc.NameClass;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public final class ElementPattern extends Pattern {
  private Pattern p;
  private NameClass origNameClass;
  private NameClass nameClass;
  private boolean expanded = false;
  private boolean checkedRestrictions = false;
  private Locator loc;

  ElementPattern(NameClass nameClass, Pattern p, Locator loc) {
    super(false,
          ELEMENT_CONTENT_TYPE,
          combineHashCode(ELEMENT_HASH_CODE,
                          nameClass.hashCode(),
                          p.hashCode()));
    this.nameClass = nameClass;
    this.origNameClass = nameClass;
    this.p = p;
    this.loc = loc;
  }

    @Override
  void checkRestrictions(int context, DuplicateAttributeDetector dad, Alphabet alpha)
    throws RestrictionViolationException {
    if (alpha != null)
      alpha.addElement(origNameClass);
    if (checkedRestrictions)
      return;
    switch (context) {
    case DATA_EXCEPT_CONTEXT:
      throw new RestrictionViolationException("data_except_contains_element");
    case LIST_CONTEXT:
      throw new RestrictionViolationException("list_contains_element");
    case ATTRIBUTE_CONTEXT:
      throw new RestrictionViolationException("attribute_contains_element");
    }
    checkedRestrictions = true;
    try {
      p.checkRestrictions(ELEMENT_CONTEXT, new DuplicateAttributeDetector(), null);
    }
    catch (RestrictionViolationException e) {
      checkedRestrictions = false;
      e.maybeSetLocator(loc);
      throw e;
    }
  }

    @Override
  Pattern expand(SchemaPatternBuilder b) {
    if (!expanded) {
      expanded = true;
      p = p.expand(b);
      if (p.isNotAllowed())
        nameClass = NameClass.NULL;
    }
    return this;
  }

  boolean samePattern(Pattern other) {
    if (!(other instanceof ElementPattern))
      return false;
    ElementPattern ep = (ElementPattern)other;
    return nameClass.equals(ep.nameClass) && p == ep.p;
  }

    @Override
  void checkRecursion(int depth) throws SAXException {
    p.checkRecursion(depth + 1);
  }

  public void accept(PatternVisitor visitor) {
    visitor.visitElement(nameClass, p);
  }

  public Object apply(PatternFunction f) {
    return f.caseElement(this);
  }

  void setContent(Pattern p) {
    this.p = p;
  }

  public Pattern getContent() {
    return p;
  }

  public NameClass getNameClass() {
    return nameClass;
  }

  public Locator getLocator() {
    return loc;
  }
}
