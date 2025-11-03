package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoMatcher {

    private List<Integer> winningNums;
    private int bonusNum;
    private HashMap<Integer, Integer> scoreBoard;

    public LottoMatcher(List<Integer> winningNums, int bonusNum) {
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 당첨번호와 중복되지 않아야 합니다.");
        }
        this.winningNums = winningNums;
        this.bonusNum = bonusNum;
    }

    public String match(Lottoes lottoes) {
        score(lottoes);
        float returnRate = calculateIncomeRate(lottoes);
        return getScoreBoardResult(returnRate);
    }

    private void score(Lottoes lottoes) {
        for (int[] score : lottoes.score(winningNums, bonusNum)) {
            if (score[0] == 6) increase(7);
            if (score[0] == 5 && score[1] == 1) increase(6);
            if (score[0] == 5) increase(5);
            if (score[0] == 4) increase(4);
            if (score[0] == 3) increase(3);
        }
    }

    private float calculateIncomeRate(Lottoes lottoes) {
        float originMoney = lottoes.size() * 1000;
        float income = 0;
        income += scoreBoard.get(3) * 5_000;
        income += scoreBoard.get(4) * 50_000;
        income += scoreBoard.get(5) * 1_500_000;
        income += scoreBoard.get(6) * 30_000_000;
        income += scoreBoard.get(6) * 2_000_000_000;
        return income / originMoney * 100;
    }

    private void increase(int prize) {
        scoreBoard.put(prize, scoreBoard.getOrDefault(prize, 0) + 1);
    }

    public String getScoreBoardResult(float returnRate) {
        return "당첨 통계\n---" + String.format("3개 일치 (5,000원) - %d개", scoreBoard.get(3))
                + String.format("4개 일치 (50,000원) - %d개", scoreBoard.get(4))
                + String.format("5개 일치 (1,500,000원) - %d개", scoreBoard.get(5))
                + String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", scoreBoard.get(6))
                + String.format("6개 일치 (2,000,000,000원) - %d개", scoreBoard.get(7))
                + String.format("총 수익률은 %.2f입니다.", returnRate);
    }
}
