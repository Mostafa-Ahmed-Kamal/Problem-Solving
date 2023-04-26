package LeetCode.HardProblems;

import java.util.*;

public class ConcatenatedWords {
    private static class Trie{
        boolean isWord=false;
        HashMap<Character,Trie> children;
        public Trie(){
            children = new HashMap<>();
        }
    }
    Trie root;
    List<String> result;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        result = new LinkedList<>();
        root = new Trie();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word:words){
            boolean wordIsConcatenation = checkConcatenation(word,0,0);
            if(wordIsConcatenation)result.add(word);
            else addWord(word);
        }
        return result;
    }
    private void addWord(String word){
        Trie currentNode = root;
        for (char c:word.toCharArray()){
            currentNode.children.putIfAbsent(c, new Trie());
            currentNode = currentNode.children.get(c);
        }
        currentNode.isWord = true;
    }
    private boolean checkConcatenation(String word, int wordsCount, int currentPosition){
        if(currentPosition>=word.length()){
            return wordsCount>1;
        }
        Trie concatenationChecker = root;
        for (int i=currentPosition; i<word.length(); i++){
            char c = word.charAt(i);
            if(concatenationChecker.isWord && checkConcatenation(word, wordsCount+1, i))
                return true;
            if(!concatenationChecker.children.containsKey(c))
                return false;
            concatenationChecker = concatenationChecker.children.get(c);
        }
        return concatenationChecker.isWord && wordsCount+1>1;
    }

    public static void main(String[] args) {
        ConcatenatedWords cw = new ConcatenatedWords();
        String[] words = {"cat","dog","catdog"};
        System.out.println(cw.findAllConcatenatedWordsInADict(words));
    }
}
