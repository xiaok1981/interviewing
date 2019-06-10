import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveParaless {
    public String removeInvalidParentheses(String s) {
        if(s==null) return null;
        if(s.isEmpty()) return s;
        while(s.length()>0 && s.charAt(0)==')') {
            s=s.substring(1);
        }

        while(s.length()>=1 && s.charAt(s.length()-1)=='(') {
            s=s.substring(0,s.length()-1);
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            set.add(stack.pop());
        }

        StringBuilder build = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(set.contains(i)) {
                continue;
            }
            build.append(s.charAt(i));
        }
        return build.toString();
    }

    public static void main(String[] args) {
        RemoveParaless mi = new RemoveParaless();
        System.out.println(mi.removeInvalidParentheses("()())()"));
        System.out.println(mi.removeInvalidParentheses(")("));
        System.out.println(mi.removeInvalidParentheses("(a)())()"));
    }

}
