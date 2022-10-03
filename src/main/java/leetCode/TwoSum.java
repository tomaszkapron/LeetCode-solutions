package leetCode;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TwoSum.twoSum(new int[]{1, 3, 3, 7}, 6)));
    }

    static public int[] twoSum(int[] nums, int target) {
        int[] sumIndexes = new int[2];

        outerLoop:
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;

                if (nums[i] + nums[j] == target) {
                    sumIndexes[0] = i;
                    sumIndexes[1] = j;
                    break outerLoop;
                }
            }
        }

        return sumIndexes;
    }
}
