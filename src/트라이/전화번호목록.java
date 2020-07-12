package 트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 전화번호목록 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int givenNumber = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < givenNumber; ++i) {
            Trie trie = new Trie();
            List<String> listWord = new ArrayList<>();

            int wordNumber = Integer.parseInt(buffer.readLine());
            for (int k = 0; k < wordNumber; ++k) {
                String word =  buffer.readLine();
                trie.insert(word);
                listWord.add(word);
            }

            for (int k = 0; k < wordNumber; ++k) {
                trie.contains(listWord.get(k));
            }

        }
    }

}

class Trie {

    private TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    void insert(String word) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); ++i) {
            thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }

        thisNode.setLastChar(true);
    }

    boolean contains(String word) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < word.length(); ++i) {
            TrieNode node = thisNode.getChildNode().get(word.charAt(i));

            if (node == null)
                return false;

            thisNode = node;
        }

        return thisNode.isLastChar();
    }

}

class TrieNode {

    private Map<Character, TrieNode> childNode = new HashMap<>();
    private boolean isLastChar;

    public void setChildNode(Map<Character, TrieNode> childNode) {
        this.childNode = childNode;
    }

    public Map<Character, TrieNode> getChildNode() {
        return childNode;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean lastChar) {
        isLastChar = lastChar;
    }
}