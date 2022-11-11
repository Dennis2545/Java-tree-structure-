class Node {
	int key;
    Node right;
    Node left;
    Node parent;

    public Node(int value){
        key = value;
        right = null;
        left = null;
        parent = null;
    }
}
    //DELETE NODE FROM TREE =====================================================================
    public void delete(int delKey){
    	Node node = root;
    	Node parent = null;
    	Node delete = null;
    	boolean isLeft = true;
    	Node successor = null;
    	int depth = 0;

    	if (node == null) {
            return;
        }

    	while (node.key != delKey){
            parent = node;
            if (delKey > node.key){
                node = node.right;
                isLeft = false;
            }
            else {
                node = node.left;
                isLeft = true;
            }    
            depth++;
    	}

    	// case 1: Node to be delete has no children
        if (node.left == null && node.right == null){
            //node = null;
        }
        // case 2: Node has only a right child
        else if (node.left == null){
            successor = node.right;
        }
        // case 3: Node has only a left child
        else if (node.right == null){
            successor = node.left;
        }
        else {
        	// find successor
            successor = minimumKey(node.right);
            // the successor is the node's right child 
            if (successor == node.right){
                successor.left = node.left;
            }
            // complicated case
            else {
                successor.left = node.left;
                delete = successor.right;
                successor.right = node.right;
                node.right.left = delete;
            }
        }
        // Replace the node
        if (parent == null)
            root = successor;
        else if (isLeft){
        	node.parent.left = successor;
            parent.left = successor;
        }
        else {
            parent.right = successor;
            node.parent.right = successor;
        }

        
   

    }

}


