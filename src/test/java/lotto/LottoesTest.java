package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottoes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoesTest {

    @Test
    void 발행된_로또개수를_반환한다() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
        Lottoes lottoes = new Lottoes(lottoList);
        Assertions.assertEquals(2, lottoes.size());
    }

    @Test
    void 원하는_형식으로_결과값을_반환한다() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
        Lottoes lottoes = new Lottoes(lottoList);

        StringBuilder sb = new StringBuilder();
        sb.append("[1, 2, 3, 4, 5, 6]\n");
        sb.append("[2, 3, 4, 5, 6, 7]");
        Assertions.assertEquals(sb.toString(), lottoes.toString());
    }
}
