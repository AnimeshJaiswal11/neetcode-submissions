class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int res = 0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int current = num;
                int count = 0;
                while(set.contains(current)){
                    count++;
                    current++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
