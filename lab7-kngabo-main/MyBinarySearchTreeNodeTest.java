import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class MyBinarySearchTreeNodeTest {
    @Test
    void testGetItem() {
        MyBinarySearchTreeNode<Integer> root = new MyBinarySearchTreeNode<Integer>(10);
        Integer expectedItem = 10;
        MyBinarySearchTreeNode expectedParent = null;
        assertEquals(expectedItem, root.getItem());
        assertEquals(expectedParent, root.getParent());
    }

    @Test
    void insert() {
        MyBinarySearchTreeNode<Integer> root = new MyBinarySearchTreeNode<Integer>(10);
        MyBinarySearchTreeNode<Integer> left = root.insert(5);
        MyBinarySearchTreeNode<Integer> right = root.insert(15);

        assertEquals(null, root.insert(10));
        assertEquals(root, left.getParent());
        assertEquals(root, right.getParent());
    }
    
}
