package exemplo.casadocodigo.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message="{tarefa.descricao.vazia}") 
	@Size(min=5, max=200, message="{tarefa.descricao.pequena}")
	private String descricao;
	private boolean finalizado;
	private Calendar dataFinalizacao;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

}