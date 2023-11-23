package beforespring.managemoney.web.api.budget.request;

import beforespring.managemoney.app.member.domain.Member;

public record SetMonthlyBudgetRequest(Long memberId,
                                      Long food,
                                      Long transportation,
                                      Long shopping,
                                      Long housing,
                                      Long savings,
                                      Long etc) {
}
