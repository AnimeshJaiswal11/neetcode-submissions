class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeros = 0;
        for(int num:nums){
            if(num != 0)
                prod = prod*num;
            else
                zeros++;
        }
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(zeros >= 2){
                res[i] = 0;
            }
            else{
                if(zeros == 1){
                    if(nums[i] == 0)
                        res[i] = prod;
                    else
                        res[i] = 0;
                }
                else{
                    res[i] = prod/nums[i];
                }
            }
            
        }
        return res;
    }
}  
