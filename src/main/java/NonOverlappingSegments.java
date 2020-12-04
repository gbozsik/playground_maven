public class NonOverlappingSegments {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 7, 9, 9};
        int[] arr1 = new int[] {5, 6, 8, 9, 10};
        int[] arr2 = new int[] {};
        int[] arr3 = new int[] {};
        System.out.print(solution(arr2, arr3));
    }

    public static int solution(int[] A, int[] B) {
//        if (A.length == 0 || B.length == 0) return 1;
        int lastEnd = -1;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (lastEnd < A[i]) {
                count++;
                lastEnd = B[i];
            }
        }
        return count;
    }
}
