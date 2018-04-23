package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_161Test {

    private Problem_161.Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_161.Solution1();
    }

    String s1 = "geeks";
    String s2 = "geek";

    @Test
    public void solution1Test() {
        assertTrue(solution1.isOneEditDistance(s1, s2));
    }

}