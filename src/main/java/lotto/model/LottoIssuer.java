package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    public static Lottoes issue(int money) {
        validate(money);
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return new Lottoes(lottoes);
    }

    public static void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
    }
}
