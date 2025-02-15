package com.example.taskManager.algorithms;

import org.springframework.util.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class Algorithms {
    public static void main(String[] args) {
        System.out.println(nonRepeating("swiss"));
        System.out.println(nonRepeating("sswwiissss"));

        System.out.println(stringCompression("bbcceeee"));
        System.out.println(stringCompression("aaabbbccc"));
        System.out.println(stringCompression("a"));
    }

    public static String nonRepeating(String word){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (Character letter:word.toCharArray()){
            if (map.containsKey(letter)){
                map.put(letter,map.get(letter) + 1);
            }
            else {
                map.put(letter, 1);
            }
        }
        for (Map.Entry<Character, Integer> val:map.entrySet()){
        if(val.getValue().equals(1)){
            return val.getKey().toString();
        }

    }
        return "-1";
}


public static String stringCompression(String str){
        if (str == null || str.isEmpty()){
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) == str.charAt(i-1)){
                count ++;
            }
            else{
                compressed.append(str.charAt(i-1)).append(count);
                count = 1;
            }
        }

        compressed.append(str.charAt(str.length()-1)).append(count);

//                compressed.length() < str.length() ? compressed.toString() : str;
        if(compressed.length() < str.length()){
            return compressed.toString();
        }
        else{
          return   str;
        }
}

}


