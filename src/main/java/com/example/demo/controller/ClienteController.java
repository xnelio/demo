package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.service.ServiceCliente;

@RestController
public class ClienteController {

	@Autowired
	ServiceCliente cs ;
    
    @RequestMapping(method=RequestMethod.POST, value ="demo/clientes", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> indexClientes(@RequestBody Cliente cliente){
        Cliente c = cs.cadastrarClientes(cliente);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    
    @RequestMapping(method=RequestMethod.GET, value ="demo/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Cliente>> buscarTodosOsClientes(){
        Collection<Cliente> clientesBuscados = cs.buscarTodos();
        return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value ="demo/clientes/{id}")
    public ResponseEntity<Cliente> removerCliente(@PathVariable Integer id){
        String msg;
    	Cliente clienteEncontrado = cs.buscarPorId(id);
        if(clienteEncontrado==null){
        	msg = "Cliente não encontrado! Nenhuma Ação realizada.";
        	System.out.println(msg);
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
        	cs.excluirCliente(clienteEncontrado);
        	msg = "Cliente removido com sucesso!";
        }
        System.out.println(msg);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    	
    @RequestMapping(method=RequestMethod.PUT, value ="demo/clientes", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> alterarClientes(@RequestBody Cliente cliente){
        String msg;
    	Cliente clienteAlterado = cs.buscarPorId(cliente.getId());
        if(clienteAlterado==null){
        	msg = "Cliente não encontrado! Nenhuma Ação realizada.";
        	System.out.println(msg);
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
        	cs.cadastrarClientes(clienteAlterado);
        	msg = "Cliente Alterado com sucesso!";
        }
        System.out.println(msg);
        return new ResponseEntity<>(cs.buscarPorId(cliente.getId()), HttpStatus.OK);
    }
    
    
}
