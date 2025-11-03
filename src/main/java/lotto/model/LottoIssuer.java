package lotto.model;

import static lotto.CustomException.PRICE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static Lottoes issue(int money) {
        validate(money);
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT)));
        }
        return new Lottoes(lottoes);
    }

    public static void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_UNIT.description());
        }
    }
}
