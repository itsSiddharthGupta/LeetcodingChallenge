package leetcode_challenge_jan.week1;

import java.util.HashMap;
import java.util.Map;

public class CanFormArray {
	public static void main(String[] args) {
		int arr[] = { 91, 4, 64, 78 }; // [91,4,64,78] [[78],[4,64],[91]]
		int[][] pieces = { { 78 }, { 4, 64 }, { 91 } };
		System.out.println(canFormArray(arr, pieces));
	}

	public static boolean canFormArray(int[] arr, int[][] pieces) {
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		for (int i = 0; i < pieces.length; i++) {
			map.put(pieces[i][0], pieces[i]);
		}

		int i = 0;
		while (i < arr.length) {
			if (map.containsKey(arr[i])) {
				int[] p = map.get(arr[i]);
				for (int j = 0; j < p.length; j++) {
					if (p[j] == arr[i]) {
						i++;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
