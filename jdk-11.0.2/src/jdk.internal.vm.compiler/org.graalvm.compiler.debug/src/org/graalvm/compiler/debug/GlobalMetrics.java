/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.debug;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import jdk.internal.vm.compiler.collections.EconomicMap;
import jdk.internal.vm.compiler.collections.MapCursor;
import jdk.internal.vm.compiler.collections.Pair;
import org.graalvm.compiler.options.OptionValues;

/**
 * Metric values that can be {@linkplain #add(DebugContext) updated} by multiple threads.
 */
public class GlobalMetrics {
    long[] values;

    /**
     * Adds the values in {@code debug} to the values in this object.
     */
    public synchronized void add(DebugContext debug) {
        values = debug.addValuesTo(values);
    }

    /**
     * Clears all values in this object.
     */
    public void clear() {
        values = null;
    }

    /**
     * Creates and returns a sorted map from metric names to their values in this object.
     */
    public EconomicMap<MetricKey, Long> asKeyValueMap() {
        List<MetricKey> keys = KeyRegistry.getKeys();
        Collections.sort(keys, MetricKey.NAME_COMPARATOR);
        EconomicMap<MetricKey, Long> res = EconomicMap.create(keys.size());
        long[] vals = values;
        for (MetricKey key : keys) {
            int index = ((AbstractKey) key).getIndex();
            if (vals == null || index >= vals.length) {
                res.put(key, 0L);
            } else {
                res.put(key, vals[index]);
            }
        }
        return res;
    }

    /**
     * Prints the values in the object to the file specified by
     * {@link DebugOptions#AggregatedMetricsFile} if present otherwise to
     * {@link DebugContext#DEFAULT_LOG_STREAM}.
     */
    public void print(OptionValues options) {
        long[] vals = values;
        if (vals != null) {
            EconomicMap<MetricKey, Long> map = asKeyValueMap();
            String metricsFile = DebugOptions.AggregatedMetricsFile.getValue(options);
            boolean csv = metricsFile != null && (metricsFile.endsWith(".csv") || metricsFile.endsWith(".CSV"));
            try (PrintStream p = metricsFile == null ? DebugContext.DEFAULT_LOG_STREAM : new PrintStream(Files.newOutputStream(Paths.get(metricsFile)))) {
                if (!csv) {
                    if (!map.isEmpty()) {
                        p.println("++ Aggregated Metrics ++");
                    }
                }
                String csvFormat = CSVUtil.buildFormatString("%s", "%s", "%s");
                MapCursor<MetricKey, Long> e = map.getEntries();
                while (e.advance()) {
                    MetricKey key = e.getKey();
                    if (csv) {
                        Pair<String, String> valueAndUnit = key.toCSVFormat(e.getValue());
                        CSVUtil.Escape.println(p, csvFormat, key.getName(), valueAndUnit.getLeft(), valueAndUnit.getRight());
                    } else {
                        p.println(key.getName() + "=" + key.toHumanReadableFormat(e.getValue()));
                    }
                }
                if (!csv) {
                    if (!map.isEmpty()) {
                        p.println("-- Aggregated Metrics --");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (DebugOptions.ListMetrics.getValue(options)) {
            PrintStream p = System.out;
            p.println("++ Metric Keys ++");
            List<MetricKey> keys = KeyRegistry.getKeys();
            Collections.sort(keys, MetricKey.NAME_COMPARATOR);
            for (MetricKey key : keys) {
                String name = key.getDocName();
                if (name != null) {
                    String doc = key.getDoc();
                    if (doc != null) {
                        p.println(name + ": " + doc);
                    } else {
                        p.println(name);
                    }
                }
            }
            p.println("-- Metric Keys --");
        }
    }
}
