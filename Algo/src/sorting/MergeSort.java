package sorting;

public class MergeSort {
	public static int[] MergeSorting(int[] input){
		int[] result=new int[input.length];
		MergeSplit(input,result,0,input.length);
		return input;
	}
	public static void MergeSplit(int[] input, int[] result,int start,int end){
		if(end-start<2)
			return;
		int middle=(start+end)/2;
		MergeSplit(input,result,start,middle);
		MergeSplit(input,result,middle,end);
		MergeMerge(input,result,start,middle,end);
		for(int i=start;i<end;i++)
			input[i]=result[i];
	}
	public static void MergeMerge(int[] input,int[] result,int start, int middle,int end){
		int i1=start;
		int i2=middle;
		for(int i=start;i<end;i++){
			/*i1<middle: the uppper array has space
			 *i2>=end: the lower array has no space
			 */
			if(i1 < middle && (i2 >= end || input[i1] <= input[i2])){
				result[i]=input[i1];
				i1++;
			}else{			
				result[i]=input[i2];
				i2++;
			}
		}
	}
	public static void main(String[] args){
		int[] input={2,7,3,5,7,1,7,9,8,1};
		input=MergeSorting(input);
		String output="";
		for(int i=0;i<input.length;i++){
			output+=input[i]+" ";
		}
		System.out.println(output);
	}
}
