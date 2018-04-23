package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_209Test {

    Problem_209.Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_209.Solution1();
    }

    @Test
    public void solution1Test() {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;

        assertEquals(2, solution1.minSubArrayLen(s, nums));
    }
}