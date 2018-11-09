/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws_safe.dao;

import com.ws_safe.app.HibernateUtil;
import com.ws_safe.entity.Cliente;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import org.hibernate.Session;
import java.sql.CallableStatement;
import org.hibernate.jdbc.ReturningWork;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;



public class ClienteDAOImpl {
    Logger logger = Logger.getLogger(ClienteDAOImpl.class);

    public List<Cliente> getListCliente() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.doReturningWork(new ReturningWork<List<Cliente>>() {
            @Override
            public List<Cliente> execute(Connection connection) throws SQLException {
                String query = "{CALL GET_ALL_CLIENTE(?)}";
                CallableStatement callableStatement = connection.prepareCall(query);
                callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
                callableStatement.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement.getObject(1);
                List<Cliente> clients;
                clients = new ArrayList<Cliente>();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setNombrecontacto(rs.getString("NOMBRE"));
                    cliente.setIdcliente(rs.getInt("id"));
                    clients.add(cliente);
                }
                return clients;
            }
        });
    }
    
    
    public boolean addCliente(Cliente cliente) {
        boolean flagsave = false;
        HibernateUtil.getSessionFactory().getCurrentSession().save(cliente);
        flagsave=true;
        
        return flagsave;
    }

    public Cliente getByIdCliente(Long id) {
        Query query = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("FROM Cliente as c WHERE c.idcliente=:id");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
    }

    public void deleteCliente(Long id) {
        Query query = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("delete FROM Cliente as c WHERE c.idcliente=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public boolean updateCliente(Cliente cliente) {
        boolean flagsave = false;
        HibernateUtil.getSessionFactory().getCurrentSession().update(cliente);
        flagsave=true;
        
        return flagsave;
    }
    
    
    
	/*public void getOneClienteSP(Long id) {
        Connection cn = null;
        
            try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:orcl12c", "SAFE", "safe");
            CallableStatement call = cn.prepareCall("{call ClientePKG.ClienteConsultar(?,?)}");
            call.setLong(1, 1);
            
            call.registerOutParameter(2, java.sql.Types.VARCHAR);
            
            call.execute();
            
            String razon = call.getString(2);
            
                System.out.println("RAzon Social:"+razon); 
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            /*final ProcedureCall 
             query = new ProcedureCallImpl()
            query.setParameter("id_cli", id);
            CallableStatement call = PreparedStatementCallback
            List queryList = query.list();
            if (queryList.size()>0) {
                return (Cliente)queryList.get(0);
            }else{
                return null;
            }*/
	/*}*/
}
    /*public Cliente cliente_consultar(Long id) {
    
        
        
      Query query = HibernateUtil.getSessionFactory().getCurrentSession().getNamedQuery("Cliente_Consultar").setParameter("id_cli", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
            
        }else{
            return null;
        }
    }

    @PersistenceContext
    private EntityManager em
    public Cliente cap_consultar(Long id) {
        Query query = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("BEGIN cap_consulta(:id); END");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
        
         
        this.em.createNativeQuery("BEGIN cap_consulta(:id); END")
                .setParameter("id", id)
                .executeUpdate(); 
        
    }

   private EntityManagerFactory emf;
    public Cliente cliente_consultar(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        StoredProcedureQuery spQuery = this.em.createNamedStoredProcedureQuery("Cliente_Consultar");
                spQuery.setParameter("id", id)
                .executeUpdate(); 
        
        
        
        
        
        Query query = HibernateUtil.getSessionFactory().getCurrentSession().createQuery("BEGIN Cliente_Consultar(:id); END;");
        query.setParameter("id", id);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
        }else{
            return null;
        }
    }

       
    public Cliente cliente_consultar(Long id) {
        
        Query query = HibernateUtil.getSessionFactory().getCurrentSession().getNamedQuery("Cliente_Consultar").setParameter("id_cli", id);
        
        //StoredProcedureQuery query = entityManager.createStoredProcedureQuery("")
        //Query query = HibernateUtil.getSessionFactory().getCurrentSession().getNamedQuery("Cliente_Consultar");
        //query.setParameter("id", id);
        //query.setParameter("rut", rut);
        List queryList = query.list();
        if (queryList.size()>0) {
            return (Cliente)queryList.get(0);
            
        }else{
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Cliente> cliente_consultar(String rut) {
        
        return em.createNativeQuery("Cliente_Consultar").setParameter("id_cliente", rut).getResultList();
    }

    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;
 
    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("jpa-db");
        entityManager = factory.createEntityManager();
    }
    
    @Test
    public void cliente_consultar() {
        StoredProcedureQuery findByIdCliente = 
          entityManager.createNamedStoredProcedureQuery("Cliente_Consultar");
         
        StoredProcedureQuery storedProcedure = 
          findByIdCliente.setParameter("id_cliente", 1);
         
        storedProcedure.getResultList().forEach(action);
          .forEach(c -> Assert.assertEquals(new Long(1), ((Cliente) c).getRazonsocial())); 
    }
    
    
}*/
