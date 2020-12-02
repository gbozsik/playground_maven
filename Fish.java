import java.util.Stack;

public class Fish {
    public static void main(String[] args) {
        int[] fishSize = new int[] {1_000_000_000, 2};
        int[] direction = new int[] {0, 1};
        System.out.println(solution(fishSize, direction));

    }

    public static int solution(int[] A, int[] B) {
        int leftFishCount = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                stack.push(A[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < A[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    leftFishCount++;
                }
            }
        }
        return stack.size() + leftFishCount;
    }
}
