/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import Builder.IUsuario;
import Builder.Usuario;

/**
 *
 * @author Cleyton-pc
 */
public interface RedesSociais {
    public void criarPostFeed();
    public void criarPostStories();
    public Usuario adicionarUsuario();
    public void removerUsuario();
    public void adicionarAmigo();
    public void removerAmigo();
    public void enviaMensagem();
}
