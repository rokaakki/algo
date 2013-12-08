package sorting;

public class InsertSort {
	public static int[] InsertSorting(int[] input){
		for(int i=1;i<input.length;i++){
			for(int j=i-1;j>=0;j--){
				if(input[j+1]<input[j]){
					int temp=input[j+1];
					input[j+1]=input[j];
					input[j]=temp;
				}
			}
		}
		return input;
	}
	public static void main(String[] args){
		int[] input={2,7,3,5,7,1,7};
		input=InsertSorting(input);
		String output="";
		for(int i=0;i<input.length;i++){
			output+=input[i]+" ";
		}
		System.out.println(output);
	}
}
