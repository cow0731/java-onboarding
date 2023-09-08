package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (checkStartToEndPage(pobi, crong) && checkContinuityPage(pobi, crong)) {
            int pobiScore = Math.max(findBigNumbers(pobi, 0), findBigNumbers(pobi, 1));
            int crongScore = Math.max(findBigNumbers(crong, 0), findBigNumbers(crong, 1));
            answer = compareScore(pobiScore, crongScore);
        }
        return answer;
    }

    // 펼친 책 페이지가 1~400 페이지 이내인지 확인
    private static boolean checkStartToEndPage(List<Integer> pobi, List<Integer> crong) {
        boolean[] boolArr = {false, false, false, false};
        List<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(pobi);
        mergedList.addAll(crong);

        for (int i = 0; i < mergedList.size(); i++) {
            if (mergedList.get(i) >= 1 && mergedList.get(i) <= 400) {
                boolArr[i] = true;
            }
        }
        return boolArr[0] && boolArr[1] && boolArr[2] && boolArr[3];
    }

    // 펼친 책 양쪽 페이지 값 차이가 1인지 확인
    private static boolean checkContinuityPage(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(1) - pobi.get(0) == 1 && crong.get(1) - crong.get(0) == 1;
    }

    // 펼친 페이지의 각 자리 숫자의 더하거나 곱한 수 중에 큰 수를 반환함
    private static int findBigNumbers(List<Integer> list, int direction) {
        int sum = 0;
        int mul = 1;
        int leftNum = list.get(direction);

        while(leftNum > 0) {
            sum += leftNum % 10;
            mul *= leftNum % 10;
            leftNum /= 10;
        }

        return Math.max(sum, mul);
    }

    // 점수를 비교하여 승자를 가림
    private static int compareScore(int pScore, int cScore) {
        if (pScore > cScore) {
            return 1;
        } else if (pScore < cScore) {
            return 2;
        } else {
            return 0;
        }
    }
}