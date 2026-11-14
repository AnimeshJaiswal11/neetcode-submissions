class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Map<String, Integer> map = new HashMap<>();
        return helper(prices, n, 0, 1, -1, map);
    }

    public int helper(int[] prices, int n, int i, int buy, int last, Map<String, Integer> map){
        if(i >= n)
            return 0;
        int res = 0;
        String key = i + "--" + buy + "--" + last;
        if(map.containsKey(key))
            return map.get(key);
        if(buy == 1){
            res = Math.max(helper(prices, n, i+1, 1, last, map), helper(prices, n, i+1, 2, i, map));
        }
        else{
            res = Math.max((prices[i]-prices[last]+helper(prices, n, i+2, 1, last, map)), helper(prices, n, i+1, 2, last, map));
        }
        map.put(key, res);
        return res;
    }
}
