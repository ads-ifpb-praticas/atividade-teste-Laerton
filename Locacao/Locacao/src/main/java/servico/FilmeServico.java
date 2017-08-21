/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Exception.FilmeException;
import br.edu.ifpb.locacao.validacao.ValidaFilme;
import br.edu.ifpb.locacao.validacao.ValidaLocaco;
import entidade.Filme;
import java.time.LocalDate;
import javax.annotation.processing.FilerException;

/**
 *
 * @author laerton
 */

public class FilmeServico {
    private DAOFilme dao;

    public FilmeServico(DAOFilme dao) {
        this.dao = dao;
    }
    
    
    
    public void salvaFilme(Filme filme)throws FilmeException{
        ValidaFilme.validaFilme(filme);
        ValidaLocaco.validaFilmeIsLocado(filme);
        dao.salvar(filme);
    }
    
    public void locaFilme(Filme filme, LocalDate data) throws FilmeException{
        ValidaLocaco.validaFilmeIsLocado(filme);
        ValidaLocaco.validaEmprestimo(filme, data);
        filme.setDtLocacao(data);
        dao.salvar(filme);
    }
    
    public void devolveFilme (Filme filme, LocalDate data)throws FilmeException{
        ValidaLocaco.validaDevolucao(filme, data);
        filme.setDtDevolucao(data);
        dao.salvar(filme);
    }
    
    public Filme buscaFilme(int id){
        return dao.busca(id);
    }
    
}
