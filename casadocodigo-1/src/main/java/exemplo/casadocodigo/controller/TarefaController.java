package exemplo.casadocodigo.controller;



import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import exemplo.casadocodigo.dao.TarefaDAO;
import exemplo.casadocodigo.model.Tarefa;

@Controller
public class TarefaController {

	@Autowired
	TarefaDAO tarefaDao;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value="adicionaTarefa")
	public ModelAndView adiciona(@Valid Tarefa tarefa, BindingResult result,
			RedirectAttributes atributos) {
		if(result.hasFieldErrors()) {
			return form(tarefa);
		}
		tarefaDao.save(tarefa);
		atributos.addFlashAttribute("mensagem", "Tarefa salvo com sucesso!");
		
		return new ModelAndView("redirect:/novaTarefa");
	}
	
	@RequestMapping(value="novaTarefa", method=RequestMethod.GET)
	  public ModelAndView form(Tarefa tarefa) {
		
		ModelAndView mv = new ModelAndView("tarefas/tarefa");
		
	    return mv;
	  }
	
	@RequestMapping(value="listaTarefa", method=RequestMethod.GET)
	public ModelAndView lista() {
	 
	  ModelAndView mv = new ModelAndView("tarefas/lista");
	  mv.addObject("tarefas", tarefaDao.findAll());
	  return mv;
	}
	
	
	@RequestMapping(value="/excluir/{id}", method=RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") Integer id) {
		//List<Long> ids = atributos.getFlashAttributes().get("remover");
		tarefaDao.delete(id);
		ModelAndView mv = new ModelAndView("foward:/listaTarefa");
		return mv;
	}

	
}
