package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.dto.WorkerResponse;
import oncall.domain.dto.WorkersResponse;

public class Week {

    private final Employees weekdays;
    private final Employees weekend;
    private final Calender calender;
    private Employee workedEmployee;

    public Week(Employees weekdays, Employees weekend, Calender calender) {
        this.weekdays = weekdays;
        this.weekend = weekend;
        this.calender = calender;
    }

    public WorkersResponse createResponse() {
        List<WorkerResponse> workerResponses = new ArrayList<>();

        while (true) {
            workerResponses.add(createWorkerResponse());
            if (calender.isLastDay()) {
                return new WorkersResponse(workerResponses);
            }

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
            if (calender.isWeekend() || calender.isHoliday()) {
            workedEmployee = weekend.getNextEmployee(workedEmployee);
        }

        if (!calender.isWeekend() && !calender.isHoliday()) {
            workedEmployee = weekdays.getNextEmployee(workedEmployee);
        }

        return workedEmployee;
    }
}
