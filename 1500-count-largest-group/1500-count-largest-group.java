class Solution {
    // Helper: compute the sum of digits of n
    private int digitSum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
    public int countLargestGroup(int n) {
        // count vector will store index as sum and its count in vector
        int[] count = new int[37]; // We know max possible digit-sum for n ≤ 10^5 is 45, but 37 covers up to n=10^4 safely.

        // 1) Group numbers 1..n by their digit-sum
        for (int i = 1; i <= n; i++) 
            count[digitSum(i)]++;

        // Find the size of the largest group
        int maxi = 0;
        for (int c : count)
            maxi = Math.max(maxi, c);

        // Count how many groups achieve that size
        int grpsCount = 0;
        for (int cnt : count)
            if (cnt == maxi)
                grpsCount++;

        return grpsCount;
    }
}