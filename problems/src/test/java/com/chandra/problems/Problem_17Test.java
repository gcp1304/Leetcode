package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_17Test {

    Problem_17.Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_17.Solution1();
    }

    @Test
    public void solution1Test() {
        String input = "23";
        String[] expectedOutput = new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};

        assertArrayEquals(expectedOutput, solution1.letterCombinations(input).toArray());
    }
}