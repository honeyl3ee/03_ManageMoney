package beforespring.managemoney.app.budget.service;

import beforespring.managemoney.app.budget.domain.Budget;
import beforespring.managemoney.app.budget.domain.BudgetRepository;
import beforespring.managemoney.app.budget.domain.RecommendBudgetImpl;
import beforespring.managemoney.app.exception.MemberNotFoundException;
import beforespring.managemoney.app.member.domain.Member;
import beforespring.managemoney.app.member.domain.MemberRepository;
import beforespring.managemoney.app.utils.ExpenseCategory;
import beforespring.managemoney.web.api.budget.request.RecommendBudgetRequest;
import beforespring.managemoney.web.api.budget.request.SetMonthlyBudgetRequest;
import beforespring.managemoney.web.api.budget.response.RecommendBudgetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService{

    private final BudgetRepository budgetRepository;
    private final MemberRepository memberRepository;
    @Override
    public List<String> getExpenditureCategories() {
        return Arrays.stream(ExpenseCategory.values()).map(Enum::name).toList();
    }

    @Override
    @Transactional
    public void saveMonthlyBudget(SetMonthlyBudgetRequest request) {
        Member member = memberRepository.findById(request.memberId()).orElseThrow(MemberNotFoundException::new);
        Budget budget = Budget.builder()
                            .member(member)
                            .food(request.food())
                            .transportation(request.transportation())
                            .shopping(request.shopping())
                            .housing(request.housing())
                            .savings(request.savings())
                            .etc(request.etc())
                            .build();
        budgetRepository.save(budget);
    }

    @Override
    public RecommendBudgetResponse recommendBudget(RecommendBudgetRequest request) {
        List<Budget> budgets = budgetRepository.findAll();
        RecommendBudgetImpl recommendBudget = new RecommendBudgetImpl();
        return recommendBudget.recommendBudget(budgets, request.totalBudget());
    }
}
