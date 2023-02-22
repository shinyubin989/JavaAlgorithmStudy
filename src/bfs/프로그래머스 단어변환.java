import java.util.*;

class Solution {
    class Node{
        String next;
        int edge;
        
        public Node(String next, int edge){
            this.next = next;
            this.edge = edge;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int size = words.length;
        
        Queue<Node> queue = new LinkedList<>();
        boolean[] checked = new boolean[size];
        queue.add(new Node(begin, 0));
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.next.equals(target)){
                answer = cur.edge;
                break;
            }
            for(int i=0; i<size; i++){
                if(!checked[i] && isNext(cur.next, words[i])){
                    checked[i] = true;
                    queue.add(new Node(words[i], cur.edge+1));
                }
            }
        }
        
        return answer;
    }
    
    public boolean isNext(String cur, String word){
        int count = 0;
        for(int i=0; i<word.length(); i++){
            if(cur.charAt(i) != word.charAt(i)){
                if(++count > 1) return false;
            }
        }
        return true;
    }
}
