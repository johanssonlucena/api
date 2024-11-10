package med.voll.api.medicos;

public record ListaMedicos(String nome, String email, String crm, Especialidades especialidade) {
	
	public ListaMedicos(Medico medico) {
		this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
