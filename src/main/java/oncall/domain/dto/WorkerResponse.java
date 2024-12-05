package oncall.domain.dto;

public record WorkerResponse(
        DateResponse dateResponse,
        EmployeeResponse employeeResponse
) {
}
