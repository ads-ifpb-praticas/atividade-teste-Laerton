/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.locacao.validacao;

import Exception.FilmeException;
import entidade.Filme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe de validacao de filmes.
 * @author laerton
 */
public  class ValidaFilme {
    
    public static boolean validaFilme(Filme filme) throws FilmeException{
        if (filme == null){throw  new FilmeException("Filme nao pode ser nulo.");}
        return validaDuracao(filme) & validaGenero(filme) & validaNome(filme);
    }

    private static boolean validaDuracao (Filme filme) throws FilmeException {
        if (filme.getDuracao()<=0 ){ throw  new FilmeException("Duracao nao pode ser menor ou igual a zero.");}
        return true;
    }
    
    private static boolean validaGenero (Filme filme) throws FilmeException{
        if  (filme.getGenero() == null){ throw  new FilmeException("Filme obrigatoriamente tem que conter um genero.");}
        return true;
    }

    private static boolean validaNome (Filme filme) throws FilmeException{
        if (filme.getNome().length() > 50){ throw  new FilmeException("Filme nao deve conter mais de 50 caracteres.");}
        
        Pattern p = Pattern.compile("^[a-zA-Z0-9!#? \\p{L}]+$");
        Matcher m = p.matcher(filme.getNome());
        if(!m.matches())
            throw new FilmeException("O titulo do Filme nao pode conter #,! or ? ou caracteres especiais!");
        return true;
    }
}
