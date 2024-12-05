package oncall.domain;

import java.util.List;
import oncall.global.validation.EmployeesValidator;

public class Weekdays {

    private final List<Employee> employees;
    private int turn;

    public Weekdays(List<Employee> employees) {
        EmployeesValidator.validateEmployees(employees);
        this.employees = employees;
    }


}
