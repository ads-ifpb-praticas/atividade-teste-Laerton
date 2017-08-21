/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracao;

import entidade.Filme;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.dbunit.DatabaseUnitException;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import servico.DAOFilme;

/**
 *
 * @author laerton
 */
public class DAOFilmeTest {
    private static DbUnitHelper dbUnitHelper;
    private static EntityManagerFactory factory;
	
    private EntityManager manager;
    private DAOFilme dao;
    
    @BeforeClass
    public static void initClass() {
        try {
            dbUnitHelper = new DbUnitHelper("DbUnitXml");
            factory = Persistence.createEntityManagerFactory("artigoTesteIntegracaoDbunitPU");
        } catch (Exception ex) {
            Logger.getLogger(DAOFilmeTest.class.getName()).log(Level.SEVERE, null, ex);
        
        }
		
    }
 
	@Before
	public void init() {
		dbUnitHelper.execute(DatabaseOperation.DELETE_ALL, "dados.xml");
 		dbUnitHelper.execute(DatabaseOperation.INSERT, "dados.xml");
 		this.dao = new DAOFilme(dbUnitHelper.getConexao());
	}
	
	@After
	public void end() {
		this.manager.close();
	}
    
        @Test
        public void testeBusca(){
            Filme filme = dao.busca(1);
            Assert.assertNotNull(filme);
            filme = dao.busca(5);
            Assert.assertNull(filme);
        }
        
 
}
