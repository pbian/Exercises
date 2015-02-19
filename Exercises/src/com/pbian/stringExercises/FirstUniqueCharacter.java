package com.pbian.stringExercises;

import java.util.HashMap;

public class FirstUniqueCharacter {
	public char firstUniqueCharacter(String s){
		int cursor = 0;
		int length = s.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < length; i++){
			char thisLetter = s.charAt(i);
			if(!map.containsKey(thisLetter)){
				map.put(thisLetter, 1);
			}
			else{
				int occurs = map.get(thisLetter) + 1;
				map.put(thisLetter, occurs);
			}
			while(map.containsKey(s.charAt(cursor)) && map.get(s.charAt(cursor)) > 1){
				cursor++;
				if(cursor == length){
					return '0';
				}
			}
		}
		return s.charAt(cursor);
	}
}
