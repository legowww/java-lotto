package lotto.domain;


public class Money {
    private final Integer won;

    public Money(Integer won) {
        validate(won);
        this.won = won;
    }

    public Integer getWon() {
        return won;
    }

    private void validate(Integer won) {

    }
}
