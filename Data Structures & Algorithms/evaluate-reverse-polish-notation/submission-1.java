class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str:tokens){
            if(str.equals("+")){
                int sum = stack.pop() + stack.pop();
                stack.push(sum);
            }
            else if(str.equals("-")){
                int right = stack.pop(), left = stack.pop();
                int sum = left - right;
                stack.push(sum);
            }
            else if(str.equals("*")){
                int sum = stack.pop() * stack.pop();
                stack.push(sum);
            }
            else if(str.equals("/")){
                int right = stack.pop(), left = stack.pop();
                int sum = left / right;
                stack.push(sum);
            }
            else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
