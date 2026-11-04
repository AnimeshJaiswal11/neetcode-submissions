class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        } 
        int[] preCourse = new int[numCourses];
        for(int[] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
            preCourse[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(preCourse[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int curCourse = queue.poll();
            result.add(curCourse);
            for(int childCourse : adj.get(curCourse)){
                preCourse[childCourse]--;
                if(preCourse[childCourse] == 0){
                    queue.add(childCourse);
                }
            }
        }
        return result.size() == numCourses ? result.stream()
                  .mapToInt(Integer::intValue)
                  .toArray() : new int[]{};
    }
}
