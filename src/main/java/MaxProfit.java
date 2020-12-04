public class MaxProfit {

    public static void main(String[] args) {

        int[] arr = new int[]{23171, 21011, 21123, 21366, 21013, 21367};
        int[] arr1 = new int[]{};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int globalProfit = 0;
        int start = A[0];
        int profit;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > start) {
                profit = A[i] - start;
                if (profit > globalProfit) {
                    globalProfit = profit;
                }
            } else {
                start = A[i];
            }
        }
        return globalProfit;
    }
}
