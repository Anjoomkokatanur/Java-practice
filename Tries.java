public class Tries {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node(){
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level)-'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

       return curr.eow == true;
    }

    public static boolean startsWith(String prefix){
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    public static boolean wordBreak(String key){
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
           if (search(key.substring(0,i)) && wordBreak(key.substring(i))) {
                return true;
           }
        }

        return false;
    }

    public static int countNodes(Node root){
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }

        return count+1;
    }

    public static void main(String[] args){
        // String words[] = {"apple", "app", "sam", "samsung", "mobile", "ice"};

        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }

        // System.out.println(search("thee"));
        // System.out.println(search("thoe"));

        // String key = "ilikesamsung";

        // System.out.println(wordBreak(key));

        // String prefix1 = "app";
        // String prefix2 = "moon";

        // System.out.println(startsWith(prefix1));
        // System.out.println(startsWith(prefix2));

        String str = "apple";

        //suffix -> insert in trie
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));

    }
}
