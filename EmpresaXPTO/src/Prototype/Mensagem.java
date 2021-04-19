/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

/**
 *
 * @author Cleyton-pc
 */
public abstract class Mensagem {
    public String UsuarioInicio;
    public String UsuarioFinal;
    public String mensagem;
    
    public Mensagem(){
        
    }
    
    public Mensagem(Mensagem mensagem){
        if(mensagem!=null){
            this.UsuarioInicio = mensagem.UsuarioInicio;
            this.UsuarioFinal = mensagem.UsuarioFinal;
            this.mensagem = mensagem.mensagem;
        }
    }
    
    public abstract Mensagem clone();
    
}
