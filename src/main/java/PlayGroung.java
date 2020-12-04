public class PlayGroung {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 6};
        int num = 6;
        System.out.println(searchInSorted(arr, arr.length, num));
    }

    static int searchInSorted(int arr[], int N, int K) {
//        int mid = (N - 1) / 2;
        int mid = 0;
        int left = 0;
        int right = N - 1;
        while (K != mid) {
            mid = (right + left + 1) / 2;
            if (mid < 0 || mid >= N) {
                return -1;
            }
            if (K == arr[mid]) {
                return 1;
            }

            if (K < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (mid == 0 || mid == N - 1) {
                return -1;
            }
        }
        return -1;
    }
}
