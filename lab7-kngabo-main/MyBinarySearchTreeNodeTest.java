import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        Integer expecInteger = 10;

        assertEquals(null, root.insert(10));
        assertEquals(expecInteger, left.getParent().getItem());
        assertEquals(expecInteger, right.getParent().getItem());


    }

    @Test
    void preOrder(){
    MyBinarySearchTreeNode<Integer> cs151 = new MyBinarySearchTreeNode<Integer>(151);
    MyBinarySearchTreeNode<Integer> cs150 = cs151.insert(150);
    MyBinarySearchTreeNode<Integer> cs241 = cs151.insert(241);
    MyBinarySearchTreeNode<Integer> cs275 = cs241.insert(275);
    MyBinarySearchTreeNode<Integer> cs280 = cs275.insert(280);
    MyBinarySearchTreeNode<Integer> cs210 = cs241.insert(210);

    List<Integer> pre_orderList = new ArrayList<Integer>();
    List<Integer> expectedList = new ArrayList<>(Arrays.asList(151, 150, 241, 210, 275, 280));

    cs151.preOrder(pre_orderList);
    assertEquals(expectedList, pre_orderList);
    }

    @Test
    void inOrder(){
    MyBinarySearchTreeNode<Integer> cs151 = new MyBinarySearchTreeNode<Integer>(151);
    MyBinarySearchTreeNode<Integer> cs150 = cs151.insert(150);
    MyBinarySearchTreeNode<Integer> cs241 = cs151.insert(241);
    MyBinarySearchTreeNode<Integer> cs275 = cs241.insert(275);
    MyBinarySearchTreeNode<Integer> cs280 = cs275.insert(280);
    MyBinarySearchTreeNode<Integer> cs210 = cs241.insert(210);

    List<Integer> inorderList = new ArrayList<Integer>();
    List<Integer> expectedList = new ArrayList<>(Arrays.asList(150, 151, 210, 241, 275, 280));

    cs151.inOrder(inorderList);
    assertEquals(expectedList, inorderList);
    }

    @Test
    void postOrder(){
    MyBinarySearchTreeNode<Integer> cs151 = new MyBinarySearchTreeNode<Integer>(151);
    MyBinarySearchTreeNode<Integer> cs150 = cs151.insert(150);
    MyBinarySearchTreeNode<Integer> cs241 = cs151.insert(241);
    MyBinarySearchTreeNode<Integer> cs275 = cs241.insert(275);
    MyBinarySearchTreeNode<Integer> cs280 = cs275.insert(280);
    MyBinarySearchTreeNode<Integer> cs210 = cs241.insert(210);

    List<Integer> postorderList = new ArrayList<Integer>();
    List<Integer> expectedList = new ArrayList<>(Arrays.asList(150, 210, 280, 275, 241, 151));

    cs151.postOrder(postorderList);
    assertEquals(expectedList, postorderList);
    }

    @Test
    void find(){
    MyBinarySearchTreeNode<Integer> tree = new MyBinarySearchTreeNode<Integer>(151);
    tree.insert(150);
    tree.insert(241);
    tree.insert(275);
    tree.insert(280);
    tree.insert(210);
    

    Integer expInteger1 = 280;
    Integer expInteger2 = 210;
    assertEquals(null, tree.find(400));
    assertEquals(expInteger1, tree.find(280).getItem());
    assertEquals(expInteger2, tree.find(210).getItem());
    
    }

    @Test
    void remove(){
        MyBinarySearchTreeNode<Integer> tree = new MyBinarySearchTreeNode<Integer>(151);
        tree.insert(150);
        tree.insert(241);
        tree.insert(275);
        tree.insert(280);
        tree.insert(210);

        tree.remove(150);
        tree.remove(280);
        tree.remove(241);

        assertEquals(null, tree.find(150));
        assertEquals(null, tree.find(280));

    }

}
    
