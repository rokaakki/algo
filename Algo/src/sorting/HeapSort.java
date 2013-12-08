package sorting;

public class HeapSort {
	public static int[] HeapSorting(int[] input){
		Heapify(input);
		return input;
	}
	public static void Heapify(int[] input){
		
		MaxHeap(input,0,input.length-1);
		
		//sort
		for(int i=input.length-1;i>0;){
			int temp=input[0];
			input[0]=input[i];
			input[i]=temp;
			i--;
			MaxHeap(input,0,i);
		}
		
	}
	public static void MaxHeap(int[] input, int index,int end){
		int start=(end-1)/2;
		for(int i=start;i>=0;i--){
			int left=i*2+1;
			int right=i*2+2;
			int swap=end;
			if(left<=end&&input[left]>input[i]){
				swap=left;
			}else{
				swap=i;
			}
			if(right<=end&&input[right]>input[i]){
				swap=right;
			}
			if(swap!=i){
				int temp=input[i];
				input[i]=input[swap];
				input[swap]=temp;
				MaxHeap(input,swap,end);
			}
		}

	}
	public static void main(String[] args){
		int[] input={2,7,3,5,7,1,7,9,2};
		input=HeapSorting(input);
		String output="";
		for(int i=0;i<input.length;i++){
			output+=input[i]+" ";
		}
		System.out.println(output);
	}
}
