package beforespring.managemoney.app.expenditure.service;

import beforespring.managemoney.app.expenditure.domain.Expenditure;
import beforespring.managemoney.web.api.expenditure.request.CreateExpenditureRequest;
import beforespring.managemoney.web.api.expenditure.request.FindExpenditureRequest;

public interface ExpenditureService {

    public void saveExpenditure(CreateExpenditureRequest request);

    public void updateExpenditure();

    public Expenditure findExpenditure(FindExpenditureRequest request);

    public void findExpenditureList();

    public void deleteExpenditure();

    public void excludeTotalExpenditure();

}
