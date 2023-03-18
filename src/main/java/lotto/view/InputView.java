package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String OUTPUT_BUY_AMOUNT = "개를 구매했습니다.";
    private static final String INPUT_MONEY = "구매 금액을 입력해주세요.";
    private static final String INPUT_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static String input() {
        return Console.readLine();
    }

    public static void printBuyAmount(int amount) {
        System.out.println(amount + OUTPUT_BUY_AMOUNT);
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }


    public static Integer inputMoney() {
        System.out.println(INPUT_MONEY);
        String input = input();
        System.out.println();
        return Integer.parseInt(input);
    }

    public static Integer inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = input();
        System.out.println();

        return Integer.parseInt(input);
    }

    public static List<Integer> inputWinningLottos() {
        System.out.println(INPUT_WINNING_LOTTO);
        String input = input();
        System.out.println();

        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
