import java.util.ArrayList;

public class Calculator {

    public int cal(String str) {
        str.trim();
        int len = str.length();
        int num = 0;
        int sign = 1;
        int result = 0;
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
                result+=(num*sign);
                sign = 1;
            }

            if(c== '-') {
                result+=num*sign;
                sign = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Calculator ca = new Calculator();
        System.out.println(ca.cal("230+10-7"));
    }
}
