package med.voll.api.Model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.DTO.AtualizarPacienteDTO;
import med.voll.api.DTO.PacienteDTO;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@Embedded
	private Endereco endereco;
	
	public Paciente(PacienteDTO pacienteDTO) {
		this.nome = pacienteDTO.nome();
		this.email = pacienteDTO.email();
		this.telefone = pacienteDTO.telefone();
		this.cpf = pacienteDTO.cpf();
		this.endereco = new Endereco(pacienteDTO.endereco());
	}
	
	public void atualizarDados(AtualizarPacienteDTO atualizarPacienteDTO) {
		if (this.nome != null) {
			this.nome = atualizarPacienteDTO.nome();
		}
		if (this.telefone != null) {
			this.telefone = atualizarPacienteDTO.telefone();
		}
		if (this.endereco != null) {
			this.endereco.atualizarEndereco(atualizarPacienteDTO.endereco());
		}
		
	}

}
