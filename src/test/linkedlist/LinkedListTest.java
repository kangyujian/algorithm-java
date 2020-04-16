package test.linkedlist;

import linkedlist.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> mylist=new LinkedList<>();
        for (int i=0;i<10;i++){
            mylist.addLast(i);
            System.out.println(mylist);
        }
    }
}
