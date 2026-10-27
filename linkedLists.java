public class linkedLists {

    public static class Node {
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node Head;
    public static Node Tail;
    public static int size;

    public void addFirst(int data){
        //step1 = create new node
        Node newNode = new Node(data);
        size++;

        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        //step2 = newNode next = head
        newNode.next = Head; //link

        //step3 = head = newNode
        Head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if (Head == null) {
            Head = Tail = newNode;
        }
        Tail.next = newNode;
        Tail = newNode;
    }

    public void add(int idx, int data){

        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = Head;
        int i = 0;

        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if (size == 0) {
            System.out.println("LL is Empty!!");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }
        int val = Head.data;
        Head = Head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if (size == 0) {
            System.out.println("LL is Empty!!");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }

        //prev : i = size-2
        Node prev = Head;
        for(int i =0; i<size-2;i++){
            prev= prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        Tail = prev;
        size--;

        return val;
    }

    public int itrSearch(int key){
        Node temp = Head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    public int helper(Node Head, int key){
        if (Head == null) {
            return -1;
        }

        if (Head.data == key) {
            return 0;
        }
        int idx = helper(Head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key){
        return helper(Head, key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = Tail = Head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        Head = prev;
    }

    public void deleteNthFromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = Head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            Head = Head.next;
            return;
        }

        //sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = Head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    public boolean checkPalindrome(){
        if (Head == null || Head.next == null) {
            return true;
        }

        //step1 - find mid
        Node midNode = findMid(Head);

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right half head
        Node left = Head;

        //step3 - check left and right half
        while (right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public Node findMid(Node Head){
        Node slow = Head;
        Node fast = Head;

        while (fast != null && fast.next != null) {
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }

        return slow; // slow is mid.
    }

    public boolean isCycle(){
        Node slow = Head;
        Node fast = Head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; //cycle exist
            }
        }
        return false; //cycle doesn't exists
    }

    public static void removeCycle(){
        //detect cycle
        Node slow = Head;
        Node fast = Head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true; //cycle exist
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        //find meeting point
        slow = Head;
        Node prev = null; //last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> last.next = null
        prev.next = null;

        return;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next; 
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    private Node getMid(Node Head){
        Node slow = Head;
        Node fast = Head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node Head){
        if (Head == null || Head.next == null) {
            return Head;
        }
        //find mid
        Node mid = getMid(Head);

        //left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(Head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft,newRight);
    }

    public void zigZag(){
        //find mid
        Node slow = Head;
        Node fast = Head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = Head;
        Node right = prev;
        Node nextL , nextR;

        //alt merge:zig-zag mearge
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    public void print(){
        if (Head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node temp = Head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] arga){

        linkedLists ll = new linkedLists();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
