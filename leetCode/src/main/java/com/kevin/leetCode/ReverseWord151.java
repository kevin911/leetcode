package com.kevin.leetCode;

public class ReverseWord151 {
	public static String reverseWords(String s) {
		if(s == null || s.isEmpty()) return "";
		String[] words = s.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i = words.length - 1; i > -1; i--) {
			String word = words[i];
			if(!word.isEmpty()) {
				sb.append(word);
				if(i == 0) break;
				sb.append(" ");
			}
			
		}
		
		return sb.toString();
		
		
	}
	
	public static void main(String[] args) {
		String str = "the sky is blue!";
		System.out.println(reverseWords(str) + " ****");
	}
}
