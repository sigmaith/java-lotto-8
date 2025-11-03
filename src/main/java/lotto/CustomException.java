package lotto;

public enum CustomException {

    NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복 되지 않아야 합니다."),
    NUMBER_RANGE("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    PRICE_UNIT("[ERROR] 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다."),
    DUPLICATE_WINNING_BONUS_NUMBER("[ERROR] 보너스번호는 당첨번호와 중복되지 않아야 합니다."),
    NUMBER_FORMAT("[ERROR] 숫자 형식이어야 합니다."),
    ;

    private String description;

    CustomException(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
