/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import entidade.Filme;
import entidade.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class DAOFilme {

    private final Connection connection ;

    public DAOFilme(Connection connection) {
        this.connection = connection;
    }
    
    
    public Filme salvar(Filme filme) {
        String SQL = "Insert into filme ( nome,durcao, genero, id) values (?,?,?,?)";
        return persiste(SQL, filme);
    }
    
    public Filme atualizar (Filme filme){
        String SQL = "update filme set  nome = ? ,durcao = ?, genero= ? where  id =?;";
        return persiste(SQL, filme);
    }
    
    public Filme busca (int id ){
        PreparedStatement ps;
        Filme resultado = null;
        try {
            ps = this.connection.prepareStatement("Select * from filme where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                resultado = montaFilme(rs, resultado);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
        
    }

    private Filme persiste(String SQL, Filme filme) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(SQL);
            ps.setString(1, filme.getNome());
            ps.setInt(2, filme.getDuracao());
            ps.setInt(3, filme.getGenero().getValue());
            ps.setInt(4, filme.getId());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filme;
    }

    private Filme montaFilme(ResultSet rs, Filme resultado) throws SQLException {
        resultado = new Filme(rs.getInt("id"), rs.getString("nome"), rs.getInt("duracao"), Genero.ACAO.valueOf(rs.getInt("genero")));
        return  resultado;
    }
    
}
