package com.collection.set.lotto;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	public static void main(String[] args) {
		Lotto.lottoDisplay();
	}
	
	public static void lottoDisplay() {
		Set<Integer> set = new TreeSet<>();
		while(true) {
			set.add((int)(Math.random()*45+1));
			if(set.size() == 6)
				break;
		}
		Integer[] array = set.toArray(new Integer[set.size()]);
		System.out.print(array[0]);
		for(int i = 1; i < array.length; i++) {
			System.out.print("," + array[i]);
		}
	}
}
