package lotto.controller;

import java.util.List;
import lotto.model.LottoIssuer;
import lotto.model.Lottoes;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    public void start() {
        while (true) {
            try {
                int money = InputView.getMoney();
                Lottoes lottoes = LottoIssuer.issue(money);
                OutputView.printLottoes(lottoes);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                List<Integer> winningNums = InputView.getWinningNums();
            }
        }
    }
}
