package com.chandra.problems;

public class Problem_227 {
    public static class Solution {
        /*
Use a char to store the last seen operator before a number, default is '+' since no negative number.
parse consecutive digits into one number.
when last seen operator is:
'+' : add the number to stack and reset num to zero
'-' : add negative of the number (-num) and reset num to zero
'*' : multiply num and number on top of stack, then save to the same place, reset num to 0
'/' : divide the number on top of stack by num, then save to the same place, reset num to 0

In this way we can ensure '*' and '/' are performed before '+' and '-'.
Then return the sum of all numbers in the stack.
*/

        public int calculate(String s) {
            int num = 0;
            char op = '+';
            int top = 0;
            int[] stack = new int[s.length()+1];

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == ' ') continue;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = 10*num + (s.charAt(i) - '0');
                    i++;
                }

                switch(op) {
                    case '+':
                        stack[++top] = num;
                        num = 0;
                        break;
                    case '-':
                        stack[++top] = -num;
                        num = 0;
                        break;
                    case '*':
                        stack[top] = stack[top] * num;
                        num = 0;
                        break;
                    case '/':
                        stack[top] = stack[top] / num;
                        num = 0;
                        break;
                }
                if(i < s.length()) op = s.charAt(i);
            }
            int sum = 0;
            for(int i=0; i<=top; i++) {
                sum += stack[i];
            }
            return sum;
        }
    }

}
