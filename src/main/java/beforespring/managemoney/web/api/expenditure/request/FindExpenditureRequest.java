package beforespring.managemoney.web.api.expenditure.request;

public record FindExpenditureRequest(
    Long id,
    Long memberId
) {
}
