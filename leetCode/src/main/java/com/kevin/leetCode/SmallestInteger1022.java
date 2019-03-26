package com.kevin.leetCode;


public class SmallestInteger1022 {
	public static int smallestRepunitDivByK(int K) {
//        for(int i = K; i < Integer.MAX_VALUE; i++) {
//        	if(i%K == 0 && isOnlyContainsOne(i)) {
//        		return String.valueOf(i).length();
//        	}
//        }
//        return -1;
		
		 if (K % 10 == 5 || K % 2 == 0)
		        return -1;
		    int cur = 1, len = 1;
		    while (true) {
		        if (cur % K == 0) {
		        	System.out.println(cur);
		        	return len;
		        }
		          
		        cur = (cur * 10 + 1) % K;
		        len++;
		    }
//		     return -1;
    }

	private static boolean isOnlyContainsOne(int number) {
		return String.valueOf(number).replaceAll("1", "").length() == 0;
	}
	
	public static void main(String[] args) {
//		long current = System.currentTimeMillis();
//		System.out.println(current);
		System.out.println(smallestRepunitDivByK(7));
//		System.out.println(System.currentTimeMillis() - current);
	}
}
