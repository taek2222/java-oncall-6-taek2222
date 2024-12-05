package oncall.controller;

import java.util.List;
import oncall.domain.Calender;
import oncall.domain.Employee;
import oncall.domain.Week;
import oncall.domain.Employees;
import oncall.domain.dto.WorkersResponse;
import oncall.global.util.CalenderParser;
import oncall.global.util.EmployeesParser;
import oncall.global.validation.EmployeesValidator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    private final InputView inputView;
    private final OutputView outputView;

    public OncallController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Calender calender = generateCalender();
        Week week = generateWeek(calender);

        WorkersResponse response = week.createResponse();
        outputView.printWorkers(response);
    }

    private Calender generateCalender() {
        while (true) {
            try {
                String input = inputView.readStartMonthAndDay();
                return CalenderParser.parseCalender(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Week generateWeek(Calender calender) {
        while (true) {
            try {
                String inputWeekDays = inputView.readWeekDaysEmployee();
                String inputWeekend = inputView.readWeekendEmployee();

                List<Employee> parsedWeekDays = EmployeesParser.parseEmployees(inputWeekDays);
                List<Employee> parsedWeekend = EmployeesParser.parseEmployees(inputWeekend);

                Employees weekdays = new Employees(parsedWeekDays);
                Employees weekend = new Employees(parsedWeekend);

                EmployeesValidator.validateNoPairing(inputWeekDays, inputWeekend);
                return new Week(weekdays, weekend, calender);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
