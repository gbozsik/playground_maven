public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 1, 1, 3};
        int[] arr1 = new int[]{2, 1, 4, 1};
        int[] arr2 = new int[]{2};
        int[] arr3 = new int[]{};
        System.out.print(solution(4, arr1));
    }

    public static int solution(int K, int[] A) {
        int count = 0;
        int ropeSum = 0;
        for (int x : A) {
            if (ropeSum >= K) {
                count++;
                ropeSum = 0;
            }
            ropeSum += x;
        }
        if (ropeSum >= K) {
            count++;
        }
        return count;
    }
}
