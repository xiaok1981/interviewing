/**

 Given some integer intervals, merge all overlapping intervals.

 Example: Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]

 */
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public class Interval {
        int start;
        int end;
        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public int [][] merge(int [][]intervals) {
        if(intervals == null || intervals.length==0 || intervals[0].length==0) {
            return new int[0][0];
        }
        ArrayList<Interval> list = new ArrayList<>();
        for(int i=0; i<intervals.length;i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, Comparator.comparingInt((Interval a)-> a.start));
        ArrayList<Interval> second = new ArrayList<>();
        Interval node = list.remove(0);
        second.add(node);
        while(list.size()!=0) {
            Interval pre = second.remove(second.size() - 1);
            Interval cur = list.remove(0);
            if(pre.end < cur.start) {
                second.add(pre);
                second.add(cur);
            } else {
                second.add(new Interval(pre.start, Math.max(cur.end, pre.end)));

            }
        }
        int [][]result = new int[second.size()][2];
        for(int i=0; i< second.size();i++) {
            result[i][0] = second.get(i).start;
            result[i][1] = second.get(i).end;

        }
        return result;
    }
    /**

     Given some integer intervals, merge all overlapping intervals.

     Example: Input: [[1,3],[2,6],[8,10],[0,18]]
     Output: [[1,6],[8,10],[15,18]]

     */

    public static void main(String[] args) {

        int [][] input = new int[4][2];
        input[0][0] = 1;
        input[0][1] = 3;
        input[1][0] = 2;
        input[1][1] = 6;
        input[2][0] = 8;
        input[2][1] = 10;
        input[3][0] = 0;
        input[3][1] = 18;
        Solution sol = new Solution();
        int [][] output = sol.merge(input);

        for(int i=0; i<output.length; i++) {
            System.out.println(output[i][0] + ":" + output[i][1]);
        }
    }
}
