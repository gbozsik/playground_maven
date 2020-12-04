import java.util.Arrays;

public class DiscInsertionLogging {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 2, 1, 4, 0};
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{1, 0, 1, 0, 1};
        int[] arr3 = new int[]{1, 2147483647, 0};

        System.out.println(solution(arr1));
    }

    private static int solution(int[] A) {
        int flagsLength = A.length * 2;
        Flag[] flags = new Flag[flagsLength];
        int flagIndex = 0;
        for (int i = 0; i < A.length; i++) {
            long radius = A[i];
            flags[flagIndex++] = new Flag(i - radius, 1);
            flags[flagIndex++] = new Flag(i + radius, -1);
        }
        Arrays.sort(flags);
        int intersect = 0;
        int overlapping = -1;
        for (Flag flag : flags) {
            if (flag.flag == 1) {
                overlapping++;
                intersect += overlapping;
            } else {
                overlapping--;
            }
        }
        return intersect <= 10_000_000 ? intersect : -1;
    }

    private static class Flag implements Comparable<Flag> {
        long index;
        int flag;

        public Flag(long index, int flag) {
            this.index = index;
            this.flag = flag;
        }

        @Override
        public int compareTo(Flag flag) {
            if (this.index == flag.index) {
                return Integer.compare(flag.flag, this.flag);
            }
            return Long.compare(this.index, flag.index);
        }
    }
}
