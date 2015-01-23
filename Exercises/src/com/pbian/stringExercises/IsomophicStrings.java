package com.pbian.stringExercises;

import java.util.HashMap;
import java.util.HashSet;

public class IsomophicStrings {
	public boolean isIsomophicStrings(String a, String b) {
		HashMap<Character, Character> letterMap = new HashMap<Character, Character>();
		HashSet<Character> inverseSet = new HashSet<Character>();
		int aLength = a.length();
		int bLength = b.length();
		if (aLength != bLength)
			return false;
		for (int i = 0; i < aLength; i++) {
			char charFromA = a.charAt(i);
			char charFromB = b.charAt(i);
			if (letterMap.containsKey(charFromA)) {
				char aMapChar = letterMap.get(charFromA);
				if (aMapChar != charFromB) {
					return false;
				}
			} 
			else {
				if (inverseSet.contains(charFromB)) {
					return false;
				}
				letterMap.put(charFromA, charFromB);
				inverseSet.add(charFromB);
			}
		}
		return true;
	}
}
