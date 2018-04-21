package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_128Test {

    private Problem_128.Solution1 solution1;

    private Problem_128.Solution2 solution2;

    private Problem_128.Solution3 solution3;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_128.Solution1();
        solution2 = new Problem_128.Solution2();
        solution3 = new Problem_128.Solution3();
    }

    int[] input = new int[]{1,0,-1};//{100, 4, 200, 1, 3, 2};
    int expectedResult = 3;//4;

    @Test
    public void solution1Test() throws Exception {
        assertEquals(expectedResult, solution1.longestConsecutive(input));
    }

    @Test
    public void solution2Test() throws Exception {
        assertEquals(expectedResult, solution2.longestConsecutive(input));
    }

    @Test
    public void solution3Test() throws Exception {
        assertEquals(expectedResult, solution3.longestConsecutive(input));
    }
}