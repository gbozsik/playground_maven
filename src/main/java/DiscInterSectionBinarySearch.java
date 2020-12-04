import java.util.Arrays;

public class DiscInterSectionBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 1, 4, 0};
        int[] arr1 = new int[]{};
        int[] arr2 = new int[]{1, 0, 1, 0, 1};
        int[] arr3 = new int[]{1, 2147483647, 0};
        System.out.println(solution(arr3));
    }

    public static int solution(int[] A) {

        Disc[] discs = new Disc[A.length];
        for (int i = 0; i < A.length; i++) {
            long radius = A[i];
            discs[i] = new Disc(i - radius, i + radius);
        }
        Arrays.sort(discs);
        int intersect = 0;
        for (int i = 0; i < A.length; i++) {
            long end = discs[i].getEnd();
            int firstNotIntersectIndex = searchFirstNotIntersect(discs, i, A.length - 1, end);
            intersect += firstNotIntersectIndex - i;
        }
        return intersect <= 10_000_000 ? intersect : -1;
    }

    static int searchFirstNotIntersect(Disc[] arr, int left, int right, long end) {
        int mid = (left + right) / 2;

        while (left <= right) {
            if (end == arr[mid].getStart()) {
                left = mid + 1;
            } else if (end < arr[mid].getStart()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            mid = (right + left) / 2;
            if (left > right) {
                return mid;
            }
        }
        return arr.length - 1;
    }

    private static class Disc implements Comparable<Disc> {
        Disc(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }

        private long start;
        private long end;

        @Override
        public int compareTo(Disc disc) {
            return Long.compare(start, disc.getStart());
        }
    }
}

