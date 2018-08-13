package com.chandra.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 Example:

 // Init an empty set.
 RandomizedSet randomSet = new RandomizedSet();

 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 randomSet.insert(1);

 // Returns false as 2 does not exist in the set.
 randomSet.remove(2);

 // Inserts 2 to the set, returns true. Set now contains [1,2].
 randomSet.insert(2);

 // getRandom should return either 1 or 2 randomly.
 randomSet.getRandom();

 // Removes 1 from the set, returns true. Set now contains [2].
 randomSet.remove(1);

 // 2 was already in the set, so return false.
 randomSet.insert(2);

 // Since 2 is the only number in the set, getRandom always return 2.
 randomSet.getRandom();
 */

public class Problem_380 {
    /**
     * The List is used to store numbers and serve the getRandom() method.
     * The Map contains the mapping between the value and its index in the ArrayList.
     * The Map helps to check whether a value is already inserted or not.
     * The main trick is when you remove a value. ArrayList's remove method is O(n) if you remove from random location.
     * To overcome that, we swap the values between (randomIndex, lastIndex) and always remove the entry from
     * the end of the list. After the swap, you need to update the new index of the swapped value
     * (which was previously at the end of the list) in the map.
     */
    public class RandomizedSet {

        HashMap<Integer, Integer> valToInd;
        List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            valToInd = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(valToInd.containsKey(val)) return false;
            list.add(val);
            valToInd.put(val,list.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            int ind = valToInd.getOrDefault(val,-1);
            if(ind == -1) return false;
            Collections.swap(list,ind,list.size()-1);
            int swappedWith = list.get(ind);
            valToInd.put(swappedWith,ind);
            list.remove(list.size()-1);
            valToInd.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int ind = (int)(Math.random() * (list.size()));
            return list.get(ind);
        }
    }
}
