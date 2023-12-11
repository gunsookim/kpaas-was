package site.kormunity.kpaaswas.repository;

import site.kormunity.kpaaswas.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    // 필요한 JPA 메소드를 정의
}
