/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.jshell.tool;

import java.util.List;
import static java.util.Comparator.comparing;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import jdk.internal.jshell.tool.JShellTool.CompletionProvider;
import jdk.jshell.SourceCodeAnalysis;
import jdk.jshell.SourceCodeAnalysis.Suggestion;

class ContinuousCompletionProvider implements CompletionProvider {

    static final BiPredicate<String, String> STARTSWITH_MATCHER = String::startsWith;
    static final BiPredicate<String, String> PERFECT_MATCHER = String::equals;

    private final Supplier<Map<String, CompletionProvider>> wordCompletionProviderSupplier;
    private final BiPredicate<String, String> matcher;

    ContinuousCompletionProvider(
            Map<String, CompletionProvider> wordCompletionProvider,
            BiPredicate<String, String> matcher) {
        this(() -> wordCompletionProvider, matcher);
    }

    ContinuousCompletionProvider(
            Supplier<Map<String, CompletionProvider>> wordCompletionProviderSupplier,
            BiPredicate<String, String> matcher) {
        this.wordCompletionProviderSupplier = wordCompletionProviderSupplier;
        this.matcher = matcher;
    }

    @Override
    public List<Suggestion> completionSuggestions(String input, int cursor, int[] anchor) {
        String prefix = input.substring(0, cursor);
        int space = prefix.indexOf(' ');

        Stream<SourceCodeAnalysis.Suggestion> result;

        Map<String, CompletionProvider> wordCompletionProvider = wordCompletionProviderSupplier.get();

        if (space == (-1)) {
            result = wordCompletionProvider.keySet().stream()
                    .distinct()
                    .filter(key -> key.startsWith(prefix))
                    .map(key -> new JShellTool.ArgSuggestion(key + " "));
            anchor[0] = 0;
        } else {
            String rest = prefix.substring(space + 1);
            String word = prefix.substring(0, space);

            List<CompletionProvider> candidates = wordCompletionProvider.entrySet().stream()
                    .filter(e -> matcher.test(e.getKey(), word))
                    .map(Map.Entry::getValue)
                    .toList();
            if (candidates.size() == 1) {
                result = candidates.get(0).completionSuggestions(rest, cursor - space - 1, anchor).stream();
            } else {
                result = Stream.empty();
            }
            anchor[0] += space + 1;
        }

        return result.sorted(comparing(Suggestion::continuation))
                     .toList();
    }

}
