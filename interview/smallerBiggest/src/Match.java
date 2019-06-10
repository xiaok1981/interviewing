public class Match {

    public boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;
        if(p.isEmpty()) return s.isEmpty();
        if(s.isEmpty()) return p.isEmpty() || onlyContainsStar(p);
        int sLen = s.length();
        int pLen = p.length();
        boolean [][] dp = new boolean [pLen+1][sLen+1];
        dp[0][0] = true;
        for(int i=1; i<=pLen; i++) {
            dp[i][0] = p.charAt(i-1) == '*' && dp[i-1][0];
        }
        for(int i=0; i<pLen; i++) {
            for(int j=0; j<sLen; j++) {
                if(s.charAt(j) == p.charAt(i) || p.charAt(i) == '?') {
                    dp[i+1][j+1] = dp[i][j];
                } else if(p.charAt(i) == '*') {
                    dp[i+1][j+1] = dp[i][j] || dp[i][j+1] || dp[i+1][j];
                } else {
                    dp[i+1][j+1] = false;
                }
            }
        }
        return dp[pLen][sLen];
    }

    public boolean onlyContainsStar(String p) {
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i)!='*') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Match mi = new Match();
        System.out.println(mi.isMatch("aaaab", "?*b"));
        System.out.println(mi.isMatch("ab", "*"));
        System.out.println(mi.isMatch("abc", "bc"));
    }
}
