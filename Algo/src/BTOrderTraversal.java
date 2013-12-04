import java.util.ArrayList;
import java.util.Stack;

/*
 * Binary Tree Post Order Traversal
 * recursive
 */
public class BTOrderTraversal {

	private static ArrayList<Integer> result;
	private static void PostOrder(Node node){
		if(node==null)
			return;
		PostOrder(node.leftChild);
		PostOrder(node.rightChild);
		result.add(node.value);
	}
	private static void BTPostOrder(Node root){
		result=new ArrayList<Integer>();
		if(root!=null)
		PostOrder(root);
	}
	private static void BTPostOrderIterative(Node root){
		result=new ArrayList<Integer>();
		Stack<Node> temp=new Stack<Node>();
		temp.push(root);
		while(!temp.isEmpty()){
			Node currentNode=(Node) temp.pop();		
			if(currentNode.leftChild!=null)
				temp.push(currentNode.leftChild);
			if(currentNode.rightChild!=null)
				temp.push(currentNode.rightChild);
			result.add(0, currentNode.value);
		}
	}
	private static void PreOrder(Node node){
		if(node==null)
			return;
		result.add(node.value);
		PreOrder(node.leftChild);
		PreOrder(node.rightChild);
	}
	private static void BTPreOrder(Node root){
		result=new ArrayList<Integer>();
		if(root!=null)
			PreOrder(root);
	}
	private static void BTPreOrderIterative(Node root){
		result=new ArrayList<Integer>();
		Stack<Node> temp=new Stack<Node>();
		temp.push(root);
		while(!temp.isEmpty()){
			Node currentNode=(Node) temp.pop();
			if(currentNode.rightChild!=null)
				temp.push(currentNode.rightChild);
			if(currentNode.leftChild!=null)
				temp.push(currentNode.leftChild);
			
			result.add(currentNode.value);
		}
	}
	public static void main(String [] args){
		System.out.println("Hello");
		/*
		 * 1
		 *2 4
		 * 3
		 */
		Node leaf=new Node(3,null,null);
		Node leaf2=new Node(4,null,null);
		Node second=new Node(2,null,leaf);
		Node root=new Node(1,second,leaf2);
		BTPostOrderIterative(root);
		System.out.println(result.toString());
		BTPostOrder(root);
		System.out.println(result.toString());
		BTPreOrderIterative(root);
		System.out.println(result.toString());
		BTPreOrder(root);
		System.out.println(result.toString());
		
	}
}
