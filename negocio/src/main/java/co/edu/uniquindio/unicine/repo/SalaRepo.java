package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface SalaRepo extends JpaRepository<Sala, CriteriaBuilder.In> {
}
