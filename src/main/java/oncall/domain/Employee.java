package oncall.domain;

import static oncall.global.constant.ErrorMessage.INVALID_INPUT;

import oncall.domain.dto.EmployeeResponse;

public class Employee {

    private final String nickname;

    public Employee(final String nickname) {
        validateNickname(nickname);
        this.nickname = nickname;
    }

    public EmployeeResponse createResponse() {
        return new EmployeeResponse(
                nickname
        );
    }

    private void validateNickname(String nickname) {
        if (nickname.isBlank() || nickname.length() > 5) {
            throw new IllegalArgumentException(INVALID_INPUT.get());
        }
    }
}
