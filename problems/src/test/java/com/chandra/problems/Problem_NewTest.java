package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_NewTest {
    
    private static Problem_New.Solution_1 solution1;

    int[] input1 = {2, 2, 6, 2, 10, 2};
    int[] input3 = {1, 4, 5, 7, 8, 10};
    int[] input4 = {10, 8, 7, 5, 3, 2};
    int[] input5 = {10, 8, 8, 5, 3, 4};
    int[] input6 = {2, 4, 6, 7, 9, 8, 7, 6, 5, 4, 3, 2, 1, 3};

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_New.Solution_1();
    }

    @Test
    public void solution1Test() {
        assertEquals(solution1.minimumNumberOfTokens(input1), 8);
    }
}