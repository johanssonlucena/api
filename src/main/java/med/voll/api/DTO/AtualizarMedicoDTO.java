package med.voll.api.DTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarMedicoDTO(
		@NotNull
		Long id, 
		String nome, 
		String telefone, 
		EnderecoDTO enderecoDTO) {
}
