class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] pair = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> b[0]-a[0]);
        List<Double> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            double time = (double) (target - pair[i][0]) / pair[i][1];
            if(!list.isEmpty() && list.get(list.size()-1) >= time)
                continue;
            else
                list.add(time);
        }
        return list.size();
    }
}
