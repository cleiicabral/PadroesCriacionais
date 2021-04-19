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
public interface IUsuarioBuilder {
    public void cadastraUsuario(String nome, String email, String password);
    public void removeUsuario(String email);
    public Usuario getUsuario();
}
