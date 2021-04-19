/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author Cleyton-pc
 */
public class UsuarioDirector {
    private IUsuarioBuilder UsuarioBuilder;

    public UsuarioDirector(IUsuarioBuilder UsuarioBuilder) {
        this.UsuarioBuilder = UsuarioBuilder;
    }

    public Usuario getUsuarioBuilder() {
        return this.UsuarioBuilder.getUsuario();
    }
    
    public void InserirUsuario(String nome, String email, String password){
        this.UsuarioBuilder.cadastraUsuario(nome, email,password);
    }
    
    
}
