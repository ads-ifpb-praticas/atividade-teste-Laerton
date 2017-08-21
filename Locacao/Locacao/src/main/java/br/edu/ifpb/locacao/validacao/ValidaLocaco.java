/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.locacao.validacao;

import Exception.FilmeException;
import entidade.Filme;
import java.time.LocalDate;
import javax.annotation.processing.FilerException;

/**
 *
 * @author laerton
 */
public class ValidaLocaco {
    
    
    public static boolean validaFilmeIsLocado(Filme filme) throws FilmeException{
        if (filme.getId() !=0 && filme.isLocado()){
            throw  new FilmeException("nao e possivel editar um filme locado.");
        }
        return true;
    }
    
    public static boolean validaEmprestimo(Filme filme, LocalDate data) throws FilmeException{
        if (!filme.isLocado()&& data.isBefore(LocalDate.now())){ throw  new  FilmeException("Filme nao pode ser locado com data retroativa.");}
        return true;
    }
    
    public static boolean validaDevolucao (Filme filme , LocalDate data) throws FilmeException{
        if (filme.isLocado() &&  filme.getDtLocacao().isAfter(data)){ throw new FilmeException("Nao pode ser feita a devolucao com data anterior a de locacao." );}
        return true;
    }
}
