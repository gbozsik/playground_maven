public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 6, 9, 12};
        int num = 9;
        System.out.println(searchInSorted(arr, arr.length, num));
    }

    static int searchInSorted(int arr[], int N, int K) {
        int mid = (N) / 2;;
        int left = 0;
        int right = N - 1;

        while (left <= right) {


            if (K == arr[mid]) {
                return 1;
            } else if (K < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = (right + left) / 2;
            if (left > right) {
                return -1;
            }
        }
        return -1;
    }
}
