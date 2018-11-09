package com.ws_safe.controller;

import com.ws_safe.entity.Cliente;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ws_safe.service.ClienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@RestController
public class ClienteController {
    Logger logger = Logger.getLogger(ClienteController.class);

    @Autowired
    @Qualifier("clienteService")
    ClienteService clienteServiceImpl;
    
    @RequestMapping("/")
    public String index() {
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> clientes = session.doReturningWork((Connection connection) -> {
            String query = "{CALL SAFE.GET_ALL_CLIENTE(?)}";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.executeUpdate();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            List<Cliente> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Cliente(rs.getInt("id"), rs.getString("NOMBRE")));
            }
            return list;
        });
        
        session.doWork(connection -> {
            String query = "{CALL SAFE.GET_ALL_CLIENTE(?) }";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
            callableStatement.executeUpdate();
            ResultSet rs = (ResultSet) callableStatement.getObject(1);
            while (rs.next()) {
                System.out.println(rs.getString("id") + ' ' +  rs.getString("NOMBRE"));
            }
        });
        
        session.close();
        
        String out = "";
        for(Cliente s: clientes){
            out = out + "<p>Id:"+s.getId()+", Nombre:"+s.getNombre()+"</p>";
        }
        
        return "<h1>Greetings from Spring Boot!</h1>" + out;
        */
        
        //Gson gson = new Gson();
        
        String jsonCliente="";
        List<Cliente> listCliente;        
        try {
            listCliente = clienteServiceImpl.getListCliente();
            //logger.info("La cantidad de clientes son: "+listCliente.size());
            //jsonCliente = gson.toJson(listCliente);
            int i =  1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"status\":\"OK\"}"; //jsonCliente;
    }
    
}
