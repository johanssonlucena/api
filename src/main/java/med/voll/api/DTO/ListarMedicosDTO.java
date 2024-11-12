package med.voll.api.DTO;

import med.voll.api.Enum.Especialidades;
import med.voll.api.Model.Medico;

public record ListarMedicosDTO(String nome, String email, String crm, Especialidades especialidade) {
	
	public ListarMedicosDTO(Medico medico) {
		this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
	}
}
