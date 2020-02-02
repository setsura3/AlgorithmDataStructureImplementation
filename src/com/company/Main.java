package com.company;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int nums[] = {5, 3,4, 6, 8, 4, 2};
        for(int num:nums)
            bst.add(num);
        bst.postOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.preOrder();




    }
}
