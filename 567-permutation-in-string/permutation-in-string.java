import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        char[] a = s1.toCharArray();
        Arrays.sort(a);
        String sortedS1 = new String(a);

        for(int i = 0; i <= s2.length() - s1.length(); i++) {

            String sub = s2.substring(i, i + s1.length());
            char[] b = sub.toCharArray();
            Arrays.sort(b);

            if(sortedS1.equals(new String(b))) {
                return true;
            }
        }

        return false;
    }
}