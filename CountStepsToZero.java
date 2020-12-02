import java.util.List;

public class CountStepsToZero {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            stringBuilder.append("1");
        }
        String input = stringBuilder.toString();
//        System.out.println(solution("0"));
//        System.out.println(solution("011100"));
        System.out.println(solution(input));
    }

    static int solution(String a) {
        char[] charArr = a.toCharArray();
        int firstOneIndex = getFirstOneIndex(charArr);
        if(firstOneIndex == -1) {
            return 0;
        }
        int currentBit = charArr.length - 1;
        int steps = 0;
        return divideNumber(firstOneIndex, currentBit, charArr, steps);
    }

    private static int divideNumber(int firstOneIndex, int currentBit, char[] charArr, Integer steps) {
        if (currentBit == firstOneIndex && charArr[firstOneIndex] == '0') {
            return steps;
        }
        steps++;
        if (charArr[currentBit] == '1') {
            charArr[currentBit] = '0';
            return divideNumber(firstOneIndex, currentBit, charArr, steps);
        } else {
            currentBit--;
            return divideNumber(firstOneIndex, currentBit, charArr, steps);
        }
    }

    static int getFirstOneIndex(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                return i;
            }
        }
        return -1;
    }
}
