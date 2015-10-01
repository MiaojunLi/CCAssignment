package ch10;

public class Solution03 {
	public int binarySearch(int low, int high, int[] nums, int target){
		if(low > high)
	        return -1;
	    int mid = (low + high)/2;
	    if(nums[mid] == target)
	        return mid;
	    if(nums[mid] >= nums[low]){//array between nums[low] and nums[mid] are sorted,even considering duplicate elements
	        if( nums[low] <= target && target < nums[mid])//target is between nums[low] and nums[mid]
	            return binarySearch(low, mid - 1, nums, target);
	        else
	            return binarySearch(mid + 1, high, nums, target);
	    }
	    else{//unsorted part of array
	        if(nums[mid] < target && target <= nums[high])
	            return binarySearch(mid + 1, high, nums, target);
	        else
	            return binarySearch(low, mid - 1, nums, target);
	    }
	}
}
