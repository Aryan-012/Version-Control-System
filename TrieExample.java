

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true; // Mark end of the word
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false; // Word not found
            }
            node = node.children.get(ch);
        }
        return node.isEnd; // Check if it's an actual word, not just a prefix
    }
    // Search for a word starts with prefix
    public boolean startsWith(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false; // prefix not found
            }
            node = node.children.get(ch);
        }
        return true; // Check if it's a prefix
    }
}

// Test the Trie
public class TrieExample {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("ape");

        // Search for words
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // true
        System.out.println(trie.search("ap")); // false (only a prefix, not a full word)
        System.out.println(trie.search("bat")); // false (not in Trie)

        // Search for prefix
        System.out.println(trie.startsWith("app")); // true
    }
}
