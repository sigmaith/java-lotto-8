package lotto.model;

import java.util.List;

public class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public int size() {
        return lottoes.size();
    }

    @Override
    public String toString() {
        return String.join("\n", lottoes.stream().map(Lotto::toString).toList());
    }
}
