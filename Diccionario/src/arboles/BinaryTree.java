package arboles;
/***************************************************************
	Universidad del Valle de Guatemala
	Algoritmos y Estructura de Datos
	Integrantes:
	Carlos Cordero		(13152)
	Juan Tzun			(13017)
	Tomas Garcia		(13019)
	Sergio Mendez		(13452)
	
	Se utilizo como referencia codigo obtenido de http://www.newthinktank.com/2013/03/binary-tree-in-java/. [Visitado 09/09/2014]
*****************************************************************/

import java.util.*;

public class BinaryTree<E> {

	Node root;

	public void addNode(E key, E name) {

		// Create a new Node and initialize it

		Node newNode = new Node(key, name);

		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

				if (key.toString().compareTo(focusNode.key.toString()) < 0) {

					// Switch focus to the left child

					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}

	// All nodes are visited in ascending order
	// Recursion is used to go to one node and
	// then go to its child nodes and so forth

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.println(focusNode);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	public void preorderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			System.out.println(focusNode);

			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);

			System.out.println(focusNode);

		}

	}

	public Node findNode(E key) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (!focusNode.key.toString().equalsIgnoreCase(key.toString())) {

			// If we should search to the left

			if (key.toString().compareTo(focusNode.key.toString()) < 0) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode;

	}
        
        public String findName(String key) {

		// Start at the top of the tree

		Node focusNode = root;

		// While we haven't found the Node
		// keep looking

		while (!focusNode.key.toString().equalsIgnoreCase(key)) {

			// If we should search to the left

			if (key.compareTo(focusNode.key.toString()) < 0) {

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return null;

		}

		return focusNode.name.toString();

	}

}

class Node<G> {

	G key;
	G name;

	Node leftChild;
	Node rightChild;

	Node(G key, G name) {
            
		this.key = key;
		this.name = name;
                
	}

	public String toString() {

		return name + " has the key " + key;

		

	}

}