package beforespring.managemoney.app.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmRepository extends JpaRepository<Confirm, Long> {
    Optional<Confirm> findByMember(Member member);
}
