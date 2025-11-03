package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.LottoIssuer;
import org.junit.jupiter.api.Test;

public class LottoIssuerTest {

    @Test
    void 구입금액이_1000원_단위가_아닐시_예외가_발생한다() {
        assertThatThrownBy(() -> LottoIssuer.issue(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
