/**
 * BTreeSearch.java
 * This is version 2 of BTree class that added the search method.
 * 
 * @author Justin Lee
 * @since 10/24/2020
 * @version 2.0
 * gitRepo url: https://github.com/roof558/CptS233.git
 * CptS 233: MicroAssignment #2
 */

// Java program to illustrate the sum of two numbers 

// A BTree 
class Btree { 
	public BTreeNode root; // Pointer to root node 
	public int t; // Minimum degree 

	// Constructor (Initializes tree as empty) 
	Btree(int t) { 
		this.root = null; 
		this.t = t; 
	} 

	// function to traverse the tree 
	public void traverse() { 
		if (this.root != null) 
			this.root.traverse(); 
		System.out.println(); 
	} 

	// function to search a key in this tree 
	public BTreeNode search(int k) { 
		if (this.root == null) 
			return null; 
		else
			return this.root.search(k); 
	} 


	// A utility function to insert a new key in the subtree rooted with 
    // this node. The assumption is, the node must be non-full when this 
    // function is called 
    public void insertNonFull(int k); 
  
    // A utility function to split the child y of this node. i is index of y in 
    // child array C[].  The Child y must be full when this function is called 
    public void splitChild(int i, BTreeNode y); 
   
  
} 

// A BTree node 
class BTreeNode { 
	int[] keys; // An array of keys 
	int t; // Minimum degree (defines the range for number of keys) 
	BTreeNode[] C; // An array of child pointers 
	int n; // Current number of keys 
	boolean leaf; // Is true when node is leaf. Otherwise false 

	// Constructor 
	BTreeNode(int t, boolean leaf) { 
		this.t = t;	
		this.leaf = leaf; 
		this.keys = new int[2 * t - 1]; //
		this.C = new BTreeNode[2 * t]; 
		this.n = 0; 
	} 

	// A function to traverse all nodes in a subtree rooted with this node 
	public void traverse() { 

		// There are n keys and n+1 children, travers through n keys 
		// and first n children 
		int i = 0; 
		for (i = 0; i < this.n; i++) { 

			// If this is not leaf, then before printing key[i], 
			// traverse the subtree rooted with child C[i]. 
			if (this.leaf == false) { 
				C[i].traverse(); 
			} 
			System.out.print(keys[i] + " "); 
		} 

		// Print the subtree rooted with last child 
		if (leaf == false) 
			C[i].traverse(); 
	} 

	// A function to search a key in the subtree rooted with this node. 
	BTreeNode search(int k) { // returns NULL if k is not present. 

		int i = 0;	//Integer I is showing current location of search and always start with 0
		while(k > keys[i]) {	//Checking all value below value k
			if(!(i >= n)) i++;	//It should be less than n, can't be greater than number of key
			if(key[i] == k) return this //return this node if program found the search value
		}
		
		if(leaf == true) return null;	//After search current node that is leaf, report that k is not present.
		
		return C[i].search(k);	//recursive for looking up next location
	}
		
} 