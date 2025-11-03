package lotto.model;

import java.util.List;

public class Lottoes {

    private List<Lotto> lottoes = null;

    public Lottoes(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public int size() {
        return lottoes.size();
    }

    public List<int[]> score(List<Integer> winningNums, int bonusNum) {
        return lottoes.stream().map(l -> l.score(winningNums, bonusNum)).toList();
    }

    @Override
    public String toString() {
        return String.join("\n", lottoes.stream().map(Lotto::toString).toList());
    }
}
