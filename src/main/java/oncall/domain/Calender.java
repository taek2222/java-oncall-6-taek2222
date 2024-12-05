package oncall.domain;

import static java.time.format.TextStyle.SHORT;
import static java.util.Locale.KOREA;

import java.time.LocalDate;
import oncall.domain.dto.DateResponse;

public class Calender {

    private LocalDate date;

    public Calender(LocalDate date) {
        this.date = date;
    }

    public boolean isWeekend() {
        String week = date.getDayOfWeek().getDisplayName(SHORT, KOREA);
        return week.equals("토") || week.equals("일");
    }

    public DateResponse createResponse() {
        return new DateResponse(
                date.getMonthValue(),
                date.getDayOfMonth(),
                date.getDayOfWeek().getDisplayName(SHORT, KOREA)
        );
    }

    public boolean isLastDay() {
        return date.getDayOfMonth() == date.lengthOfMonth();
    }

    public void increaseDay() {
        date = date.plusDays(1);
    }
}
