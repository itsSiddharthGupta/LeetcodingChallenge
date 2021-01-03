package leetcode_challenge_jan.week1;

import java.util.HashSet;
import java.util.Set;

public class CountArrangement {
	public static void main(String[] args) {
		System.out.println(countArrangement(5, 1, new HashSet<>()));
	}

	// considering ptr starts from 1
	public static int countArrangement(int n, int ptr, Set<Integer> set) {
		if (ptr == n + 1) {
			return 1;
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (set.contains(i))
				continue;
			if ((i % ptr == 0) || (ptr % i) == 0) {
				set.add(i);
				ans += countArrangement(n, ptr + 1, set);
				set.remove(i);
			}
		}
		return ans;
	}
}
