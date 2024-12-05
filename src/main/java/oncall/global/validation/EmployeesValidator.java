package oncall.global.validation;

import static oncall.global.constant.ErrorMessage.INVALID_INPUT;

import java.util.List;
import oncall.domain.Employee;

public class EmployeesValidator {

    public static void validateNoPairing(String inputWeekdays, String inputWeekend) {
        List<String> weekdays = List.of(inputWeekdays.split(","));
        List<String> weekend = List.of(inputWeekend.split(","));

        weekdays.stream()
                .filter(element -> !weekend.contains(element))
                .findFirst()
                .ifPresent(element -> {
                    throw new IllegalArgumentException(INVALID_INPUT.get());
                });
    }

    public static void validateEmployees(List<Employee> employees) {
        if (employees.size() < 5 || employees.size() > 35) {
            throw new IllegalArgumentException(INVALID_INPUT.get());
        }
    }
}
