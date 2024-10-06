package pa4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void testInsert() {
        BST bst = new BST();
        assertEquals("", bst.inOrder());
        bst.insert(5);
        assertEquals("5 ", bst.inOrder());
        bst.insert(3);
        assertEquals("3 5 ", bst.inOrder());
        bst.insert(7);
        assertEquals("3 5 7 ", bst.inOrder());

        // Test connections 
        assertEquals(5, bst.root.value);
        assertEquals(3, bst.root.left.value);
        assertEquals(7, bst.root.right.value);
    }

    @Test
    void testDelete() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.delete(3);
        assertEquals("5 7 ", bst.inOrder());
        bst.delete(5);
        assertEquals("7 ", bst.inOrder());
        bst.delete(7);
        assertEquals("", bst.inOrder());

        // Test connections
        assertNull(bst.root);

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);

        bst.delete(4);
        assertEquals("2 3 5 6 7 ", bst.inOrder());
        assertEquals(3, bst.root.left.value);
        assertEquals(null, bst.root.left.right);
    }

    @Test
    void testSearch() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        
        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertFalse(bst.search(2));
        assertFalse(bst.search(6));
    }

    @Test
    void testUpdate() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        
        bst.update(3, 4);
        assertEquals("4 5 7 ", bst.inOrder());
        assertFalse(bst.search(3));
        assertTrue(bst.search(4));

        bst.update(5, 6);
        assertEquals("4 6 7 ", bst.inOrder());
        assertFalse(bst.search(5));
        assertTrue(bst.search(6));
    }

    @Test
    void testSortedArrayToBST() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        BST.Node root = BST.sortedArrayToBST(arr);
        assertEquals(4, root.value); 
        assertEquals(2, root.left.value); 
        assertEquals(6, root.right.value); 
    }

    @Test
    void testLowestCommonAncestor() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        assertEquals(3, bst.lowestCommonAncestor(2, 4).value);
        assertEquals(5, bst.lowestCommonAncestor(2, 6).value);
        assertEquals(3, bst.lowestCommonAncestor(2, 3).value);
    }

    @Test
    void testInOrderTraversalAfterMultipleOperations() {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.delete(3);
        assertEquals("2 4 5 6 7 8 ", bst.inOrder());

        bst.update(4, 1);
        assertEquals("1 2 5 6 7 8 ", bst.inOrder());
        
        bst.delete(5);
        assertEquals("1 2 6 7 8 ", bst.inOrder());
    }
}
