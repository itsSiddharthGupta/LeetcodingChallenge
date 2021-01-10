package leetcode_challenge_jan.week2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	//Uni-Directional BFS
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> words = new HashSet(wordList);
        words.remove(beginWord);
        q.add(beginWord);
        int length = 0;
        while(!q.isEmpty()){
            int size = q.size();
            length++;
            for(int i = 0;i<size;i++){
                String cw = q.poll();
                if(cw.equals(endWord)) return length;
                List<String> neighbors = neighbors(cw);
                for(String neigh: neighbors){
                    if(words.contains(neigh)){
                        q.add(neigh);
                        words.remove(neigh);
                    }
                }
            }
        }
        return 0;
    }
	
	//Bi-Directional BFS
	public int ladderLengthBiDir(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int length = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }
            Set<String> newBeginSet = new HashSet();
            for(String cw: beginSet){
                List<String> neighbors = neighbors(cw);
                for(String neigh: neighbors){
                    if(endSet.contains(neigh)) return length+1;
                    if(words.contains(neigh)){
                        newBeginSet.add(neigh);
                        words.remove(neigh);
                    }
                }
            }
            beginSet = newBeginSet;
            length++;
        }
        return 0;
    }
    
    private List<String> neighbors(String str){
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        for(int i = 0;i<chars.length;i++){
            char temp = chars[i];
            for(char j = 'a';j<='z';j++){
                chars[i] = j;
                String adj = new String(chars);
                ans.add(adj);
            }
            chars[i] = temp;
        }
        return ans;
    }
}
