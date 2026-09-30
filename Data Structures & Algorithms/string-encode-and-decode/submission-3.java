class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.size() == 0)
            return "";
        for(String s:strs){
            sb.append(s);
            if(s.equals("")){
                sb.append("empty");
            }
            sb.append("-#-");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        String[] arr = str.split("-#-");
        List<String> res = new ArrayList<>();
        if(str.equals(""))
            return res;
        for(String s : arr){
            if(s.equals("empty")){
                res.add("");
            }
            else{
                res.add(s);
            }
        }
        return res;
    }
}
