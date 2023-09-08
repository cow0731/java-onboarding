package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        char[] charArr = cryptogram.toCharArray();
        for (int k = 0; k < charArr.length - 1; k++) {
            for (int i = 0; i < charArr.length - 1; i++) {
                char[] destArr = new char[charArr.length - 2];

                if (charArr[i] - '0' == charArr[i + 1] - '0') {
                    System.arraycopy(charArr, 0, destArr, 0, i);
                    System.arraycopy(charArr, i + 2, destArr, i, charArr.length - i - 2);

                    System.arraycopy(destArr, 0, charArr, 0, destArr.length);
                    String str = new String(charArr);
                    String result = str.substring(0, destArr.length);
                    charArr = result.toCharArray();

                    i = i - 1;

                    if (charArr.length == 2) {
                        charArr = new char[0];
                        answer = new String(charArr);
                        return answer;
                    }
                }
            }

        }
        answer = new String(charArr);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
        System.out.println(solution("zyelleyz"));
        System.out.println(solution("zdiidon"));
    }
}