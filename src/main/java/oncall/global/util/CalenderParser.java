package oncall.global.util;

import static java.time.format.TextStyle.SHORT;
import static java.util.Locale.KOREA;
import static oncall.global.constant.ErrorMessage.INVALID_INPUT;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oncall.domain.Calender;

public class CalenderParser {

    public static Calender parseCalender(String input) {
        Pattern compile = Pattern.compile("^(\\d+),([가-힣]*)$");
        Matcher matcher = compile.matcher(input);
        validateMatcher(matcher);

        int month = Integer.parseInt(matcher.group(1));
        String dayOfTheWeek = matcher.group(2);

        validateMonth(month);
        LocalDate localDate = parseDate(month, dayOfTheWeek);
        return new Calender(localDate);
    }

    private static void validateMatcher(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_INPUT.get());
        }
    }

    private static void validateMonth(int month) {
        if (month < 1 || 12 < month) {
            throw new IllegalArgumentException(INVALID_INPUT.get());
        }
    }

    private static LocalDate parseDate(int month, String dayOfTheWeek) {
        int minYear = 2000;
        int maxYear = 2100;

        for (int year = minYear; year < maxYear; year++) {
            LocalDate localDate = LocalDate.of(year, month, 1);
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            String displayName = dayOfWeek.getDisplayName(SHORT, KOREA);

            if (displayName.equals(dayOfTheWeek)) {
                return localDate;
            }
        }

        throw new IllegalArgumentException(INVALID_INPUT.get());
    }
}
