package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
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
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] splits = Console.readLine().split(",");
        try {
            return Arrays.stream(splits).map(i -> Integer.parseInt(i.strip())).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이어야 합니다.");
        }
    }

    public static int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine().strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이어야 합니다.");
        }
    }
}
