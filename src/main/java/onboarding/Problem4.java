package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        String[] answer = new String[word.length()];

        String bigChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChar = "abcdefghijklmnopqrstuvwxyz";

        String[] w = word.split("");
        String[] b = bigChar.split("");
        String[] s = smallChar.split("");

        for (int i = 0; i < w.length; i++) {
            if (w[i].equals(" ")) {
                answer[i] = " ";
            } else if (Character.isUpperCase(w[i].charAt(0))) {
                answer[i] = b[26 - bigChar.indexOf(w[i]) - 1];
            } else if (Character.isLowerCase(w[i].charAt(0))) {
                answer[i] = s[26 - smallChar.indexOf(w[i]) - 1];
            }
        }
        return String.join("", answer);
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
}
