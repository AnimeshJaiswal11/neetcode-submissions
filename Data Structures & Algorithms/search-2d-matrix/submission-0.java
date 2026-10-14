class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] mat:matrix){
            if(mat[0] <= target && mat[mat.length-1] >= target){
                int low = 0, high = mat.length-1;
                while(low <= high){
                    int mid = low + (high-low)/2;
                    if(mat[mid] == target){
                        return true;
                    }
                    else if(mat[mid] < target){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
        }
        return false;
    }
}
