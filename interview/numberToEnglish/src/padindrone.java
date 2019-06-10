public class padindrone {

    public int minDeletion(String s) {
        final int n = s.length();
        final int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) dp[j][i] = i - j <= 1 ? 0 : dp[j + 1][i - 1];
                else dp[j][i] = Math.min(dp[j + 1][i], dp[j][i - 1]) + 1;
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        padindrone ca = new padindrone();
        System.out.println(ca.minDeletion("zbaaaa"));
    }
}
