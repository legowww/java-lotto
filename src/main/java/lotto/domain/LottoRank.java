package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST(2_000_000_000, (count, bonus) -> count == 6),
    SECOND(30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(50_000, (count, bonus) -> count == 4),
    FIFTH(5_000, (count, bonus) -> count == 3),
    NONE(0, (count, bonus) -> count < 3);

    private final int prize;
    private final BiPredicate<Integer, Boolean> condition;

    LottoRank(int prize, BiPredicate<Integer, Boolean> condition) {
        this.prize = prize;
        this.condition = condition;
    }

    public static LottoRank findRanking(int cnt, boolean hasBonusNumber) {
        return Arrays.stream(LottoRank.values())
                .filter(ranking -> ranking.condition.test(cnt, hasBonusNumber))
                .findAny()
                .orElse(NONE);
    }
}
