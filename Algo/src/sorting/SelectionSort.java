package sorting;

public class SelectionSort {
	public static int[] SelectionSorting(int[] input){
		for(int i=0;i<input.length;i++){
			int value=input[i];
			int index=i;
			for(int j=i;j<input.length;j++){
				if(input[j]<value){
					index=j;
					value=input[j];
				}
			}
			value=input[i];
			input[i]=input[index];
			input[index]=value;
		}
		return input;
	}
	public static void main(String[] args){
		int[] input={2,7,3,5,7,1,7};
		input=SelectionSorting(input);
		String output="";
		for(int i=0;i<input.length;i++){
			output+=input[i]+" ";
		}
		System.out.println(output);
	}
}
