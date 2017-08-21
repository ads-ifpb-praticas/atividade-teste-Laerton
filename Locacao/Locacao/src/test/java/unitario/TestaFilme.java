package unitario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Exception.FilmeException;
import br.edu.ifpb.locacao.validacao.ValidaFilme;
import entidade.Filme;
import entidade.Genero;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laerton
 */
public class TestaFilme {
    
    public TestaFilme() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testaValidaNome() throws FilmeException{
        Filme filme = new Filme(1, "A mumia", 120, Genero.TERROR);
        ValidaFilme.validaFilme(filme);
    }
    
    @Test(expected = FilmeException.class)
    public void testaValidaNomeTamanho() throws FilmeException{
        Filme filme3 = new Filme(3, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 120, Genero.TERROR);
        ValidaFilme.validaFilme(filme3);
    }
    
    @Test(expected = FilmeException.class)
    public void testaValidaNomeCaracteres() throws FilmeException{
        Filme filme2 = new Filme(2, "-0-9-09090-90()()()", 120, Genero.TERROR);
        ValidaFilme.validaFilme(filme2);
    }
    
    @Test(expected = FilmeException.class)
    public void testaValidaFilmeNulo() throws FilmeException{
        Filme filme2 = null;
        ValidaFilme.validaFilme(filme2);
    }
    
    @Test(expected = FilmeException.class)
    public void testaValidaFilmeSemGenero() throws FilmeException{
        Filme filme = new Filme(1, "A mumia", 120, null);
        ValidaFilme.validaFilme(filme);
    }
    
    @Test(expected = FilmeException.class)
    public void testaValidaFilmeDuracao() throws FilmeException{
        Filme filme = new Filme(1, "A mumia", 0, Genero.TERROR);
        ValidaFilme.validaFilme(filme);
    }
    
    @Test(expected = FilmeException.class)
    public void testaValidaFilmeDuracaoNegativa() throws FilmeException{
        Filme filme = new Filme(1, "A mumia", -120, Genero.TERROR);
        ValidaFilme.validaFilme(filme);
    }
}
