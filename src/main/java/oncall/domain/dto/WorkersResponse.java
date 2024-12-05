package oncall.domain.dto;

import java.util.List;

public record WorkersResponse(
        List<WorkerResponse> workerResponses
) {
}
