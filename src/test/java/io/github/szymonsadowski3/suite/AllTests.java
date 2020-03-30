package io.github.szymonsadowski3.suite;

import io.github.szymonsadowski3.grouper.GrouperTest;
import io.github.szymonsadowski3.tokenizer.WordTokenizerTest;
import io.github.szymonsadowski3.type.VowelSetAndLengthPairTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GrouperTest.class,
        WordTokenizerTest.class,
        VowelSetAndLengthPairTest.class,
})

public class AllTests {
}
