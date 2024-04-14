import java.util.List;

public class MyBinarySearchTreeNode<T extends Comparable> {
    private T item;
    private MyBinarySearchTreeNode<T> parent = null;
    private MyBinarySearchTreeNode<T> leftChild = null;
    private MyBinarySearchTreeNode<T> rightChild = null;

    private MyBinarySearchTreeNode(T item, MyBinarySearchTreeNode<T> parent){
        this.item = item;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
        
        if(this.item.compareTo(item) < 0){
            if(this.leftChild == null){
                this.leftChild = new MyBinarySearchTreeNode<>(item, this);
                return this.leftChild;
            }
            return this.leftChild.insert(item);
        }

        if(this.item.compareTo(item) > 0){
            if(this.rightChild == null){
                this.rightChild = new MyBinarySearchTreeNode<>(item, this);
                return this.rightChild;
            }
            return this.rightChild.insert(item);
        }

        return null;
    }

    public void preOrder(List orderList){
        orderList.add(this.item);
        if(this.rightChild != null){
            this.rightChild.preOrder(orderList);
        }

        if(this.leftChild == null){
            this.leftChild.preOrder(orderList);
        }
    }  
}
