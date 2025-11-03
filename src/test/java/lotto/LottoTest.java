package lotto;

import java.util.Arrays;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 원하는_형식으로_결과값을_반환한다() {
        List<Integer> arr = List.of(1, 2, 3, 4, 5, 6);
        assertThat(arr.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");

        Lotto lotto = new Lotto(Arrays.asList(3, 2, 1, 5, 4, 6));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
