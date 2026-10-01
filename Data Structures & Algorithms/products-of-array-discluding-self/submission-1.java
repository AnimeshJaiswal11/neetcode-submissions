class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n];
        prefixProd[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            prefixProd[i] = nums[i] * prefixProd[i-1];
        }
        int[] suffixProd = new int[n];
        suffixProd[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            suffixProd[i] = nums[i]*suffixProd[i+1];
        }
        int[] res = new int[n];
        for(int i = 1 ; i < n-1 ; i++){
            res[i] = prefixProd[i-1] * suffixProd[i+1];
        }
        res[0] = suffixProd[1];
        res[n-1] = prefixProd[n-2];
        return res;
    }
}  
