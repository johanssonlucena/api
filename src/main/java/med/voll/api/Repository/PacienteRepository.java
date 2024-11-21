package med.voll.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.Model.Medico;
import med.voll.api.Model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
