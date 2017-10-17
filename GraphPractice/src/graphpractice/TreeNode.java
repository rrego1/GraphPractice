/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphpractice;

/**
 *
 * @author reggs
 */
public class TreeNode {

    private int value;
    private TreeNode left;
    private TreeNode right;
    
    TreeNode(){
        value = -1;
        left = null;
        right = null;
    }
    
    TreeNode(int value){
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
     
}
