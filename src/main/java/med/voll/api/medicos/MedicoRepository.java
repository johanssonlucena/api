package med.voll.api.medicos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

	Collection<Medico> findAllByAtivoTrue();
}