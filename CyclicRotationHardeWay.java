public class CyclicRotationHardeWay {
    public static void main(String[] args) {
//        int[] arr = new int[] {0, 5, -3, 1, -4}; 6, 7, 1, 2, 3, 4, 5
        int[] arr = new int[]{3, 4, 4, 6, 1, 4, 4};
//        int[] arr = new int[0];
        for (int x : solution(5, arr)) {
            System.out.println(x);
        }
    }

    public static int[] solution(int N, int[] A) {
        int[] arr = new int[N];

        int max = 0;
        int maxCounter = 0;
        for (int x : A) {
            if (x < 0) continue;
            if (x >= N) {
                maxCounter = max;
            } else {
                if (arr[x - 1] < maxCounter) {
                    arr[x - 1] = maxCounter;
                }
                arr[x - 1] = arr[x - 1] + 1;
                if (arr[x - 1] > max) {
                    max = arr[x - 1];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < maxCounter) {
                arr[i] = maxCounter;
            }
        }
        return arr;
    }
}//3, 2, 2, 4, 2
