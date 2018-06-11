package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_1Test {

    private static Problem_1.Solution1 solution1;
    private int[] nums = new int[] {2, 7, 11, 15};
    private int[] expectedPassResult = new int[] {0,1};

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_1.Solution1();
    }

    @Test
    public void testPass() throws Exception {
        int targetPass = 9;
        int[] actualResult = solution1.twoSum(nums, targetPass);
        assertArrayEquals(expectedPassResult, actualResult);
    }
}