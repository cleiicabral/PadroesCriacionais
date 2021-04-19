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
public class AtividadesFactory extends FactoryAtRede {

    @Override
    public Atividades createAtividades() {
        return new AtividadesFace();
    }

   
    
}
