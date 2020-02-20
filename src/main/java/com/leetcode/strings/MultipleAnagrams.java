package com.leetcode.strings;

import java.util.*;

public class MultipleAnagrams {
    public static void main(String[] args) {
        MultipleAnagrams anagrams = new MultipleAnagrams();
        List<String> input = new ArrayList<>();
        input.add("code");
        input.add("framer");
        input.add("edoc");
        input.add("doec");
        input.add("rfamer");
        List<String> res = anagrams.getAnagrams(input);
        System.out.println("res=" + res);
    }

    private List<String> getAnagrams(List<String> input) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < input.size(); i++) {
            char[] arr = input.get(i).toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if (set.contains(s)) {
                continue;
            } else {
                set.add(s);
                res.add(input.get(i));
            }
        }
        return res;
    }
}
