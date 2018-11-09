/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author developer
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
