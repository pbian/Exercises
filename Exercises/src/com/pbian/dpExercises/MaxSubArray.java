package com.pbian.dpExercises;

public class MaxSubArray {
	public int maxSubArray(int[] A) {
		int length = A.length;
		int[] selectiveMax = new int[length];
		if (length == 0)
			return 0;
		selectiveMax[0] = A[0];
		int currentMax = A[0];
		for (int i = 1; i < length; i++) {
			int addPrevious = selectiveMax[i - 1] + A[i];
			selectiveMax[i] = addPrevious > A[i] ? addPrevious : A[i];
			if (selectiveMax[i] > currentMax)
				currentMax = selectiveMax[i];
		}
		return currentMax;
	}
}
