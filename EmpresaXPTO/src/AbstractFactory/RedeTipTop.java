package AbstractFactory;

import Builder.IUsuarioBuilder;
import Builder.Usuario;
import Builder.UsuarioDirector;
import Builder.UsuarioTipTop;
import FactoryMethod.Atividades;
import FactoryMethod.AtividadesTipTop;
import Prototype.MensagemRedes;
import Singleton.ConexaoMySQL;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedeTipTop implements RedesSociais {

    int idUsuario;
    String nomeUsuario;
    String emailUsuario;
    String passwordUsuario;
    
    private ConexaoMySQL conexaoSQL = new ConexaoMySQL();
    IUsuarioBuilder usuario1 = new UsuarioTipTop();
    UsuarioDirector director1 = new UsuarioDirector(usuario1);
    
    @Override
    public void criarPostFeed() {
        Atividades at1=new AtividadesTipTop();
        at1.criarPostFeed();
    }
    
    @Override
    public void criarPostStories() {
         Atividades at1=new AtividadesTipTop();
        at1.criarStorie();
    }
    
    @Override
    public void adicionarAmigo() {
        conexaoSQL.selectBanco();
        System.out.println("Informe o ID para adicionar como amigo: ");
        Scanner leitor = new Scanner(System.in);
        int Idamigo = leitor.nextInt();
        conexaoSQL.inserirBanco(this.getIdUsuario(), Idamigo);
    }
    
    @Override
    public void removerAmigo() {
        System.out.println("Informe qual amigo deseja remover");
        conexaoSQL.selectBanco(this.getIdUsuario());
        Scanner leitor = new Scanner(System.in);
        int Idamigo = leitor.nextInt();
        conexaoSQL.removerBanco(this.getIdUsuario(), Idamigo);
    }
    
    @Override
    public Usuario adicionarUsuario() {
        System.out.println("Informe seu nome: ");
        Scanner leitor = new Scanner(System.in);
        this.nomeUsuario = leitor.next();
        System.out.println("Informe seu email: ");
        this.emailUsuario = leitor.next();
        System.out.println("Informe seu password: ");
        this.passwordUsuario = leitor.next();
        System.out.println(nomeUsuario + emailUsuario + passwordUsuario);
        
        director1.InserirUsuario(nomeUsuario, emailUsuario, passwordUsuario);
        return director1.getUsuarioBuilder();
    }
    
    @Override
    public void removerUsuario() {
        System.out.println("Informe o email do usuário que deseja remover: ");
        Scanner leitor = new Scanner(System.in);
        String emailUsuarioRemover = leitor.next();
        usuario1.removeUsuario(emailUsuarioRemover);
    }
    
    @Override
    public void enviaMensagem() {
        MensagemRedes m1 = new MensagemRedes();
        try {
            m1.enviarMensagem(usuario1.getUsuario().getEmail());
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(RedeTipTop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario = conexaoSQL.selectBanco(usuario1.getUsuario().getEmail());;
    }
    
}
