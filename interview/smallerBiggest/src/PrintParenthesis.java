import java.util.ArrayList;
import java.util.List;

public class PrintParenthesis {
    public static List<String> result = new ArrayList<>();
    public static void printP(int n) {
        helper("", n, n, 0);

    }

    private static void helper(String str, int n, int m, int left) {
        if(n==0 && m==0) {
            result.add(str);
            return;
        }
        if(n>0) {
            helper(str+"(", n-1, m, left+1);
        }

        if(left>0) {
            helper(str+")", n, m-1, left-1);
        }
    }

    public static void main(String [] args) {
        printP(3);
        for(String ele: result) {
            System.out.println(ele);
        }
    }
}
