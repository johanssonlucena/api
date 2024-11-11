package med.voll.api.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

public record AtualizarMedicos(
		@NotNull
		Long id, 
		String nome, 
		String telefone, 
		DadosEndereco endereco) {

}
