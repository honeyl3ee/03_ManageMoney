package beforespring.managemoney.app.budget.service;

import beforespring.managemoney.app.budget.domain.Budget;
import beforespring.managemoney.web.api.budget.request.RecommendBudgetRequest;
import beforespring.managemoney.web.api.budget.request.SetMonthlyBudgetRequest;
import beforespring.managemoney.web.api.budget.response.RecommendBudgetResponse;

import java.util.List;

public interface BudgetService {

    /**
     * 지출 카테고리 목록을 반환
     * @return 지출 카테고리
     */
    public List<String> getExpenditureCategories();

    /**
     * 월별 예산을 저장
     * @param request 내역별 예산 설정 데이터
     */
    public void saveMonthlyBudget(SetMonthlyBudgetRequest request);

    /**
     * 내역별 예산을 추천
     * @param request
     * @return
     */
    public RecommendBudgetResponse recommendBudget(RecommendBudgetRequest request);


}
