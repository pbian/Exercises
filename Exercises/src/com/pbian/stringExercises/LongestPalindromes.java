package com.pbian.stringExercises;

public class LongestPalindromes {
	public String longestPalindrome(String s) {
		int length = s.length();
		if (length <= 1)
			return s;
		String longestPalindrome = "";
		for (int i = 0; i < length; i++) {
			String palindrome1 = findPalindrome(i, i, s, length);
			if (palindrome1.length() > longestPalindrome.length())
				longestPalindrome = palindrome1;
			String palindrome2 = findPalindrome(i, i + 1, s, length);
			if (palindrome2.length() > longestPalindrome.length())
				longestPalindrome = palindrome2;
		}
		return longestPalindrome;
	}
	private String findPalindrome(int start, int end, String s, int length) {
		while (start >= 0 && end < length) {
			if (s.charAt(start) == s.charAt(end)) {
				start--;
				end++;
			} else {
				return s.substring(start + 1, end);
			}
		}
		return s.substring(start + 1, end);
	}
}
