package com.company;
import java.util.Stack;
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    //get the size of BST
    public int size() {
        return size;
    }

    //check if BST is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //add an element to BST
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    //check if a BST contains an element
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.e);
        inOrder(node.right);
    }

    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        else
            return minimum(node.left);
    }
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node maxNode = maximum(root);
        return maxNode.e;
    }
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        else
            return maximum(node.right);
    }
    public E removeMin(){
        E ret = minimum();
        removeMin(root);

        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E ret = maximum();
        removeMax(root);

        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

}


