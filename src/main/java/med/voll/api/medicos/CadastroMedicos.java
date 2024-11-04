package med.voll.api.medicos;

import med.voll.api.endereco.DadosEndereco;

public record CadastroMedicos(String nome, String email, String crm, Especialidades especialidade, DadosEndereco endereco) {

}
