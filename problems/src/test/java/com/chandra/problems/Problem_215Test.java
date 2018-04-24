package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_215Test {

    Problem_215.Solution1 solution1;
    Problem_215.Solution2 solution2;
    Problem_215.Solution3 solution3;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_215.Solution1();
        solution2 = new Problem_215.Solution2();
        solution3 = new Problem_215.Solution3();
    }

    int[] nums = {3,2,1,5,6,4};

    @Test
    public void solution1Test() {
        assertEquals(5, solution1.findKthLargest(nums, 2));
    }

    @Test
    public void solution2Test() {
        assertEquals(5, solution2.findKthLargest(nums, 2));
    }

    @Test
    public void solution3Test() {
        assertEquals(5, solution3.findKthLargest(nums, 2));
    }
}