package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이어야 합니다.");
        }
    }

    public static List<Integer> getWinningNums() {
        System.out.println();
    }
}
