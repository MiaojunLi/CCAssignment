package ch10;
/*
 * In this problem, although we don't know the size of the data structure,
 * we can still use binary search,since we can calculate the size of data by logN time.
 * And the time for binary search is also logN, so the total time will be also logN
 */

public class Solution04 {
	int sortedSearch(Listy list,int target){
		int index=1;
		while(list.elementAt(index)!=-1 && list.elementAt(index)<target){
			index*=2;
		}
		return binarySearch(list,index/2,index,target);
	}
	
	int binarySearch(Listy list,int low,int high,int target){
		int mid;
		while(low<=high){
			mid=(low+high)/2;
			int middle=list.elementAt(mid);	
			if(middle==-1 || middle>target){
				high=middle-1;
			}
			else if(middle<target){
				low=middle+1;
			}
			else return list.elementAt(mid);
		}
	}
}

