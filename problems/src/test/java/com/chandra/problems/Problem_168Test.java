package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_168Test {

    private Problem_168.Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_168.Solution1();
    }

    @Test
    public void solution1Test() {
        assertEquals("AB", solution1.convertToTitle(28));
    }
}