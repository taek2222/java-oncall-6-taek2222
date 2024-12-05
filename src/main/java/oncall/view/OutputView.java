package oncall.view;

import java.util.List;
import oncall.domain.dto.WorkerResponse;
import oncall.domain.dto.WorkersResponse;

public class OutputView {

    public void printWorkers(WorkersResponse workersResponse) {
        List<WorkerResponse> workerResponses = workersResponse.workerResponses();
        workerResponses.forEach(this::printWorker);
    }

    private void printWorker(WorkerResponse workerResponse) {
        System.out.printf("%d월 %d일 %s %s",
                workerResponse.dateResponse().month(),
                workerResponse.dateResponse().day(),
                workerResponse.dateResponse().dayOfTheWeek(),
                workerResponse.employeeResponse().nickname());

        System.out.println();
    }
}
