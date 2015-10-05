package ch3;
/*
 * Thh solution mainly focus on achieving the fixed-size stacks in an array
 * For felxible-size stacks, it will be more complicated and we can treat the 
 * array like a circle,such that the third stack starting at the end of the array 
 * and warping around to the beginning
 */
class FixedMulStacks{
	private int numberofStack=3;
	private int stackSize;
	private int[] val;
	private int[] size;
	
	public FixedMulStacks(int stackSize){
		this.stackSize=stackSize;
		val=new int[stackSize*numberofStack];
		size=new int[numberofStack];
	}
	
	/*add an element into the stack if it's not full*/
	public void push(int stacknum, int value) throws FullStackException{   //must has the "throws" declaration
		if(isfull(stacknum))
			throw new FullStackException();
		size[stacknum]++;
		this.val[indexOfTop(stacknum)]=value;
	}
	
	/*remove the top element and return it */
	public int pop(int stacknum) throws EmptyStackException{
		if(size[stacknum]==0)
			throw new EmptyStackException();
		int value=val[indexOfTop(stacknum)];
		val[indexOfTop(stacknum)]=0;
		size[stacknum]--;
		return value;
	}
	
	/*return top element*/
	public int peek(int stacknum) throws EmptyStackException{
		if(isEmpty(stacknum))
			throw new EmptyStackException();
		return val[indexOfTop(stacknum)];
	}
	
	/*return whether the stack is full */
	public boolean isfull(int stacknum){
		return size[stacknum]==stackSize;
	}
	
	/*return the index of top element in an array */
	public int indexOfTop(int stacknum){
		return stacknum*stackSize+size[stacknum]-1;
	}
	
	/*return if it's an empty stack*/
	public boolean isEmpty(int stacknum){
		return size[stacknum]==0;
	}
}

class FullStackException extends Exception{}
class EmptyStackException extends Exception{}



public class Solution01 {

}
