package fr.sle.testhowto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author slemoine
 */
@Repository
public interface MyEntityJpaRepository extends JpaRepository<MyEntity, Long> {
}
