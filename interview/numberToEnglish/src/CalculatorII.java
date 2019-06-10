import java.util.ArrayList;
import java.util.Stack;

public class CalculatorII {

        public int cal(String str) {
            str.trim();
            int len = str.length();
            int num = 0;
            int sign = 1;
            int result=0;
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<= len;i++) {
                if(i == len) {
                    result+=num*sign;
                    break;
                }
                char c = str.charAt(i);
                if(c==' ') {
                    continue;
                }

                if(Character.isDigit(c)) {
                    num = c-'0';
                    while(i+1<len && Character.isDigit(str.charAt(i+1))) {
                        num= num*10 + str.charAt(i+1) - '0';
                        i++;
                    }
                }
                if(c== '+') {
                    result+=num* sign;
                    sign = 1;
                }

                if(c== '-') {
                    result+=num*sign;
                    sign = -1;
                }
                if(c== '(') {
                    stack.push(result);
                    stack.push(sign);
                    result=0;
                    num = 0;
                    sign = 1;
                }
                if(c== ')') {
                    result+=num*sign;
                    result = stack.pop()* result + stack.pop();
                    num = 0;
                    sign =1;
                }
            }
            return result;
        }

        public static void main(String[] args) {
            CalculatorII ca = new CalculatorII();
            System.out.println(ca.cal("-230-(-10-7+9)"));
        }
}