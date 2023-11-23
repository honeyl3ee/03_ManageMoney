package beforespring.managemoney.app.budget.domain;

import beforespring.managemoney.app.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

@Table(name = "budget",
    indexes = {
        @Index(
            name = "idx__budget__member_id__created_at",
            columnList = "member_id, created_at")
    })
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Budget {
    @Id
    @GeneratedValue
    @Column(name = "budget_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    @Column(nullable = false)
    private Long food;
    @Column(nullable = false)
    private Long transportation;
    @Column(nullable = false)
    private Long shopping;
    @Column(nullable = false)
    private Long housing;
    @Column(nullable = false)
    private Long savings;
    @Column(nullable = false)
    private Long etc;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;

    @Builder
    public Budget(Member member,
                  Long food,
                  Long transportation,
                  Long shopping,
                  Long housing,
                  Long savings,
                  Long etc) {
        this.member = member;
        this.food = food;
        this.transportation = transportation;
        this.shopping = shopping;
        this.housing = housing;
        this.savings = savings;
        this.etc = etc;
    }
}
