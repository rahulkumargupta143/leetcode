public class Solution {
    public int reverseBits(int n) {
        int rev = 0;

        for (int i = 0; i < 32; i++) {
            rev = rev << 1;          // space banaya
            rev |= (n & 1);          // last bit copy ki
            n >>>= 1;                // unsigned right shift
        }

        return rev;
    }
}
