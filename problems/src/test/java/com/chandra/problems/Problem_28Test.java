package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_28Test {

    private Problem_28.Solution1 solution1;
    private Problem_28.Solution2 solution2;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_28.Solution1();
        solution2 = new Problem_28.Solution2();
    }

    private String haystack1 = "hello", needle1="ll";
    private String haystack2 = "aaaaa", needle2="bba";
    private int expectedOutput1 = 2, expectedOutput2 = -1;

    @Test
    public void solution1Test() {
        assertEquals(expectedOutput1, solution1.strStr(haystack1, needle1));
        assertEquals(expectedOutput2, solution1.strStr(haystack2, needle2));
    }

    @Test
    public void solution2Test() {
        assertEquals(expectedOutput1, solution2.strStr(haystack1, needle1));
        assertEquals(expectedOutput2, solution2.strStr(haystack2, needle2));
    }
}