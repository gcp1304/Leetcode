package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_200Test {

    Problem_200.Solution1 solution1;

    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_200.Solution1();
    }

    char[][] grid1 = new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
    };

    char[][] grid2 = new char[][] {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
    };

    @Test
    public void solution1Test() {
        assertEquals(1, solution1.numIslands(grid1));
        assertEquals(3, solution1.numIslands(grid2));
    }
}