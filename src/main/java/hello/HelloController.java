package hello;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
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
        /*
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
        */
        session.close();
        
        String out = "";
        for(Cliente s: clientes){
            out = out + "<p>Id:"+s.getId()+", Nombre:"+s.getNombre()+"</p>";
        }
        
        return "<h1>Greetings from Spring Boot!</h1>" + out;
    }
    
}
