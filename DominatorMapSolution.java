import java.util.HashMap;
import java.util.Map;

public class DominatorMapSolution {
    public static void main(String[] args) {
        int[] arr = new int[]{3};
        int[] arr1 = new int[]{};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x = 0; x < A.length; x++) {
            if (map.containsKey(A[x])) {
                map.put(A[x], map.get(A[x]) + 1);
                if (map.get(A[x]) > (A.length / 2)) {
                    return x;
                }
            } else {
                map.put(A[x], 1);
                if (map.get(A[x]) > (A.length / 2)) {
                    return x;
                }
            }
        }
        return -1;
    }
}
