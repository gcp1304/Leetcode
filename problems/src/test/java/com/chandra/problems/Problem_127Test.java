package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Problem_127Test {

    private Problem_127.Solution1 solution1;


    @Before
    public void setUp() throws Exception {
        solution1 = new Problem_127.Solution1();
    }

    @Test
    public void solution1Test() throws Exception {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";

        int expectedLength = 5;
        assertEquals(expectedLength, solution1.ladderLength(beginWord, endWord, words));

        List<String> words1 = Arrays.asList("hot","dot","dog","lot","log");
        assertEquals(0, solution1.ladderLength(beginWord, endWord, words1));
    }
}