package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_13Test {

    String input = "MCMXCVI";

    private Problem_13.Solution1 solution1;
    private Problem_13.Solution2 solution2;
    private Problem_13.Solution3 solution3;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_13.Solution1();
        solution2 = new Problem_13.Solution2();
        solution3 = new Problem_13.Solution3();
    }

    @Test
    public void solution1Test() throws Exception {
        assertEquals(solution1.romanToInt(input), 1996);
    }

    @Test
    public void solution2Test() throws Exception {
        assertEquals(solution2.romanToInt(input), 1996);
    }

    @Test
    public void solution3Test() throws Exception {
        assertEquals(solution3.romanToInt(input), 1996);
    }
}