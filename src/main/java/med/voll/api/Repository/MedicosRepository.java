package med.voll.api.Repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import med.voll.api.Model.Medico;

public interface MedicosRepository extends JpaRepository<Medico, Long> {
	Collection<Medico> findAllByAtivoTrue();
}