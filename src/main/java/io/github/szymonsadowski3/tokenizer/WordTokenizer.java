package io.github.szymonsadowski3.tokenizer;

        import io.github.szymonsadowski3.utils.StringUtils;

        import java.util.ArrayList;
        import java.util.List;

public class WordTokenizer implements Tokenizer {
    @Override
    public List<String> tokenize(String text) {
        String parsedText = StringUtils.removeNonLetterCharacters(text).toLowerCase();

        ArrayList<String> textLines = StringUtils.splitToLines(parsedText);
        ArrayList<String> words = textLines.stream().
                map(StringUtils::splitToWords).
                collect(ArrayList::new, List::addAll, List::addAll);

        return words;
    }
}