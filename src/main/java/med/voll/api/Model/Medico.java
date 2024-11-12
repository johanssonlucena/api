package med.voll.api.Model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.DTO.AtualizarMedicoDTO;
import med.voll.api.DTO.MedicoDTO;
import med.voll.api.Enum.Especialidades;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	@Enumerated(EnumType.STRING)
	private Especialidades especialidade;
	@Embedded
	private Endereco endereco;
	private boolean ativo;
	
	public Medico(MedicoDTO medicoDTO) {
		this.ativo = true;
		this.nome = medicoDTO.nome();
		this.email = medicoDTO.email();
		this.telefone = medicoDTO.telefone();
		this.crm = medicoDTO.crm();
		this.especialidade = medicoDTO.especialidade();
		this.endereco = new Endereco(medicoDTO.endereco());
	}

	public void atualizarDados(AtualizarMedicoDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.enderecoDTO() != null) {
            this.endereco.atualizarEndereco(dados.enderecoDTO());
        }
	}

	public void desativarMedico() {
		this.ativo = false;
	}
	
}
