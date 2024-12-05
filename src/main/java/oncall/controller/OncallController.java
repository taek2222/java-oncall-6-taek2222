package oncall.controller;

import java.util.List;
import oncall.domain.Calender;
import oncall.domain.Employee;
import oncall.domain.Week;
import oncall.domain.Weekdays;
import oncall.domain.Weekend;
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
        String input = inputView.readStartMonthAndDay();
        return CalenderParser.parseCalender(input);
    }

    private Week generateWeek(Calender calender) {
        String inputWeekDays = inputView.readWeekDaysEmployee();
        String inputWeekend = inputView.readWeekendEmployee();

        List<Employee> parsedWeekDays = EmployeesParser.parseEmployees(inputWeekDays);
        List<Employee> parsedWeekend = EmployeesParser.parseEmployees(inputWeekend);

        Weekdays weekdays = new Weekdays(parsedWeekDays);
        Weekend weekend = new Weekend(parsedWeekend);

        EmployeesValidator.validateNoPairing(inputWeekDays, inputWeekend);
        return new Week(weekdays, weekend, calender);
    }
}
