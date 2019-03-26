package com.kevin.leetCode;

import java.util.HashMap;
import java.util.Map;

public class JS771 {
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("zbB", "aAAbbb5br"));
	}
	
	public static int numJewelsInStones(String J, String S) {
		int result = 0;
		if(J == null || J.isEmpty() || S == null || S.isEmpty()) {
			return result;
		}
		//1. first solution
//        char[]	JArrays = J.toCharArray();
//        char[]	SArrays = S.toCharArray();
//        for(int i = 0; i < JArrays.length; i++) {
//        	char jewel = JArrays[i];
//        	for(int j = 0; j < SArrays.length; j++) {
//        		if(SArrays[j] == jewel) {
//        			result++;
//        		}
//        	}
//        }
		
		//2.secondary solution
//      char[]	JArrays = J.toCharArray();
//      char[]	SArrays = S.toCharArray();
//      Map<String,String> stones = new HashMap<String, String>();
//      for(int i = 0; i < JArrays.length; i++) {
//    	  stones.put(String.valueOf(JArrays[i]), "1");
//      }
//      
//      for(int i = 0; i < SArrays.length; i++) {
//    	  if(stones.get(String.valueOf(SArrays[i])) != null) {
//    		  result++;
//    	  }
//      }
        
//        return result;
		//Using regex replace all non J's letter.//https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
		return S.replaceAll("[^" + J + "]", "").length();
    }
}
