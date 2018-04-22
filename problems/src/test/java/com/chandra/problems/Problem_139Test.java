package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Problem_139Test {

    private Problem_139.Solution1 solution1;

    private Problem_139.Solution2 solution2;

    private Problem_139.Solution3 solution3;

    private String input = "applepenapple";
    private List<String> wordDict = Arrays.asList("apple", "pen");

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_139.Solution1();
        solution2 = new Problem_139.Solution2();
        solution3 = new Problem_139.Solution3();
    }

    @Test
    public void solution1Test() {
        assertTrue(solution1.wordBreak(input, wordDict));
    }

    @Test
    public void solution2Test() {
        assertTrue(solution2.wordBreak(input, wordDict));
    }

    @Test
    public void solution3Test() {
        assertTrue(solution3.wordBreak(input, wordDict));
    }
}