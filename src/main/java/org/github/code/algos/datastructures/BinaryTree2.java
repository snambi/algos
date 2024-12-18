package org.github.code.algos.datastructures;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BinaryTree2 {

    Node root = null;

    public void add( int value){
        if( root == null ){
            root = new Node();
            root.setValue(value);
        }else {
            addRecurvise(getRoot(), value);
        }
    }

    public void inOrderTraversal(){
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(Node node){
        if( node != null ){
            inOrderTraversalRecursive(node.getLeft());
            System.out.print(" "+ node.getValue() +" ");
            inOrderTraversalRecursive(node.getRight());
            //System.out.print(" \n");
        }
    }

    private void addRecurvise(Node node, int value){
            if( value <= node.getValue() ){
                if( node.getLeft() == null){
                    node.setLeft(new Node());
                    node.getLeft().setValue(value);
                }else {
                    addRecurvise(node.getLeft(), value);
                }
            }else{
                if( node.getRight() == null ){
                    node.setRight(new Node());
                    node.getRight().setValue(value);
                }else {
                    addRecurvise(node.getRight(), value);
                }
            }
    }

    @Data
    @NoArgsConstructor
    public static class Node<T>{
        private Node<T> left;
        private Node<T> Right;

        private int value;
    }
}
