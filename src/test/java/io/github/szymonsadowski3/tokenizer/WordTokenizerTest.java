package io.github.szymonsadowski3.tokenizer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;


public class WordTokenizerTest {

    private static WordTokenizer wordTokenizer = new WordTokenizer();

    @org.junit.Test
    public void testSimpleTokenize() {
        List<String> tokens = wordTokenizer.tokenize("Platon made bamboo boats.");

        assertThat(tokens, containsInAnyOrder("platon", "made", "bamboo", "boats"));
    }

    @org.junit.Test
    public void testMultilineTokenize() {
        List<String> tokens = wordTokenizer.tokenize("Platon\n made\n bamboo\n boats.");

        assertThat(tokens, containsInAnyOrder("platon", "made", "bamboo", "boats"));
    }

    @org.junit.Test
    public void testExclamationMarksTokenize() {
        List<String> tokens = wordTokenizer.tokenize("Platon! made? bamboo, boats...");

        assertThat(tokens, containsInAnyOrder("platon", "made", "bamboo", "boats"));
    }

    @org.junit.Test
    public void testEmptyTokenizeNoExceptions() {
        wordTokenizer.tokenize("");
    }

    @org.junit.Test
    public void testBlankTokenizeNoExceptions() {
        wordTokenizer.tokenize("    ");
    }
}