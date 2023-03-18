package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer PICK_NUMBER = 6;

    public static Lottos autoCreate(int amount)  {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, PICK_NUMBER);
            Collections.sort(lottoNumbers);
            lottoList.add(new Lotto(lottoNumbers));
        }
        return new Lottos(lottoList);
    }

    public static Lotto passiveCreate(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
