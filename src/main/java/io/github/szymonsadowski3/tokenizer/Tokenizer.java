package io.github.szymonsadowski3.tokenizer;

import java.util.List;

public interface Tokenizer {
    List<String> tokenize(String text);
}
