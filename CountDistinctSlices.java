public class CountDistinctSlices {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 4, 5, 5, 2};
        int[] arr1 = new int[] {5, 4, 3, 5, 4};
        int[] arr2 = new int[] {4, 3, 5, 2, 5};
        System.out.print(solution(6, arr));
    }

    public static int solution(int M, int[] A) {

        boolean[] arr = new boolean[M + 1];
        int head = 0;
        int tail = 0;
        int length = A.length;
        long count = 0;
        while (head < length) {
            if (head < length && !arr[A[head]]) {
                int subLength = head - tail + 1;
                count += subLength;
                arr[A[head]] = true;
                head++;
            } else {
                long elementToRemove = A[head];
                boolean removed = false;
                while (!removed) {
                    arr[A[tail]] = false;
                    if (A[tail] == elementToRemove) {
                        removed = true;
                    }
                    tail++;
                }
            }
        }
        return (int) count;
    }
}
