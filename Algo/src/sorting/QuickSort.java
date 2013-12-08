package sorting;

public class QuickSort {
	public static int[] QuickSorting(int[] input){
		QuickSortingSplit(input,0,input.length);
		return input;
	}
	public static void QuickSortingSplit(int[] input,int start,int end){
		if(end-start<2)
			return;
		int pivot=input[end-1];
		int index=start;
		for(int i=start;i<(end-1);i++){
			if(input[i]<=pivot){
				int tmp=input[index];
				input[index]=input[i];
				input[i]=tmp;
				index++;
			}
		}
		input[end-1]=input[index];
		input[index]=pivot;
		if(index>1){
			QuickSortingSplit(input,start,index);
		}
		if((end-index-1)>1){
			QuickSortingSplit(input,index,end);
		}
	}
	public static void main(String[] args){
		int[] input={2,7,3,5,7,1,7,9,8,1};
		input=QuickSorting(input);
		String output="";
		for(int i=0;i<input.length;i++){
			output+=input[i]+" ";
		}
		System.out.println(output);
	}
}
