package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoAnalyzer;
import lotto.util.LottoCreator;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.List;

import static lotto.view.InputView.*;


public class LottoGame {
    private static final Integer LOTTO_PRICE = 1_000;



    public void run() {
        Money money = getMoney();
        Lottos lottos = buyLottos(money);
        Lotto winningLotto = getWinningLotto();
        Integer bonusNumber = getBonusNumber();

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lottos, winningLotto, bonusNumber);
        lottoAnalyzer.analyze();
    }



    private Money getMoney() {
        Integer won = inputMoney();
        return new Money(won);
    }

    private Lottos buyLottos(Money money) {
        int lottoAmount = moneyCovertToLotto(money);

        printBuyAmount(lottoAmount);
        Lottos lottos = LottoCreator.autoCreate(lottoAmount);
        printLottos(lottos);
        return lottos;
    }

    private Lotto getWinningLotto() {
        List<Integer> numbers = inputWinningLottos();
        return LottoCreator.passiveCreate(numbers);
    }

    private Integer getBonusNumber() {
        return inputBonusNumber();
    }

    public Integer moneyCovertToLotto(Money money) {
        return money.getWon() / LOTTO_PRICE;
    }
}
