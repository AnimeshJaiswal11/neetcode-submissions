class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0 ; i < nums.length-2 ; i++){
            int j = i+1, k = nums.length-1;
            while(j < k){
                int currentSum = nums[i] + nums[j] + nums[k];
                if(currentSum > 0)
                    k--;
                else if(currentSum < 0)
                    j++;
                else{
                    List<Integer> currentSet = new ArrayList<>();
                    currentSet.add(nums[i]); currentSet.add(nums[j]); currentSet.add(nums[k]);
                    set.add(currentSet);
                    k--; j++;
                }
            }
        }
        return set.stream().toList();
    }
}
