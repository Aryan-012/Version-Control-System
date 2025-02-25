import java.util.*;

class TrieNode {
    boolean isEndOfString;
    HashMap<Character, TrieNode> children;

    TrieNode() {
        isEndOfString = false;
        children = new HashMap<>();
    }
}

class Tries {
    private final TrieNode root;

    public Tries() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (Character ch : word.toCharArray()) {
            temp.children.putIfAbsent(ch, new TrieNode());
            temp = temp.children.get(ch);
        }
        temp.isEndOfString = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (Character ch : word.toCharArray()) {
            if (!temp.children.containsKey(ch)) return false;
            temp = temp.children.get(ch);
        }
        return temp.isEndOfString;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (Character ch : prefix.toCharArray()) {
            if (!temp.children.containsKey(ch)) return false;
            temp = temp.children.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   
        System.out.println(trie.search("app"));     
        System.out.println(trie.startsWith("app")); 
        trie.insert("app");
        System.out.println(trie.search("app"));     
    }
}