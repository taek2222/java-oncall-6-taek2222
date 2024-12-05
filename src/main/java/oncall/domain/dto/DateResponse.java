package oncall.domain.dto;

public record DateResponse(
        int month,
        int day,
        String dayOfTheWeek
) {
}
