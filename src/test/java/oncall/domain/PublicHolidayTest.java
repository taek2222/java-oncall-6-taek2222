package oncall.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class PublicHolidayTest {

    @Test
    void 날짜가_법정공휴일이_맞으면_TRUE를_반환한다() {
        // given
        LocalDate date = LocalDate.of(2023, 5, 5);

        // when
        boolean result = PublicHoliday.isPublicHoliday(date);

        // then
        assertThat(result)
                .isTrue();
    }

    @Test
    void 날짜가_법정공휴일이_아니면_FALSE를_반환한다() {
        // given
        LocalDate date = LocalDate.of(2023, 5, 6);

        // when
        boolean result = PublicHoliday.isPublicHoliday(date);

        // then
        assertThat(result)
                .isFalse();
    }
}