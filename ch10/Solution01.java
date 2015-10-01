package ch10;

public class Solution01 {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
    while (tail1 >= 0 && tail2 >= 0) {
        nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? 
                             nums1[tail1--] : nums2[tail2--];
    }
    if (tail1< 0) { //only need to combine with remaining nums2
        while (finished >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }
    }
}
