class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '{' || c == '(' || c == '[')
                stack.push(c);
            else if(stack.isEmpty())
                return false;
            else{
                char last = stack.pop();
                if((c == ')' && last == '(') || (c == '}' && last == '{') || (c == ']' && last == '['))
                    continue;
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
