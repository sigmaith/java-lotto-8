package lotto.controller;

import java.util.List;
import lotto.model.LottoIssuer;
import lotto.model.LottoMatcher;
import lotto.model.Lottoes;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    public void start() {
        Lottoes lottoes = issueLottoes();
        LottoMatcher lottoMatcher = new LottoMatcher();
        luckyDraw(lottoMatcher);
        OutputView.printLuckyDrawResult(lottoMatcher.match(lottoes));
    }

    private static void luckyDraw(LottoMatcher lottoMatcher) {
        while (true) {
            try {
                List<Integer> winningNums = InputView.getWinningNums();
                int bonusNum = InputView.getBonusNum();
                lottoMatcher.draw(winningNums, bonusNum);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lottoes issueLottoes() {
        while (true) {
            try {
                int money = InputView.getMoney();
                Lottoes lottoes = LottoIssuer.issue(money);
                OutputView.printLottoes(lottoes);
                return lottoes;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
