package leetcode_challenge_jan.week1;

public class KthMissingPositiveNumber {
	public int findKthPositive(int[] arr, int k) {
        int number = 1;
        int i = 0;
        while(k>0){
            if(i<arr.length && arr[i]==number)
                i++;
            else
                k--;
            number++;
        }
        return number-1;
    }
}
