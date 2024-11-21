package med.voll.api.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.Model.Endereco;

public record PacienteDTO(
		@NotBlank
		String nome,
		@NotBlank
		String email,
		@NotBlank
		String telefone,
		@NotBlank
		String cpf,
		@NotNull @Valid
		EnderecoDTO endereco) {
}
