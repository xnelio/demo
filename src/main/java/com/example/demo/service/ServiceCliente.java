package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ServiceCliente {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	 	//public Map<Integer, Cliente> clientes;
	    
	    public Cliente cadastrarClientes(Cliente cliente){
	        
	        return clienteRepo.save(cliente);
	        
	    }
	    
	    public Collection<Cliente> buscarTodos(){
	    	return clienteRepo.findAll();
	    }
	    
	    public void excluirCliente(Cliente cliente){
	    	
	    	clienteRepo.delete(cliente);
	    }
	    
	    public Cliente buscarPorId(int id){
	    	
	    	return clienteRepo.findOne(id);
	    }
	    
	    public void updateCliente(Cliente cliente){
	    	clienteRepo.save(cliente);
	    	
	    }
}
