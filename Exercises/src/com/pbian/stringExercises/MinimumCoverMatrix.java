package com.pbian.stringExercises;

public class MinimumCoverMatrix {
	public int minCoverMatrix(String[] matrix) {
		if (matrix == null) {
			return 0;
		}
		int rowLength = matrix[0].length();
		int colLength = matrix.length;
		int[] minRows = new int[colLength];
		int[] minCols = new int[rowLength];
		for (int i = 0; i < colLength; i++) {
			minRows[i] = minRowCover(matrix[i]);
		}
		for (int j = 0; j < rowLength; j++) {
			minCols[j] = minColCover(matrix, j);
		}
		int crossRowCover = minRows[0];
		for (int i = 1; i < colLength; i++) {
			crossRowCover = leastCommonMultiple(crossRowCover, minRows[i]);
		}
		int crossColCover = minCols[0];
		for (int j = 1; j < rowLength; j++) {
			crossColCover = leastCommonMultiple(crossColCover, minCols[j]);
		}
		return crossRowCover * crossColCover;
	}

	private int leastCommonMultiple(int a, int b) {
		int lcdA = a;
		int lcdB = b;
		while (lcdA % lcdB != 0) {
			int remainder = lcdA % lcdB;
			lcdA = lcdB;
			lcdB = remainder;
		}
		return a * b / lcdB;
	}

	private int minRowCover(String row) {
		int length = row.length();
		int matchLength = 0;
		for (int i = 0; i < length - 1; i++) {
			String prefix = row.substring(0, i + 1);
			if (prefix.equals(row.substring(length - 1 - i))) {
				matchLength = matchLength < prefix.length() ? prefix.length()
						: matchLength;
			}
		}
		return length - matchLength;
	}

	private int minColCover(String[] rows, int colNumber) {
		int length = rows.length;
		StringBuffer prefix = new StringBuffer();
		StringBuffer suffix = new StringBuffer();
		int matchLength = 0;
		for (int i = 0; i < length - 1; i++) {
			prefix.append(rows[i].charAt(colNumber));
			suffix.insert(0, rows[length - 1 - i].charAt(colNumber));
			if (prefix.toString().equals(suffix.toString())) {
				matchLength = matchLength < prefix.length() ? prefix.length()
						: matchLength;
			}
		}
		return length - matchLength;
	}
}
