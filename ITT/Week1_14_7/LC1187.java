import java.util.*;

public class LC1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // Sort and remove duplicates from arr2
        TreeSet<Integer> set = new TreeSet<>();
        for (int val : arr2) {
            set.add(val);
        }
        int[] uniqueArr2 = new int[set.size()];
        int idx = 0;
        for (int val : set) {
            uniqueArr2[idx++] = val;
        }

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(-1, 0);

        for (int num : arr1) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int last = entry.getKey();
                int ops = entry.getValue();

                // Option 1: Keep num if it's strictly greater than last
                if (num > last) {
                    newDp.put(num, Math.min(newDp.getOrDefault(num, Integer.MAX_VALUE), ops));
                }

                // Option 2: Replace num with the smallest element in uniqueArr2 > last
                int replIdx = upperBound(uniqueArr2, last);
                if (replIdx < uniqueArr2.length) {
                    int replaced = uniqueArr2[replIdx];
                    newDp.put(replaced, Math.min(newDp.getOrDefault(replaced, Integer.MAX_VALUE), ops + 1));
                }
            }

            if (newDp.isEmpty()) {
                return -1;
            }
            dp = newDp;
        }

        int minOps = Integer.MAX_VALUE;
        for (int ops : dp.values()) {
            minOps = Math.min(minOps, ops);
        }
        return minOps;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
