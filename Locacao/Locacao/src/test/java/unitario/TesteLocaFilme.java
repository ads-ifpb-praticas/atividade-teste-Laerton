/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario;

import Exception.FilmeException;
import entidade.Filme;
import entidade.Genero;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import servico.DAOFilme;
import servico.FilmeServico;

/**
 *
 * @author laerton
 */
public class TesteLocaFilme {
    
    public TesteLocaFilme() {
    }
    @Mock
    private DAOFilme dao = null;
    private FilmeServico servico =null;
    
    private Filme f1,f2,f3;
    
    
    @Before
    public void setUp() {
        f1 = new Filme(1, "A mumia ", 120, Genero.TERROR);
        f1.setLocado(true);
        f1.setDtLocacao(LocalDate.parse("2017-08-10"));
        f2 = new Filme(2, "O templo da perdicao", 120, Genero.AVENTURA);
        f2.setLocado(false);
        f2.setDtLocacao(LocalDate.parse("2017-08-10"));
        f2.setDtDevolucao(LocalDate.parse("2017-08-12"));
        f3 = new Filme(3, "Uma baba quase perfeita", 120, Genero.COMEDIA);
        MockitoAnnotations.initMocks(this);
        when(dao.busca(1)).thenReturn(f1);
        when(dao.busca(2)).thenReturn(f2);
        when(dao.busca(3)).thenReturn(f3);
        when(dao.salvar(Mockito.any(Filme.class))).thenReturn(Mockito.any(Filme.class));
        servico = new FilmeServico(dao);
    }
    
  
     @Test
     public void testeLocaFilme() throws FilmeException{
         Filme filme = servico.buscaFilme(3);
         servico.locaFilme(filme, LocalDate.now());
     }
     
     @Test(expected = FilmeException.class)
     public void testeLocaFilmeJaLocado() throws FilmeException{
         Filme filme = servico.buscaFilme(1);
         servico.locaFilme(filme, LocalDate.now());
     }
     
     @Test
     public void testeLocaFilmeJaDevoldido() throws FilmeException{
         Filme filme = servico.buscaFilme(2);
         servico.locaFilme(filme, LocalDate.now());
     }
     
     @Test
     public void testeSalvaFilmeNovo() throws FilmeException{
         Filme filme = new Filme(2, "Filme de teste", 120, Genero.TERROR);
         servico.salvaFilme(filme);
     }
     
     
}
