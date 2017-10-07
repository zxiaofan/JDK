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
import com.sun.xml.internal.rngom.nc.SimpleNameClass;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public final class AttributePattern extends Pattern {
  private NameClass nameClass;
  private Pattern p;
  private Locator loc;

  AttributePattern(NameClass nameClass, Pattern value, Locator loc) {
    super(false,
          EMPTY_CONTENT_TYPE,
          combineHashCode(ATTRIBUTE_HASH_CODE,
                          nameClass.hashCode(),
                          value.hashCode()));
    this.nameClass = nameClass;
    this.p = value;
    this.loc = loc;
  }

  Pattern expand(SchemaPatternBuilder b) {
    Pattern ep = p.expand(b);
    if (ep != p)
      return b.makeAttribute(nameClass, ep, loc);
    else
      return this;
  }

  void checkRestrictions(int context, DuplicateAttributeDetector dad, Alphabet alpha)
    throws RestrictionViolationException {
    switch (context) {
    case START_CONTEXT:
      throw new RestrictionViolationException("start_contains_attribute");
    case ELEMENT_CONTEXT:
      if (nameClass.isOpen())
        throw new RestrictionViolationException("open_name_class_not_repeated");
      break;
    case ELEMENT_REPEAT_GROUP_CONTEXT:
      throw new RestrictionViolationException("one_or_more_contains_group_contains_attribute");
    case ELEMENT_REPEAT_INTERLEAVE_CONTEXT:
      throw new RestrictionViolationException("one_or_more_contains_interleave_contains_attribute");
    case LIST_CONTEXT:
      throw new RestrictionViolationException("list_contains_attribute");
    case ATTRIBUTE_CONTEXT:
      throw new RestrictionViolationException("attribute_contains_attribute");
    case DATA_EXCEPT_CONTEXT:
      throw new RestrictionViolationException("data_except_contains_attribute");
    }
    if (!dad.addAttribute(nameClass)) {
      if (nameClass instanceof SimpleNameClass)
        throw new RestrictionViolationException("duplicate_attribute_detail", ((SimpleNameClass)nameClass).name);
      else
        throw new RestrictionViolationException("duplicate_attribute");
    }
    try {
      p.checkRestrictions(ATTRIBUTE_CONTEXT, null, null);
    }
    catch (RestrictionViolationException e) {
      e.maybeSetLocator(loc);
      throw e;
    }
  }

  boolean samePattern(Pattern other) {
    if (!(other instanceof AttributePattern))
      return false;
    AttributePattern ap = (AttributePattern)other;
    return nameClass.equals(ap.nameClass)&& p == ap.p;
  }

  void checkRecursion(int depth) throws SAXException {
    p.checkRecursion(depth);
  }

  public void accept(PatternVisitor visitor) {
    visitor.visitAttribute(nameClass, p);
  }

  public Object apply(PatternFunction f) {
    return f.caseAttribute(this);
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
