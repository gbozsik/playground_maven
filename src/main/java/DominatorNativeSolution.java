public class DominatorNativeSolution {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 3, 2, 3, -1, 3, 3};
        int[] arr1 = new int[]{3};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        int leader = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (count == 0) {
                leader = A[i];
                count++;
            } else if (A[i] == leader) {
                count++;
            } else {
                count--;
            }
        }

        int occurences = 0;
        for (int x = 0; x < A.length; x++) {
            if (A[x] == leader) {
                occurences++;
            }
            if (occurences > A.length / 2) {
                return x;
            }
        }
        return -1;
    }
}
