package beforespring.managemoney.web.api.budget.response;

public record RecommendBudgetResponse(Long food,
                                      Long transportation,
                                      Long shopping,
                                      Long housing,
                                      Long savings,
                                      Long etc) {

}
