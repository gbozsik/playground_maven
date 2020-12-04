public class MyCodilty {

    public static int solution(int[] A) {
        int leftSum = A[0];
        int rightSum = 0;
        for (int x : A)
            rightSum += x;
        rightSum -= leftSum;

        int diff = Math.abs(leftSum - rightSum);
        for (int i = 1; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            int currentDiff = Math.abs(leftSum - rightSum);
            if (diff > currentDiff) diff = currentDiff;
        }
        return diff;
    }
}
