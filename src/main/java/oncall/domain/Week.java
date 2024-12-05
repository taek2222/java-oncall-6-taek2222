package oncall.domain;

public class Week {

    private final Weekdays weekdays;
    private final Weekend weekend;

    public Week(Weekdays weekdays, Weekend weekend) {
        this.weekdays = weekdays;
        this.weekend = weekend;
    }
}
