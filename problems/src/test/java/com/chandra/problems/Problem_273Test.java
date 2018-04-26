package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_273Test {

    Problem_273.Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_273.Solution1();
    }

    @Test
    public void solution1Test() {
        int input = 1234567;
        String expectedOutput = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";

        assertTrue(expectedOutput.equals(solution1.numberToWords(input)));
    }
}