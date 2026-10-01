class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num:nums){
            if(map.containsKey(num))
                continue;
            int cur = 1;
            if(map.containsKey(num-1)){
                cur = map.get(num-1)+1;
            }
            map.put(num, cur);
            res = Math.max(res, map.get(num));
            while(map.containsKey(num+1)){
                map.put(num+1, map.get(num)+1);
                res = Math.max(res, map.get(num+1));
                num++;
            }
        }
        return res;
    }
}
