
package Prototype;

import Singleton.ConexaoMySQL;
import java.io.IOException;
import java.util.Scanner;

public class MensagemRedes extends Mensagem {
    private ConexaoMySQL conexaoSQL;

    public MensagemRedes() {
    }
    
    
    public MensagemRedes(MensagemRedes mensagemRedes){
        super(mensagemRedes);
    }
    @Override
    public Mensagem clone() {
        return new MensagemRedes(this);
    }

    public void enviarMensagem(String usuarioEmail) throws IOException, InterruptedException{
        conexaoSQL = new ConexaoMySQL();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o ID do usuario que deseja enviar mensagem.");
        int idUsuarioinicio = conexaoSQL.selectBanco(usuarioEmail);
        conexaoSQL.selectBanco(idUsuarioinicio);
        int usuarioFinal = leitor.nextInt();
        //LIMPA TELA
        if (System.getProperty("os.name").contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else{
            Runtime.getRuntime().exec("clear");
        }
            
        System.out.printf("Mensagem de %s para %s - ", idUsuarioinicio,usuarioFinal);
        System.out.print("Digite a mensagem a ser enviada: ");
        String mensagem = leitor.next();
        
        conexaoSQL.inserirBanco(idUsuarioinicio,usuarioFinal, mensagem);
       
        
        
    }
}
