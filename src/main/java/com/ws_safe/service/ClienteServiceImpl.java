/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.service;

import com.ws_safe.dao.ClienteDAO;
import com.ws_safe.entity.Cliente;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */

@Service
public class ClienteServiceImpl {
    
    Logger logger = Logger.getLogger(ClienteServiceImpl.class);
    
    @Resource
    ClienteDAO cliente;
    
    public List<Cliente> getListCliente() {
        return cliente.getListCliente();
    }

   
    public boolean addCliente(Cliente cliente) {
        return false;
    }

    public Cliente getByIdCliente(Long id) {
        return new Cliente();
    }

    public void deleteCliente(Long id) {
        
    }

    public boolean updateCliente(Cliente cliente) {
        return false;
    } 
}
