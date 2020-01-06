package com.mick.mmg;

import org.apache.commons.text.similarity.LevenshteinDetailedDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.apache.commons.text.similarity.LevenshteinResults;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void test() {
        LevenshteinDistance defaultInstance = LevenshteinDistance.getDefaultInstance();
        Integer result1 = defaultInstance.apply("dead or alive", "wanted dead or alive");
        Integer result2 = defaultInstance.apply("wanted dead or alive", "dead or alive");

        LevenshteinDetailedDistance detailedDistance = LevenshteinDetailedDistance.getDefaultInstance();
        LevenshteinResults levenshteinResults = detailedDistance.apply("dead or alive", "wanted dead or alive");
        LevenshteinResults levenshteinResults2 = detailedDistance.apply("wanted dead or alive", "dead or alive");
        LevenshteinResults levenshteinResults3 = detailedDistance.apply("bad medicine", "dead or alive");

        result1.toString();
    }
}
