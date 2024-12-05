package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.dto.WorkerResponse;
import oncall.domain.dto.WorkersResponse;

public class Week {

    private final Weekdays weekdays;
    private final Weekend weekend;
    private final Calender calender;

    public Week(Weekdays weekdays, Weekend weekend, Calender calender) {
        this.weekdays = weekdays;
        this.weekend = weekend;
        this.calender = calender;
    }

    public WorkersResponse createResponse() {
        List<WorkerResponse> workerResponses = new ArrayList<>();

        while(true) {
            workerResponses.add(createWorkerResponse());
            if (calender.isLastDay())
                return new WorkersResponse(workerResponses);

            calender.increaseDay();
        }
    }

    private WorkerResponse createWorkerResponse() {
        return new WorkerResponse(
                calender.createResponse(),
                getOncallEmployee().createResponse()
        );
    }

    private Employee getOncallEmployee() {
        if (calender.isWeekend()) {
            return weekend.getNextEmployee();
        }
        return weekdays.getNextEmployee();
    }
}
