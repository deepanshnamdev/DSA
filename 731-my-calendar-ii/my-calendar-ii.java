class MyCalendarTwo {
    //booking list
    //overlap list
    // fn to find overlap interval
    // fn to check overlap
    List<int[]> booking;
    List<int[]> overlap;
    public boolean isoverlap(int s1,int e1,int s2,int e2){
        return s1<e2 && s2<e1;
    }
    public int[] overlapinterval(int s1,int e1,int s2,int e2){
        return new int[]{
            Math.max(s1,s2),
            Math.min(e1,e2)
        };
    }
    public MyCalendarTwo() {
        booking=new ArrayList<>();
        overlap=new ArrayList<>();

    }
    
    public boolean book(int startTime, int endTime) {
        for(int [] b: overlap){
            if(isoverlap(startTime,endTime,b[0],b[1])){
                return false;
            }
        }
        for(int[]b:booking){
            if(isoverlap(startTime,endTime,b[0],b[1])){
                int [] overlappart=overlapinterval(startTime,endTime,b[0],b[1]);
            overlap.add(overlappart);
            }
        }
        booking.add (new int[]{startTime,endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */