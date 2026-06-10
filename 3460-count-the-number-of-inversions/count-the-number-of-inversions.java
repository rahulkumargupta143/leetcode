class Solution {

    private static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {

        int[] req = new int[n];
        java.util.Arrays.fill(req, -1);

        int maxInv = 0;

        for (int[] r : requirements) {
            req[r[0]] = r[1];
            maxInv = Math.max(maxInv, r[1]);
        }

        long[][] dp = new long[n + 1][maxInv + 1];

        dp[1][0] = 1;

        for (int len = 2; len <= n; len++) {

            for (int inv = 0; inv <= maxInv; inv++) {

                long ways = 0;

                for (int add = 0;
                     add <= Math.min(len - 1, inv);
                     add++) {

                    ways += dp[len - 1][inv - add];
                }

                dp[len][inv] = ways % MOD;
            }

            int idx = len - 1;

            if (req[idx] != -1) {

                for (int inv = 0; inv <= maxInv; inv++) {

                    if (inv != req[idx]) {
                        dp[len][inv] = 0;
                    }
                }
            }
        }

        long ans = 0;

        for (int inv = 0; inv <= maxInv; inv++) {
            ans = (ans + dp[n][inv]) % MOD;
        }

        return (int) ans;
    }
}