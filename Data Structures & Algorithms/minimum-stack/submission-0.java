class MinStack {

    List<Integer> list;
    List<Integer> minList;
    int idx;

    public MinStack() {
        this.list = new ArrayList<>();
        this.idx = -1;
        this.minList = new ArrayList<>();
    }
    
    public void push(int val) {
        this.idx++;
        this.list.add(idx, val);
        if(minList.isEmpty() || minList.get(minList.size()-1) >= val){
            minList.add(val);
        }
    }
    
    public void pop() {
        int result = list.get(idx);
        idx--;
        if(result == minList.get(minList.size()-1)){
            minList.remove(minList.size()-1);
        }
    }
    
    public int top() {
        return list.get(idx);
    }
    
    public int getMin() {
        return minList.get(minList.size()-1);
    }
}
