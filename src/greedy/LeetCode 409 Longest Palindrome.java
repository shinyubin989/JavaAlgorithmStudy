class Solution {
    public int longestPalindrome(String s) {
      int length = 0;
      HashSet<Character> set = new HashSet<>();
      for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(set.contains(c)){
          length += 2;
          set.remove(c);
        }else{
          set.add(c);
        }
      }
      if(set.size() > 0) length ++;
      return length;
    }
}
