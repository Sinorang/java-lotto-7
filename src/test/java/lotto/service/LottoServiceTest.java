package lotto.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private static final String VALID_PURCHASE_AMOUNT = "5000";
    private static final int EXPECTED_LOTTO_COUNT = 5;
    private static final List<Integer> EXPECTED_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    private final LottoService lottoService = new LottoServiceImpl();

    @Test
    void 로또_구입_정상_금액_입력_시_로또_장수_반환_테스트() {
        int lottoCount = lottoService.calculateLottoCount(VALID_PURCHASE_AMOUNT);
        assertThat(lottoCount).isEqualTo(EXPECTED_LOTTO_COUNT);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6", " 1 , 2 , 3 , 4 , 5 , 6 "})
    void 당첨_번호_입력값_파싱_테스트(String winningNumbersInput) {
        List<Integer> parsedWinningNumbers = lottoService.parseWinningNumbers(winningNumbersInput);
        assertThat(parsedWinningNumbers).isEqualTo(EXPECTED_WINNING_NUMBERS);
    }
}
