package med.voll.api.controller;

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
import med.voll.api.medicos.AtualizarMedicos;
import med.voll.api.medicos.CadastroMedicos;
import med.voll.api.medicos.ListaMedicos;
import med.voll.api.medicos.Medico;
import med.voll.api.medicos.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid CadastroMedicos dados) {
		repository.save(new Medico(dados));
	}
	
	@GetMapping
	public List<ListaMedicos> listarMedicos() {
		return repository.findAllByAtivoTrue().stream().map(ListaMedicos::new).toList();
	}
	
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid AtualizarMedicos dados) {
		Medico medico = repository.getReferenceById(dados.id());
		medico.atualizarDados(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		Medico medico = repository.getReferenceById(id);
		medico.desativar();
	}
	
}