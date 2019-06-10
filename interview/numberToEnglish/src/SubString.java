public class SubString {
    public static boolean subString(String str, String substr) {
        if (substr == null || substr.isEmpty()) return true;
        if (str == null || str.isEmpty()) return false;
        int len = str.length();
        int len2 = substr.length();
        int[][] dp = new int[len+1][len2+1];
        int max = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str.charAt(i-1) == substr.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1]+1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        //System.out.println(max);
        return max == substr.length();
    }

    public static void main(String[] args) {
        System.out.println(subString("hahahaha", "haa"));
    }
}