package med.voll.api.DTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarPacienteDTO(
		@NotNull
		long id,
		String nome,
		String telefone,
		EnderecoDTO endereco
		) {

}
