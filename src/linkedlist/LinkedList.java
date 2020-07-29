package linkedlist;

public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;


        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return  e.toString();
        }

    }

    private Node head;
    private int size;
    private Node tail;

    public LinkedList(){
        this.head=new Node(null,null);
        this.size=0;
        this.tail=null;
    }

    public LinkedList(E[] arr){
        if (arr==null) return;
        for (int i=0;i<arr.length;i++){
            addLast(arr[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void addFirst(E e){
        add(e,0);
    }

    public E get(int index){
        if (index<0||index>size){
            throw  new IllegalArgumentException("get failed, Illegal index.");
        }
        Node cur=head.next;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index,E e){
        if (index<0||index>=size){
            throw new IllegalArgumentException("update failed,Illegal index.");
        }
        Node cur=head.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.e=e;
    }

    public boolean contains(E e){
        Node cur=head.next;
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }


    public void add(E e,int index){
        if (index<0||index>size){
            throw  new IllegalArgumentException("add failed, Illegal index.");
        }
        Node prev=head;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node newnode=new Node(e);
        if(prev.next==null){
            tail=newnode;
        }
        newnode.next=prev.next;
        prev.next=newnode;
        size++;

    }

    public void addLast(E e){
        add(e,size);
    }

    @Override
    public String toString(){
        Node temp=head.next;
        StringBuilder sb =new StringBuilder();
        sb.append("head [ ");
        while(temp!=null){
            sb.append(temp.e);
            if(temp.next!=null){
                sb.append(",");
            }
            temp=temp.next;
        }
        sb.append(" ] tail");
        return sb.toString();
    }
}
