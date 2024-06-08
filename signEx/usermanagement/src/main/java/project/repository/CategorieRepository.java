package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.models.CategorieEntity;

public interface CategorieRepository extends JpaRepository<CategorieEntity,Long> {
}
