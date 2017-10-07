/*
 * Copyright (c) 2004, 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jstat;

import java.util.*;
import java.net.*;
import java.io.*;

/**
 * A class for listing the available options in the jstat_options file.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class OptionLister {
    private static final boolean debug = false;
    private List<URL> sources;

    public OptionLister(List<URL> sources) {
        this.sources = sources;
    }

    public void print(PrintStream ps) {
        Comparator<OptionFormat> c = new Comparator<OptionFormat>() {
               public int compare(OptionFormat o1, OptionFormat o2) {
                   OptionFormat of1 = o1;
                   OptionFormat of2 = o2;
                   return (of1.getName().compareTo(of2.getName()));
               }
        };

        Set<OptionFormat> options = new TreeSet<OptionFormat>(c);

        for (URL u : sources) {
            try {
                Reader r = new BufferedReader(
                        new InputStreamReader(u.openStream()));
                Set<OptionFormat> s = new Parser(r).parseOptions();
                options.addAll(s);
            } catch (IOException e) {
                if (debug) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            } catch (ParserException e) {
                // Exception in parsing the options file.
                System.err.println(u + ": " + e.getMessage());
                System.err.println("Parsing of " + u + " aborted");
            }
        }

        for ( OptionFormat of : options) {
            if (of.getName().compareTo("timestamp") == 0) {
              // ignore the special timestamp OptionFormat.
              continue;
            }
            ps.println("-" + of.getName());
        }
    }
}
