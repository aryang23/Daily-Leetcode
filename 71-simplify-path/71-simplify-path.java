class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/+");
        Stack<String> stack = new Stack<>();
        
        for(String t:tokens) {
            if(stack.size()>0 && "..".equals(t)) {
                stack.pop();
            } else  if(!Arrays.asList("",".","..").contains(t)) {
                stack.push(t);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s:stack) {
            sb.append("/").append(s);
        }
        
        return sb.length()== 0 ? "/" : sb.toString();
    }
}