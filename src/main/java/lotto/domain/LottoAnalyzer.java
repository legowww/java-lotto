package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {
    private final Map<LottoRank, Integer> lottoRankIntegerMap = new EnumMap<>(LottoRank.class);
    private final Lottos lottos;
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public LottoAnalyzer(Lottos lottos, Lotto winningLotto, Integer bonusNumber) {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> lottoRankIntegerMap.put(lottoRank, 0));
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void analyze() {
        System.out.println("분석");
        for (Lotto lotto : lottos.getLottos()) {
            int count = 0;
            count += calculateWinningCount(lotto);

            boolean bonus =  calculateBonusNumber(lotto);
            if (bonus) {
                count += 1;
            }


            LottoRank rank = LottoRank.findRanking(count, bonus);
            System.out.println("count = " + count + " lotto =" + lotto.toString() + " rank = " + rank);
            lottoRankIntegerMap.put(rank, lottoRankIntegerMap.get(rank)+1);
        }

        for (LottoRank lottoRank : lottoRankIntegerMap.keySet()) {
            System.out.println("lottoRank = " + lottoRank + "cnt" + lottoRankIntegerMap.get(lottoRank));
        }
    }

    private Integer calculateWinningCount(Lotto lotto) {
        int count = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : winningLotto.getNumbers()) {
            if (numbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean calculateBonusNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}