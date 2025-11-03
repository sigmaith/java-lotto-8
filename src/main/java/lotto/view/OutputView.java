package lotto.view;

import lotto.model.Lottoes;

public class OutputView {
    public static void printLottoes(Lottoes lottoes) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoes.size()));
        System.out.println(lottoes.toString());
        System.out.println();
    }

    public static void printLuckyDrawResult(String result) {
        System.out.println(result);
    }
}
