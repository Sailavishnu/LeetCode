import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC761 {
    public String makeLargestSpecial(String s) {
        int count = 0;
        int i = 0;
        List<String> tokens = new ArrayList<>();
        
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }
            
            if (count == 0) {
                String innerSorted = makeLargestSpecial(s.substring(i + 1, j));
                tokens.add("1" + innerSorted + "0");
                i = j + 1;
            }
        }
        
        Collections.sort(tokens, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String t : tokens) {
            sb.append(t);
        }
        return sb.toString();
    }
}
