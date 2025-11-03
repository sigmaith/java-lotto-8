package lotto.controller;

import lotto.model.LottoIssuer;
import lotto.model.Lottoes;
import lotto.view.InputView;

public class LottoService {
    public void start() {
        while (true) {
            try {
                int money = InputView.getMoney();
                Lottoes v = LottoIssuer.issue(money);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
