package com.chandra.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_208Test {

    Problem_208.Solution1.Trie solution1a;
    Problem_208.Solution1.Trie solution1b;

    @Before
    public void setUp() throws Exception {
        solution1a = new Problem_208.Solution1().new Trie();
        solution1b = new Problem_208.Solution1().new Trie();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        for (String key : keys) {
            solution1a.insert(key);
        }
    }

    @Test
    public void solution1Test() {
        assertTrue(solution1a.search("the"));
        assertFalse(solution1a.search("these"));
        assertTrue(solution1a.search("their"));
        assertFalse(solution1a.search("thaw"));
        assertTrue(solution1a.startsWith("the"));
        assertFalse(solution1a.startsWith("T"));
    }
}