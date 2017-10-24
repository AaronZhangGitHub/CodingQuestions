public class MinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points==null||points.length<1){return 0;}
        Arrays.sort(points, (a, b)->(a[0]-b[0]));
        int range = points[0][1];
        int count = 1;
        for(int i = 1;i<points.length;i++){
            if(range>=points[i][0]){
                range = Math.min(points[i][1],range);
                continue;
            }else{
                //next grouping
                range = points[i][1];
                count++;
            }
        }
        return count;
    }
}
