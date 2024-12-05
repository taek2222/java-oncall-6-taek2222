package oncall.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String readStartMonthAndDay() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return readLine();
    }

    public String readWeekDaysEmployee() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return readLine();
    }

    public String readWeekendEmployee() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return readLine();
    }
}
