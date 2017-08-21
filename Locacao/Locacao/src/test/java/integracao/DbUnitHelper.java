/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import servico.CriaBase;

/**
 *
 * @author laerton
 */
public class DbUnitHelper {
    private Connection conexao;
    private DatabaseConnection conexaoDBUnit;
    private String xmlFolder;

    public DbUnitHelper(String xmlFolder) throws DatabaseUnitException, SQLException {
        this.xmlFolder = xmlFolder;
        conexao = CriaBase.getConnection();
        conexaoDBUnit = new DatabaseConnection(conexao);
        DatabaseConfig config = conexaoDBUnit.getConfig();
        //config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory());
    }

    public Connection getConexao() {
        return conexao;
    }

    public DatabaseConnection getConexaoDBUnit() {
        return conexaoDBUnit;
    }
    
    
    
    public void execute(DatabaseOperation operation, String xml) {
		try {
			InputStream is = getClass().getResourceAsStream("/" + xmlFolder + "/" + xml);
			FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
			IDataSet dataSet = builder.build(is);
 
			operation.execute(conexaoDBUnit, dataSet);
		} catch (Exception e) {
			throw new RuntimeException("Erro executando DbUnit", e);
		}
	}
 
	public void close() {
		try {
			conexaoDBUnit.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    
}
