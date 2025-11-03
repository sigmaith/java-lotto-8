package lotto.model;

import static lotto.CustomException.DUPLICATE_NUMBER;
import static lotto.CustomException.NUMBER_COUNT;
import static lotto.CustomException.NUMBER_RANGE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int MATCH_COUNT_INDEX = 0;
    private static final int BONUS_MATCH_INDEX = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT.description());
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.description());
        }
        if (numbers.stream().anyMatch(n -> (n < LOTTO_MIN_NUMBER || n > LOTTO_MAX_NUMBER))) {
            throw new IllegalArgumentException(NUMBER_RANGE.description());
        }
    }

    public int[] score(List<Integer> winningNums, int bonusNum) {
        int[] score = new int[]{0, 0};
        for (int num : winningNums) {
            if (numbers.contains(num)) score[MATCH_COUNT_INDEX]++;
        }
        if (numbers.contains(bonusNum)) score[BONUS_MATCH_INDEX] = 1;
        return score;
    }

    @Override
    public String toString() {
        numbers.sort(Comparator.naturalOrder());
        return numbers.toString();
    }
}
