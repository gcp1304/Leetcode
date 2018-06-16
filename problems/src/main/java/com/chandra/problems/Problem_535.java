package com.chandra.problems;

import java.util.HashMap;

/**
 * 535. Encode and Decode TinyURL
 *
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

 Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class Problem_535 {
    public static class Solution_1 {
        public class Codec {

            private HashMap<Integer, String> map = new HashMap<>();
            private static final String PREFIX = "http://tinyurl/";

            // Encodes a URL to a shortened URL.
            public String encode(String longUrl) {
                Integer hashCode = longUrl.hashCode();
                map.put(hashCode, longUrl);
                return PREFIX + hashCode;
            }

            // Decodes a shortened URL to its original URL.
            public String decode(String shortUrl) {
                return map.get(Integer.valueOf(shortUrl.substring(PREFIX.length())));
            }
        }
    }
}
