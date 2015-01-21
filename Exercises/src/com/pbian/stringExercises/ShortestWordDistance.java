package com.pbian.stringExercises;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class ShortestWordDistance {
	private List<String> wordList;
	public ShortestWordDistance(List<String> wordList){
		this.wordList = wordList;
	}
	public int distance(String a, String b) {
		if (a.equals(b))
			return 0;
		HashMap<String, ArrayList<Integer>> wordMap = new HashMap<String, ArrayList<Integer>>();
		int length = wordList.size();
		for (int i = 0; i < length; i++) {
			String currentWord = wordList.get(i);
			if (currentWord.equals(a) || currentWord.equals(b)) {
				if (!wordMap.containsKey(currentWord)) {
					ArrayList<Integer> currentWordList = new ArrayList<Integer>();
					currentWordList.add(i);
					wordMap.put(currentWord, currentWordList);
				} else {
					wordMap.get(currentWord).add(i);
				}
			}
		}
		ArrayList<Integer> locAList = wordMap.get(a);
		ArrayList<Integer> locBList = wordMap.get(b);
		int distance = Integer.MAX_VALUE;
		if (locAList == null || locBList == null)
			return distance;
		int i = 0;
		int j = 0;
		int listALength = locAList.size();
		int listBLength = locBList.size();
		while (i < listALength && j < listBLength) {
			int difference = locAList.get(i) - locBList.get(j);
			if (difference < 0) {
				difference = -1 * difference;
				i++;
			} else {
				j++;
			}
			if (difference < distance) {
				distance = difference;
			}
		}
		if (i == listALength){
			while (j < listBLength){
				int difference = locBList.get(j) - locAList.get(i - 1);
				if (difference < 0)
					difference = -1 * difference;
				if (difference < distance)
					distance = difference;
				j++;
			}
		}
		else{
			while (i < listALength){
				int difference = locAList.get(i) - locBList.get(j - 1);
				if (difference < 0)
					difference = -1 * difference;
				if (difference < distance)
					distance = difference;
				i++;
			}
		}
		return distance;
	}
}
