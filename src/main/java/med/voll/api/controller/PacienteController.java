package med.voll.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.DTO.PacienteDTO;
import med.voll.api.Model.Paciente;
import med.voll.api.Repository.PacienteRepository;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	@Transactional 
	public void cadastrarPaciente(@RequestBody @Valid PacienteDTO pacienteDTO) {
		repository.save(new Paciente(pacienteDTO));
	}
}
