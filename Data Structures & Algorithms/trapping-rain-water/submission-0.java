class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxPrefix = new int[n];
        maxPrefix[0] = height[0];
        for(int i = 1 ; i < n ; i++){
            maxPrefix[i] = Math.max(maxPrefix[i-1], height[i]);
        }
        int[] maxSuffix = new int[n];
        maxSuffix[n-1] = height[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            maxSuffix[i] = Math.max(maxSuffix[i+1], height[i]);
        }
        int result = 0;
        for(int i = 1 ; i < n-1 ; i++){
            int min = Math.min(maxPrefix[i], maxSuffix[i]);
            result += min-height[i];
        }
        return result;
    }
}
