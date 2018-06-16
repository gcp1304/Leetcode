package com.chandra.problems;

import java.util.HashMap;
import java.util.List;

/**
 * 554. Brick Wall
 *
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

 The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

 If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

 You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

 Example:
 Input:
 [[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]

 Output: 2
 Explanation:

 Note:
 The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.


 */
public class Problem_554 {
    /*
    Here we go through each layer and record the length after each brick including itself and the length frequency
    which tells us that if we cut after this length then the total layers minus the frequency of the length tells
    us the number of bricks we need to cut.

    We pick the maximum number length frequency and subtract from the number of layers of walls to give the layers we cut
    when we draw a vertical line after the frequently occuring length.

    Since we cannot draw the line along the two vertical edges of the wall we don't consider last brick length in each layer
    to determine the length frequency
     */
    public static class Solution_1 {
        public int leastBricks(List<List<Integer>> wall) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxLenFreq = 0;

            for (List<Integer> brickLayer : wall) {
                int length = 0; // we calculate the freq of len at every layer, hence we should reset to zero for every layer
                for (int i = 0; i < brickLayer.size() - 1; i++) { // brickLayer.size()-1 is because we do not want to consider last brick
                    length += brickLayer.get(i);
                    if (map.containsKey(length)) {
                        map.put(length, map.get(length)+1); // increment the length frequency is len exists in map
                    } else {
                        map.put(length, 1);
                    }

                    // above if condition can be written as
                    //map.put(length, map.getOrDefault(length, 0) + 1);

                    maxLenFreq = Math.max(maxLenFreq, map.get(length)); // calculate the maximum frequency of a length
                }
            }

            return wall.size() - maxLenFreq; // now subtracting the max length frequency from number of layers of wall
            // will give the number bricks we need to pass through to draw vertical line
        }

    }
}
