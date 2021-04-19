/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import Singleton.ConexaoMySQL;

/**
 *
 * @author Cleyton-pc
 */
public class UsuarioInsta implements IUsuarioBuilder {
    private ConexaoMySQL conexaoSQL;
    private Usuario usuario;

    public UsuarioInsta(Usuario usuario) {
        this.usuario = new Usuario();
    }

        @Override
    public void cadastraUsuario(String nome, String email, String password) {
        conexaoSQL = new ConexaoMySQL();
        conexaoSQL.inserirBanco(nome, email, password);
    }

    @Override
    public void removeUsuario(String email) {
        conexaoSQL = new ConexaoMySQL();
        conexaoSQL.removerBanco(email);
    }

    @Override
    public Usuario getUsuario() {
        return this.usuario;
    }
    
}
