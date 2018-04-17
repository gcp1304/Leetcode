package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_3Test {

    private Problem_3.Solution1 solution1;
    private Problem_3.Solution2 solution2;
    private Problem_3.Solution3 solution3;

    String input = "pwwkew";
    int expectedResult = 3;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_3.Solution1();
        solution2 = new Problem_3.Solution2();
        solution3 = new Problem_3.Solution3();
    }

    @Test
    public void solution1Test() throws Exception {
        int solution1Result = solution1.lengthOfLongestSubstring(input);

        assertEquals(expectedResult, solution1Result);
    }

    @Test
    public void solution2Test() throws Exception {
        int solution2Result = solution2.lengthOfLongestSubstring(input);

        assertEquals(expectedResult, solution2Result);
    }

    @Test
    public void solution3Test() throws Exception {
        int solution3Result = solution3.lengthOfLongestSubstring(input);

        assertEquals(expectedResult, solution3Result);
    }
}