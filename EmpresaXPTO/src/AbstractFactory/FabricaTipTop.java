
package AbstractFactory;

public class FabricaTipTop implements RedesFactory {

    @Override
    public RedesSociais criar() {
        System.out.println("Criando rede TIPTOP");
        return new RedeTipTop();
    }
    
}
