package AbstractFactory;

public class FabricaFace implements RedesFactory {

    @Override
    public RedesSociais criar() {
        System.out.println("Criando rede TIPTOP");
        return new RedeFace();
    }
}
