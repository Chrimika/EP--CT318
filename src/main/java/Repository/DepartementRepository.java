package repository;

import com.example.demo.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DepartementRepository extends JpaRepository<Departement, UUID> {
    boolean existsByNomDepartement(String nomDepartement);
}