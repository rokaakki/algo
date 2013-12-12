package tree;

import java.util.ArrayList;

public class AVLTree extends BinarySearchTree{
	 protected static Node root;
	 protected static void Insert(Node root,int value){
		 if(root==null)
			 return;
		 if(value<root.value){
			 if(root.leftChild!=null){
				 Insert(root.leftChild,value);
			 }else{
				 root.leftChild=new Node(value,null,null,root);
				 System.out.println(root.leftChild.value+"INSERT");
				 UpdateHeight(root.leftChild);
			 }
		 }else{
			 if(root.rightChild!=null){
				 Insert(root.rightChild,value);
			 }else{
				 root.rightChild=new Node(value,null,null,root);
				 System.out.println(root.rightChild.value+"INSERT");
				 UpdateHeight(root.rightChild);
			 }
		 }
	 }
	protected static void UpdateHeight(Node node){
		SetHeight(node);
		int L=-1;
		int R=-1;
		int CL=-1;
		int CR=-1;
		if(node.leftChild!=null)
			L=node.leftChild.height;
		if(node.rightChild!=null)
			R=node.rightChild.height;
		if((L-R)==2){
			Node left=node.leftChild;
			if(left.leftChild!=null)
				CL=left.leftChild.height;
			if(left.rightChild!=null)
				CR=left.rightChild.height;
			if(CL>CR){
				RotateRight(node);
			}
			else{
				DoubleRotateRight(node);
			}
		}else if((L-R)==-2){
			Node right=node.rightChild;
			if(right.leftChild!=null)
				CL=right.leftChild.height;
			if(right.rightChild!=null)
				CR=right.rightChild.height;
			if(CR>CL){
				RotateLeft(node);
			}
			else{
				DoubleRotateLeft(node);
			}
		}
		
		if(node.parent!=null){
			UpdateHeight(node.parent);
		}
	}
	protected static void SetHeight(Node node){
		node.height=0;
		if(node.leftChild!=null){
			if(node.leftChild.height>=node.height)
				node.height=node.leftChild.height+1;
		}
		if(node.rightChild!=null){
			if(node.rightChild.height>=node.height)
				node.height=node.rightChild.height+1;
		}
	}
	protected static void RotateLeft(Node node){
		System.out.println(node.value+"Left");
		Node P=node.parent;
		Node R=node.rightChild;
		if(P!=null){
			//first key change
			if(P.leftChild==node){
				P.leftChild=R;
			}else{
				P.rightChild=R;
			}
		}else{
			root=R;
		}
		R.parent=P;
		//second key change
		node.rightChild=R.leftChild;
		if(R.leftChild!=null)
		R.leftChild.parent=node;
		
		
		//third key change
		node.parent=R;
		R.leftChild=node;

		SetHeight(node);
		SetHeight(R);
	}
	protected static void RotateRight(Node node){
		System.out.println(node.value+"R");
		
		Node P=node.parent;
		Node L=node.leftChild;
		if(P!=null){
			//first key change
			if(P.leftChild==node){
				P.leftChild=L;
			}else{
				P.rightChild=L;
			}
		}else{
			root=L;
		}
		L.parent=P;
		//second key change
		node.leftChild=L.rightChild;
		if(L.rightChild!=null)
		L.rightChild.parent=node;
		
		
		//third key change
		node.parent=L;
		L.rightChild=node;

		SetHeight(node);
		SetHeight(L);
	}
	protected static void DoubleRotateRight(Node node){
		System.out.println(node.value+"RR");
		RotateLeft(node.leftChild);
		RotateRight(node);
	}
	protected static void DoubleRotateLeft(Node node){
		System.out.println(node.value+"LL");
		RotateRight(node.rightChild);
		RotateLeft(node);
		
	}
	protected static void InOrder(Node node){
		if(node==null)
			return;
		InOrder(node.leftChild);
		System.out.println(node.value+" "+node.height);
		InOrder(node.rightChild);
	}
	protected static void BTInOrder(Node root){
		result=new ArrayList<Integer>();
		if(root!=null)
			InOrder(root);
	}
	 public static void main(String[] args){
		 root=new Node(8,null,null);
		 
		 Insert(root,5);
		 Insert(root,15);
		 Insert(root,2);
		 Insert(root,1);
		 Insert(root,0);
		 Insert(root,7);
		 Insert(root,6);
		 Insert(root,10);
		 Insert(root,13);
		 Insert(root,16);
		 Insert(root,9);
		 /*
		  *         8
		  *    2        13
		  *  1    6   10   15
		  * 0 5  x 7  9 x  x 16
		  *        
		  */
		 BTInOrder(root);
		 System.out.println(result.toString());
		 //RotateLeft(root.rightChild);
		 //RotateRight(root.leftChild.leftChild);
		 //DoubleRotateRight(root.rightChild);
		 //UpdateHeight(root);
		 //Delete(root,8);
		 BTInOrder(root);
		 System.out.println(result.toString()+root.value);
	 }
}
