package topy.project.modules.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByUsername(String username);

    Optional<Member> findByUsername(String username);

    Optional<Member> findByContact(String contact);

    Optional<Member> findByUsernameAndContact(String username, String contact);

    boolean existsByContact(String contact);
}
