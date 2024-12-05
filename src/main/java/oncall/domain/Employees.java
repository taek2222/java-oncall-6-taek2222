package oncall.domain;

import java.util.List;
import oncall.global.validation.EmployeesValidator;

public class Employees {

    private final List<Employee> employees;
    private Employee pinchEmployee;

    private int turn;

    public Employees(List<Employee> employees) {
        EmployeesValidator.validateEmployees(employees);
        this.employees = employees;
        this.turn = -1;
    }

    public Employee getNextEmployee(Employee workedEmployee) {
        if (pinchEmployee != null) {
            Employee employee = pinchEmployee;
            pinchEmployee = null;
            return employee;
        }

        turn++;
        if (turn >= employees.size()) {
            turn = 0;
        }

        if (workedEmployee != null && workedEmployee.isSameNickname(employees.get(turn))) {
            pinchEmployee = employees.get(turn);

            turn++;
            if (turn >= employees.size()) {
                turn = 0;
            }
            return employees.get(turn);
        }

        return employees.get(turn);
    }
}
