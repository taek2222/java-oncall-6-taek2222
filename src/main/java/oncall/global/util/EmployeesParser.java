package oncall.global.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import oncall.domain.Employee;
import oncall.global.constant.ErrorMessage;

public class EmployeesParser {

    public static List<Employee> parseEmployees(String input) {
        String[] split = input.split(",");
        validateDuplicate(split);

        List<Employee> employees = new ArrayList<>();

        for (String s : split) {
            Employee employee = new Employee(s);
            employees.add(employee);
        }

        return employees;
    }

    private static void validateDuplicate(String[] input) {
        List<String> list = List.of(input);
        HashSet<String> hashSet = new HashSet<>(list);

        if (list.size() != hashSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.get());
        }
    }
}
