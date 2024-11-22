package med.voll.api.DTO;

import med.voll.api.Model.Paciente;

public record ListarPacientesDTO(String nome, String email, String cpf) {
	
	public ListarPacientesDTO(Paciente paciente) {
		this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
	}
}
