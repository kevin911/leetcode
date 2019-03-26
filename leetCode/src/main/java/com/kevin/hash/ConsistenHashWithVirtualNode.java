package com.kevin.hash;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistenHashWithVirtualNode {

	private static SortedMap<Integer, String> hashRing = new TreeMap<Integer, String>();

	private static List<String> SERVERS = Arrays.asList("127.0.0.2", "127.0.0.11", "127.0.0.22", "198.122.0.2", "170.252.199.33");

	
	private final static int VIRTUAL_NODE_NUM = 5; 
	
	private static Random random = new Random();
	
	static {
		StringBuffer servers = new StringBuffer();
		for(String server: SERVERS) {
			servers.append(server).append("&&");
		}
		for(String server: SERVERS) {
			for(int i = 0; i < VIRTUAL_NODE_NUM; i++) {
				String virtualNode = server + "_VN" + i;
				int hash = getHash(virtualNode);
				System.out.println("添加虚拟节点【" + virtualNode + "】，hash值为：" + hash);

				hashRing.put(hash, servers.toString());
			}
		}
	}

	private static int getHash(String key) {
		final int p = 16777619;
		int hash = (int)2166136261L;
		for (int i = 0; i < key.length(); i++)
			hash = (hash ^ key.charAt(i)) * p;
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;

		// 如果算出来的值为负数则取其绝对值
		if (hash < 0)
			hash = Math.abs(hash);
		return hash;
	}

	public static String getServer(String node) {
		int hash = getHash(node);
		SortedMap<Integer, String> sortedMap = hashRing.tailMap(hash);
		if(sortedMap.isEmpty()){
			sortedMap = hashRing.headMap(hash);
		}
		return hashRing.get(sortedMap.firstKey());
	}

	public static void main(String[] args) {
		List<String> SERVERS = Arrays.asList("127.0.0.1","127.0.0.9", "221.226.0.1", "10.211.33.22", "10.211.0.1");
		for(String server: SERVERS) {
			int hash = getHash(server);
			String node = getServer(server);
			System.out.println(server + " 的hash值为：" + hash);
			System.out.println("IP: " + node);
			System.out.println("[" + server + "]的hash值为" + 
					hash + ", 被路由到结点[" + node + "]");

		}
	}


}
