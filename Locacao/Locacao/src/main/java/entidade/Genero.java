/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author laerton
 */
public enum Genero{
    ACAO(0), COMEDIA(1), DRAMA(2), SUSPENSE(3), ROMANCE(4), AVENTURA(5), TERROR(6);
    
    private int value ;

    private Genero(int value) {
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
    
    public Genero valueOf(int i){
        this.value = 1;
        return  this;
    }
    
}
