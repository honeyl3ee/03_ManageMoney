package beforespring.managemoney.web.api.expenditure.request;

import beforespring.managemoney.app.utils.ExpenseCategory;

import java.time.LocalDateTime;

public record CreateExpenditureRequest(Long id,
                                       Long memberId,
                                       ExpenseCategory expenseCategory,
                                       Long expenditureAmt,
                                       LocalDateTime expenditureDate
                                       ) {
}
