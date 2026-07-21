import java.util.Arrays;

public class LC899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String smallest = s;
            for (int i = 1; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(smallest) < 0) {
                    smallest = temp;
                }
            }
            return smallest;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
