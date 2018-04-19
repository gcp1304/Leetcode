package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_125Test {

    private Problem_125.Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_125.Solution1();
    }

    @Test
    public void solution1Test() throws Exception {
        String input1 = "A man, a plan, a canal: Panama";
        String input2 = "race a car";

        assertTrue(solution1.isPalindrome(input1));
        assertFalse(solution1.isPalindrome(input2));
    }
}