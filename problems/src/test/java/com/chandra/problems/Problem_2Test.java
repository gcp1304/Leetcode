package com.chandra.problems;

import com.chandra.common.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Problem_2Test {

    private static Problem_2.Solution1 test;

    @Before
    public void setUp() throws Exception {
        test = new Problem_2.Solution1();
    }

    @Test
    public void passTest() throws Exception {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode expectedResult = new ListNode(7);
        expectedResult.next = new ListNode(0);
        expectedResult.next.next = new ListNode(8);

        ListNode actualResult = test.addTwoNumbers(l1, l2);

        assertEquals(expectedResult.val, actualResult.val);
        assertEquals(expectedResult.next.val, expectedResult.next.val);
        assertEquals(expectedResult.next.next.val, expectedResult.next.next.val);

    }
}