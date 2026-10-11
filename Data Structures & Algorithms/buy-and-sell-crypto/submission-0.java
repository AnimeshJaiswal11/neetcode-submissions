class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int currentStock = prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] < currentStock)
                currentStock = prices[i];
            else{
                res = Math.max(res, prices[i]-currentStock);
            }
        }
        return res;
    }
}
