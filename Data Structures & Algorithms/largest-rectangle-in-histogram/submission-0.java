class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] right = new int[n];
        Stack<int[]> stack = new Stack<>();

        // Number of bars we can extend to the right
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peek()[0] > heights[i]) {

                int idx = stack.pop()[1];
                right[idx] = i - idx - 1;
            }

            stack.push(new int[]{heights[i], i});
        }

        // Remaining bars can extend till the end
        while (!stack.isEmpty()) {
            int idx = stack.pop()[1];
            right[idx] = n - idx - 1;
        }

        int[] left = new int[n];

        // Number of bars we can extend to the left
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek()[0] > heights[i]) {

                int idx = stack.pop()[1];
                left[idx] = idx - i - 1;
            }

            stack.push(new int[]{heights[i], i});
        }

        // Remaining bars can extend till the beginning
        while (!stack.isEmpty()) {
            int idx = stack.pop()[1];
            left[idx] = idx;
        }

        int res = 0;

        for (int i = 0; i < n; i++) {

            int current =
                heights[i] * (left[i] + right[i] + 1);

            res = Math.max(res, current);
        }

        return res;
    }
}