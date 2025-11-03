package lotto.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(n -> (n < 1 || n > 45))) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.naturalOrder());
        return numbers.toString();
    }
}
