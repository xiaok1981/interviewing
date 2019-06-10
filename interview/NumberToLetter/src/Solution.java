import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
If a=1, b=2, c=3,..j=10..t=20..z=26. Given a string, find all possible codes that string can generate. 

For example: 
Input: "1123". You need to general all valid alphabet codes from this string. 

Output List 
aabc //a = 1, a = 1, b = 2, c = 3 
kbc // since k is 11, b = 2, c= 3 
alc // a = 1, l = 12, c = 3 
aaw // a= 1, a =1, w= 23 
kw // k = 11, w = 23

*/

public class Solution {
    static HashMap<Integer, Character> map = new HashMap<>();
    public static ArrayList<String> numberToString(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.isEmpty()) return list;
        int count =1;
        for(char c='a'; c<='z'; c++) {
            map.put(count++, c);
        }
        StringBuilder build = new StringBuilder();
        helper(str, build, list);
        return list;

    }

    public static void helper(String str, StringBuilder accu, ArrayList<String> list) {
        if(str == "") {
            list.add(accu.toString());
            return;

        }

        if(str.length()>=1 && str.charAt(0)<='9' && str.charAt(0) >='1') {
            accu.append(map.get(Character.getNumericValue(str.charAt(0))));
            if(str.length()==1) {
                helper("", accu, list);
            } else {
                helper(str.substring(1), accu, list);
            }
            accu.deleteCharAt(accu.length()-1);
        }

        if(str.length()>=2 && Integer.valueOf(str.substring(0,2)) <=26 && Integer.valueOf(str.substring(0,2)) >=10 ){
            accu.append(map.get(Integer.valueOf(str.substring(0,2))));
            if(str.length()>2) {
                helper(str.substring(2), accu, list);
            } else {
                helper("", accu, list);
            }
            accu.deleteCharAt(accu.length()-1);
        }

        return;

    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        ArrayList<String> result = numberToString("1123");
        for(String str: result) {
            System.out.println(str);
        }
    }
}