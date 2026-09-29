class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new  HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i);
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 26 ; i++){
                sb.append(freq[i] + "");
                sb.append("-");
            }
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(s);
            }
            else{
                map.put(sb.toString(), new ArrayList<String>());
                map.get(sb.toString()).add(s);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
