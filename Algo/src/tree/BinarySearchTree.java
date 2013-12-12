package tree;

import java.util.ArrayList;

public class BinarySearchTree {
	protected static ArrayList<Integer> result;
	protected static void InOrder(Node node){
		if(node==null)
			return;
		InOrder(node.leftChild);
		result.add(node.value);
		InOrder(node.rightChild);
	}
	protected static void BTInOrder(Node root){
		result=new ArrayList<Integer>();
		if(root!=null)
			InOrder(root);
	}
	 protected static void Insert(Node root,int value){
		 if(root==null)
			 return;
		 if(value<root.value){
			 if(root.leftChild!=null){
				 Insert(root.leftChild,value);
			 }else{
				 root.leftChild=new Node(value,null,null,root);
			 }
		 }else{
			 if(root.rightChild!=null){
				 Insert(root.rightChild,value);
			 }else{
				 root.rightChild=new Node(value,null,null,root);
			 }
		 }
	 }
	 protected static Node Search(Node root, int value){
		 if(root==null||root.value==value)
			 return root;
		 else if(value<root.value){
			 return Search(root.leftChild,value);
		 }else{
			 return Search(root.rightChild,value);
		 }
	 }
	 protected static void Delete(Node root,int value){
		 Node find=Search(root,value);
		 /*
		 Node find=root;
		 Node parent=null;
		//1. find the node
		 
		 while(find!=null){
			 if(find.value>value){
				 parent=find;	
				 find=find.leftChild;			 			 
			 }else if(find.value<value){
				 parent=find;
				 find=find.rightChild;
			 }else{
				 break;
			 }
		 }
		*/	 
		 if(find==null)
			 return;
		 Node parent=find.parent;
		 //2. check if has child
		 if(find.leftChild==null&&find.rightChild==null){
			 System.out.println("1"+find.value);
			 if(parent!=null){
				 if(parent.leftChild==find)
					 parent.leftChild=null;
				 else
					 parent.rightChild=null;
			 }
			 find=null;
				 
		 }else if(find.leftChild==null){
			 System.out.println("2"+find.value);
			 if(parent!=null){
				 if(parent.leftChild==find)
					 parent.leftChild=find.rightChild;
				 else
					 parent.rightChild=find.rightChild;
			 }	
			 find=find.rightChild;
		 }else if(find.rightChild==null){
			 System.out.println("3"+find.value);
			 if(parent==null)
				 find=find.leftChild;
			 else{
				 if(parent.leftChild==find)
					 parent.leftChild=find.leftChild;
				 else
					 parent.rightChild=find.leftChild;
			 }
		 }else{
			
			//find most right leaf in left subtree
			Node mostRight=find.leftChild;
			Node rightParent=null;
			while(mostRight.rightChild!=null){
				//rightParent=mostRight;
				mostRight=mostRight.rightChild;
			 }
			rightParent=mostRight.parent;
			 System.out.println("4"+mostRight.value);
			//replace it
			find.value=mostRight.value;
			if(rightParent!=null)				
			{
				if(rightParent.leftChild==mostRight)
					rightParent.leftChild=null;
				else
					rightParent.rightChild=null;
			}
			mostRight=null;
		 }
	 }

	 public static void main(String[] args){
		 Node root=new Node(8,null,null);
		 Insert(root,5);
		 Insert(root,10);
		 Insert(root,2);
		 Insert(root,3);
		 Insert(root,6);
		 Insert(root,15);
		 Insert(root,12);
		 /*
		  *    8
		  *  5   10
		  * 2  6   15
		  *  3    12
		  */
		 BTInOrder(root);
		 System.out.println(result.toString());
		 Delete(root,5);
		 //Delete(root,8);
		 BTInOrder(root);
		 System.out.println(result.toString());
	 }
}
