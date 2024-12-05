package oncall.domain;

import java.util.List;
import oncall.global.validation.EmployeesValidator;

public class Weekend {

    private final List<Employee> employees;
    private int turn;

    public Weekend(List<Employee> employees) {
        EmployeesValidator.validateEmployees(employees);
        this.employees = employees;
        this.turn = -1;
    }

    public Employee getNextEmployee() {
        turn++;

        if (turn >= employees.size()) {
            turn = 0;
        }

        return employees.get(turn);
    }
}
