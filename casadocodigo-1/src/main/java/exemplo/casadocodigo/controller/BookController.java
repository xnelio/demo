package exemplo.casadocodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exemplo.casadocodigo.dao.ProductDAO;
import exemplo.casadocodigo.model.Book;
import exemplo.casadocodigo.model.BookType;

@Controller
public class BookController {

	@Autowired
	private ProductDAO productDAO = new ProductDAO();

	@GetMapping("/produtos/list")
	public ModelAndView form(){
		ModelAndView mAV = new ModelAndView("/products/listar-produtos");
		mAV.addObject("types", BookType.values());
		return mAV;
	}
	
	@GetMapping("/produtos")
	public ModelAndView getForm(){
		ModelAndView mAV = new ModelAndView("/products/cadastro-produto");
		mAV.addObject("types", BookType.values());
		return mAV;
	}
	
	@PostMapping("/produtos")
	public ModelAndView save(Book book) {
		ModelAndView mAV = new ModelAndView("/produtos/list");
		productDAO.save(book);
		return mAV;

	}
}
