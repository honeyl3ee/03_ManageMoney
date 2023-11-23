package beforespring.managemoney.app.expenditure.domain;

import beforespring.managemoney.app.member.domain.Member;
import beforespring.managemoney.app.utils.ExpenseCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "expenditure",
    indexes = {
        @Index(
            name = "idx__expenditure__member_id__expense_category__expenditure_date",
            columnList = "member_id, expense_category, expenditure_date")
    })
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expenditure_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    @Enumerated(EnumType.STRING)
    @Column(name = "expense_category", nullable = false)
    private ExpenseCategory expenseCategory;
    @Column(nullable = false)
    private Long expenditureAmt;
    @Column(name = "expenditure_date",nullable = false)
    private LocalDateTime expenditureDate;
    private boolean deleted;
    private boolean excludedTotal;

    @Builder
    public Expenditure(Member member,
                       ExpenseCategory expenseCategory,
                       Long expenditureAmt,
                       LocalDateTime expenditureDate) {
        this.member = member;
        this.expenseCategory = expenseCategory;
        this.expenditureAmt = expenditureAmt;
        this.expenditureDate = expenditureDate;
        deleted = false;
        excludedTotal = false;

    }
}
