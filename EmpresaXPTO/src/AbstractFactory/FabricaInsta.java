
package AbstractFactory;

public class FabricaInsta implements RedesFactory {

    @Override
    public RedesSociais criar() {
        System.out.println("Criando rede TIPTOP");
        return new RedeInsta();
    }
    
}
