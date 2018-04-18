package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_10Test {

    String str = "abc";
    String pat = ".*abc";

    private Problem_10.Solution1 solution1;
    private Problem_10.Solution2 solution2;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_10.Solution1();
        solution2 = new Problem_10.Solution2();
    }

    @Test
    public void solution1Test() throws Exception {
        assertEquals(solution1.isMatch(str, pat), true);
    }

    @Test
    public void solution2Test() throws Exception {
        assertEquals(solution2.isMatch(str, pat), true);
    }
}