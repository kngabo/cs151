import java.util.List;

public class MyBinarySearchTreeNode<T extends Comparable>{
    private T item;
    private MyBinarySearchTreeNode<T> parent = null;
    private MyBinarySearchTreeNode<T> leftChild;
    private MyBinarySearchTreeNode<T> rightChild;

    private MyBinarySearchTreeNode(T item, MyBinarySearchTreeNode<T> parent){
        this.item = item;
        this.parent = parent;
        this.leftChild = null;
        this.rightChild = null;
    }

    public T getLeftChild(){
        return this.leftChild.getItem();
    }
    public MyBinarySearchTreeNode(T item){
        this(item, null);
    }

    public T getItem(){
        return this.item;
    }

    public MyBinarySearchTreeNode<T> getParent(){
        return this.parent;
    }

    public MyBinarySearchTreeNode<T> insert(T item){
        if(this.item.compareTo(item) == 0){
            return null;
        }
        
        if(this.item.compareTo(item) > 0){
            if(this.leftChild == null){
                this.leftChild = new MyBinarySearchTreeNode<>(item, this);
                return this.leftChild;
            }
            return this.leftChild.insert(item);
        }
    
        if(this.item.compareTo(item) < 0){
            if(this.rightChild == null){
                this.rightChild = new MyBinarySearchTreeNode<>(item, this);
                return this.rightChild;
            }
            return this.rightChild.insert(item);
        }
    
        return null;
    }

    public MyBinarySearchTreeNode<T> find(Object obj){

        if(this.item.compareTo(obj) == 0){
            return this;
        }

        if(this.item.compareTo(obj) > 0){
            if(this.leftChild != null){
                return this.leftChild.find(obj);
            }else{
                return null;
            }
        }

        if(this.item.compareTo(obj) < 0){
            if(this.rightChild != null){
                return this.rightChild.find(obj);
            }else{
                return null;
            }
        }

        return null;
    }
    

    public void preOrder(List<T> orderList){

        orderList.add(this.item);

        if(this.leftChild != null){
            this.leftChild.preOrder(orderList);
        }

        if(this.rightChild != null){
            this.rightChild.preOrder(orderList);
        }
    }  

    public void inOrder(List<T> orderList){
        if(this.leftChild != null){
            this.leftChild.inOrder(orderList);
        }
    
        orderList.add(this.item);
    
        if(this.rightChild != null){
            this.rightChild.inOrder(orderList);
        }
    }
    
    public void postOrder(List<T> orderList){
        if(this.leftChild != null){
            this.leftChild.postOrder(orderList);
        }
    
        if(this.rightChild != null){
            this.rightChild.postOrder(orderList);
        }
    
        orderList.add(this.item);
    }

    private MyBinarySearchTreeNode<T> findSuccessor(){  
        MyBinarySearchTreeNode<T> successor = this.rightChild;

        while(successor.leftChild != null){
            successor = successor.leftChild;
        }

        return successor;
    }

    public void remove(T item){

        if(this.item.compareTo(item) == 0){
    
            if(this.leftChild == null && this.rightChild == null){
                // If the current node is a leaf
                if(this.parent != null) {
                    if(this.parent.leftChild == this){
                        this.parent.leftChild = null;
                    } else if(this.parent.rightChild == this) {
                        this.parent.rightChild = null;
                    }
                }
            }
            else if(this.leftChild == null){
                // If the current node has only a right child
                if(this.parent != null) {
                    if(this.parent.leftChild == this){
                        this.parent.leftChild = this.rightChild;
                    } else if(this.parent.rightChild == this) {
                        this.parent.rightChild = this.rightChild;
                    }
                } else {
                    this.item = this.rightChild.item;
                    this.leftChild = this.rightChild.leftChild;
                    this.rightChild = this.rightChild.rightChild;
                }
            }
            else if(this.rightChild == null){
                // If the current node has only a left child
                if(this.parent != null) {
                    if(this.parent.leftChild == this){
                        this.parent.leftChild = this.leftChild;
                    } else if(this.parent.rightChild == this) {
                        this.parent.rightChild = this.leftChild;
                    }
                } else {
                    this.item = this.leftChild.item;
                    this.rightChild = this.leftChild.rightChild;
                    this.leftChild = this.leftChild.leftChild;
                }
            }
            else {
                // If the current node has two children
                MyBinarySearchTreeNode<T> sucNode = this.findSuccessor();
                remove(sucNode.item);
                this.item = sucNode.item;
            }
        }
    
        else if(this.item.compareTo(item) > 0){
            if(this.leftChild != null){
                this.leftChild.remove(item);
            }
        }
    
        else if(this.item.compareTo(item) < 0){
            if(this.rightChild != null){
                this.rightChild.remove(item);
            }
        }
    }    

}