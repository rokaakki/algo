package sorting;

public class BubbleSort {
	public static int[] BubbleSorting(int[] input){
		for(int i=0;i<input.length-1;i++){
			for(int j=0;j<input.length-1-i;j++){
				if(input[j]>input[j+1]){
					int temp=input[j];
					input[j]=input[j+1];
					input[j+1]=temp;
				}
			}
		}
		return input;
	}
	
	public static void main(String[] args){
		int[] input={2,7,3,5,7,1,7};
		input=BubbleSorting(input);
		String output="";
		for(int i=0;i<input.length;i++){
			output+=input[i]+" ";
		}
		System.out.println(output);
	}
}
