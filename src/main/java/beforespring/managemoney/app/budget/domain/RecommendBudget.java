package beforespring.managemoney.app.budget.domain;

import beforespring.managemoney.web.api.budget.response.RecommendBudgetResponse;

import java.util.List;

public interface RecommendBudget {
    public RecommendBudgetResponse recommendBudget(List<Budget> budgets, Long totalBudget);

    public RecommendBudgetResponse setRecommendBudget(Long totalBudget, List<Long> avgBudgetRate);

    }
