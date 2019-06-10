import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

    class Task{
        String name;
        int start;
        public Task(String name, int start) {
            this.name= name;
            this.start = start;
        }

    }

    public HashMap<String, Integer> calTask(String []str) throws Exception{

        HashMap<String, Integer> result = new HashMap<>();

        Stack<Task> stack = new Stack<>();
        int accuSum = 0;
        for(int i=0; i<str.length;i++) {
            String []ele = str[i].split(":");
            if(ele[1].equals("start")) {
                stack.push(new Task(ele[0], Integer.valueOf(ele[2])));
                accuSum = 0;
            } else {
                Task start = stack.pop();
                if(!start.name.equals(ele[0])) {
                    throw new Exception("illegal input stream");
                }
                result.put(ele[0], result.getOrDefault(ele[0], 0) + Integer.valueOf(ele[2]) - start.start);
                accuSum+= Integer.valueOf(ele[2]) - start.start;
                if(stack.size()>=1) {
                    Task top = stack.pop();
                    top.start+=accuSum;
                    stack.push(top);
                } else {
                    accuSum = 0;
                }
            }
        }
        return result;

    }


    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        String [] inputs = {
                "f1:start:1200",
                "f2:start:1300",
                "f2:end:1340",
                "f3:start:1400",
                "f5:start:1410",
                "f5:end:1420",
                "f3:end:1440",
                "f1:end:1500"};

        HashMap<String, Integer> result = sol.calTask(inputs);
        for(String ele: result.keySet()) {

            System.out.println(ele+ " : " + result.get(ele));
        }

    }
}
