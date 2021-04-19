/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryMethod;

/**
 *
 * @author Cleyton-pc
 */
public class AtividadesFace implements Atividades {

    @Override
    public void criarPostFeed() {
        System.out.println("Postando fotos no face...");
    }

    @Override
    public void criarStorie() {
        System.out.println("Postando stories no face....");
    }
    
}
