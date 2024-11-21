package med.voll.api.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.DTO.AtualizarMedicoDTO;
import med.voll.api.DTO.ListarMedicosDTO;
import med.voll.api.DTO.MedicoDTO;
import med.voll.api.Model.Medico;
import med.voll.api.Repository.MedicosRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	private MedicosRepository repository;

	@PostMapping
	@Transactional
	public void cadastrarMedico(@RequestBody @Valid MedicoDTO medicoDTO) {				
		repository.save(new Medico(medicoDTO));
	}
	
	@GetMapping
	public List<ListarMedicosDTO> listarMedicos() {
		return repository.findAllByAtivoTrue().stream().map(ListarMedicosDTO::new).toList();
	}
	
	
	@PutMapping
	@Transactional
	public void atualizarMedico(@RequestBody @Valid AtualizarMedicoDTO atualizarMedicoDTO) {
		Medico medico = repository.getReferenceById(atualizarMedicoDTO.id());
		medico.atualizarDados(atualizarMedicoDTO);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		Medico medico = repository.getReferenceById(id);
		medico.desativarMedico();
	}
	
}