package exemplo.casadocodigo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import exemplo.casadocodigo.model.Tarefa;

@Repository
public interface TarefaDAO extends JpaRepository<Tarefa, Integer> {

	


}
