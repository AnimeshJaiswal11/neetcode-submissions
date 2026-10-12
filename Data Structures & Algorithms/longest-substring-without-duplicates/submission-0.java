class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int res = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(!set.contains(c)){
                j++;
                set.add(c);
            }
            else{
                while(i < j && s.charAt(i) != c){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            }
            res = Math.max(res, j-i);
        }
        return res;
    }
}