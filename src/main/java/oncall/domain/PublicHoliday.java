package oncall.domain;

import java.time.LocalDate;
import java.util.Arrays;

public enum PublicHoliday {
    THEOCRACY(1, 1),
    MARCH_1ST(3, 1),
    CHILDREN(5, 5),
    MEMORIAL(6, 6),
    LIBERATION(8, 15),
    NATIONAL_FOUNDATION(10, 3),
    HANGUL(10, 9),
    CHRISTMAS(12, 25),
    ;

    private final int month;
    private final int day;

    PublicHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isPublicHoliday(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        return Arrays.stream(values())
                .filter(holiday -> holiday.month == month)
                .anyMatch(holiday -> holiday.day == day);
    }
}
