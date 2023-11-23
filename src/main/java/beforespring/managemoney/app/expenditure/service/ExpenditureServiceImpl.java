package beforespring.managemoney.app.expenditure.service;

import beforespring.managemoney.app.exception.ExpenditureNotFoundException;
import beforespring.managemoney.app.exception.MemberNotFoundException;
import beforespring.managemoney.app.expenditure.domain.Expenditure;
import beforespring.managemoney.app.expenditure.domain.ExpenditureRepository;
import beforespring.managemoney.app.member.domain.Member;
import beforespring.managemoney.app.member.domain.MemberRepository;
import beforespring.managemoney.web.api.expenditure.request.CreateExpenditureRequest;
import beforespring.managemoney.web.api.expenditure.request.FindExpenditureRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenditureServiceImpl implements ExpenditureService {

    private final ExpenditureRepository expenditureRepository;
    private final MemberRepository memberRepository;

    @Override
    public void saveExpenditure(CreateExpenditureRequest request) {
        Member member = memberRepository.findById(request.memberId()).orElseThrow(MemberNotFoundException::new);
        Expenditure expenditure = Expenditure.builder()
                                      .member(member)
                                      .expenseCategory(request.expenseCategory())
                                      .expenditureAmt(request.expenditureAmt())
                                      .expenditureDate(request.expenditureDate())
                                      .build();
        expenditureRepository.save(expenditure);
    }

    @Override
    public void updateExpenditure() {

    }

    @Override
    public Expenditure findExpenditure(FindExpenditureRequest request) {
       return expenditureRepository.findById(request.id()).orElseThrow(ExpenditureNotFoundException::new);
    }

    @Override
    public void findExpenditureList() {

    }

    @Override
    public void deleteExpenditure() {

    }

    @Override
    public void excludeTotalExpenditure() {

    }
}
