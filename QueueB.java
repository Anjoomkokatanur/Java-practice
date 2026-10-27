import java.util.*;
public class QueueB {
    static class QueueToStack { //Queue using two Stacks
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //add
        public static void add(int data){
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        //remove
        public static int remove(){
            if (isEmpty()) {
                System.out.println("Queue id empty");
                return -1;
            }
            return s1.pop();
        }

        //peek
        public static int peek(){
            if (isEmpty()) {
                System.out.println("Queue id empty");
                return -1;
            }
            return s1.peek();
        }
    }

    static class StackToQueue {
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop(){
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            int top = -1;
            if (!q1.isEmpty()) { // case1
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {// case2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek(){
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            int top = -1;
            if (!q1.isEmpty()) { // case1
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {// case2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void printFirstNonRepeating(String str){
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1+" ");
            } else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    public static void interLeave(Queue<Integer> q){

        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i=0; i<size/2; i++){
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }


    public static void main(String[] args){
        //Queue<Integer> q = new LinkedList<>(); //ArrayDeque
        // Queue<Integer> q = new ArrayDeque<>()
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // String str = "aabccxb";
        // printFirstNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interLeave(q);
        //print Q
        while (!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
    }
}
