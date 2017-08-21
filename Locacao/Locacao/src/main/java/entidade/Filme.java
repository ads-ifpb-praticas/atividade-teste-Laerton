/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.time.LocalDate;

/**
 *
 * @author laerton
 */
public class Filme {
    private int id = 0;
    private String nome;
    private int duracao;
    private Genero genero;
    private boolean  locado =false;
    private LocalDate dtLocacao;
    private LocalDate dtDevolucao;

    public Filme(int id,String nome, int duracao, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }

    public LocalDate getDtLocacao() {
        return dtLocacao;
    }

    public void setDtLocacao(LocalDate dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public LocalDate getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(LocalDate dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}


