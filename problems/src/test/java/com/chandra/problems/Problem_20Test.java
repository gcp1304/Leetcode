package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_20Test {

    Problem_20.Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_20.Solution1();
    }

    @Test
    public void solution1Test() {
        assertTrue(solution1.isValid("()"));
        assertTrue(solution1.isValid("()[]{}"));
        assertFalse(solution1.isValid("(]"));
        assertFalse(solution1.isValid("([)]"));
        assertTrue(solution1.isValid("{[]}"));
    }
}