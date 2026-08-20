class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrowcount=points[0][1];
        int countarrow=1;
        for(int i=1;i<points.length;i++){
            if(arrowcount>=points[i][0]){
                continue;
            }
            countarrow++;
            arrowcount=points[i][1];
        }
        return countarrow;
    }
}