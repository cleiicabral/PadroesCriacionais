package Singleton;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {

    private static ConexaoMySQL conexaoSQL = null;
    public static String status = "Não conectou...";

    public ConexaoMySQL() {

    }

    public static ConexaoMySQL getInstancia() {

        if (conexaoSQL == null) {
            conexaoSQL = new ConexaoMySQL();
        }
        return conexaoSQL;

    }

    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String mydatabase = "banco_xpto";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = "mysql";
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static String statusConection() {

        return status;

    }

    public static boolean FecharConexao() {
        try {
            ConexaoMySQL.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();
        return ConexaoMySQL.getConexaoMySQL();

    }

    public void inserirBanco(String nome, String email, String password) {
        try {

            String sql = "INSERT INTO usuarios (Nome,Email,Password) VALUES(?,?,?)";
            PreparedStatement pstmt = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.execute();
            ConexaoMySQL.FecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //INSERE MENSAGEM NA TABELA MENSAGENS
    public void inserirBanco(int usuarioInicio, int usuarioFinal, String mensagem) {

        try {

            String sql = "INSERT INTO mensagem (de,para,texto) VALUES(?,?,?)";
            PreparedStatement pstmt = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
            pstmt.setInt(1, usuarioInicio);
            pstmt.setInt(2, usuarioFinal);
            pstmt.setString(3, mensagem);
            pstmt.execute();
            ConexaoMySQL.FecharConexao();
            System.out.println("Mensagem enviada!!");
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    //insere amigo na tabela amizades
    public void inserirBanco(int idUsuario, int idAmigo) {

        try {

            String sql = "INSERT INTO amizades (idusuario,idamigo) VALUES(?,?)";
            PreparedStatement pstmt = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idAmigo);
            pstmt.execute();
            ConexaoMySQL.FecharConexao();
            System.out.println("Amigo adicionado");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    
    public void removerBanco(String email) {
        try {

            String sql = "DELETE FROM usuarios WHERE email=?";
            PreparedStatement pstmt = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.executeUpdate();
            ConexaoMySQL.FecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void removerBanco(int idUsuario,int idAmigo) {
        try {

            String sql = "DELETE FROM amizades WHERE idusuario=? and idamigo=?";
            PreparedStatement pstmt = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idAmigo);
            pstmt.executeUpdate();
            ConexaoMySQL.FecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //Seleciona amigos de um usuario;
    public void selectBanco(int idUsuario) {
        try {

            String sql = "SELECT usuarios.idUsuarios,usuarios.nome from amizades inner join usuarios "
                    + "ON amizades.idamigo=usuarios.idUsuarios where amizades.idusuario=(?)";
            PreparedStatement pstmt = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
            pstmt.setInt(1, idUsuario);
//Executa o comando de consulta aonde guarda os dados retornados dentro do ResultSet.
//Pelo fato de gerar uma lista de valores, é necessário percorrer os dados através do laço while
            ResultSet rs = pstmt.executeQuery();
//Faz a verificação de enquanto conter registros, percorre e resgata os valores

            while (rs.next()) {
                System.out.printf("%i - %s ", rs.getInt(0), rs.getString(1));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    //seleciona um id de usuario de acordo com o email;
    public int selectBanco(String emailUsuario) {
        try {

            String sql = "SELECT idUsuarios,Nome FROM usuarios where email= (?)";
            PreparedStatement pstmt = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
            pstmt.setString(1,emailUsuario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("idUsuarios");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    //seleciona todos os usuários;
    public int selectBanco() {
        try {

            String sql = "SELECT idUsuarios,Nome FROM usuarios";
            PreparedStatement pstmt = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.printf("%s - %s ", rs.getInt("idUsuarios"), rs.getString("Nome"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    
    public void alterarBanco() {
        try {

            Statement stmt = ConexaoMySQL.getConexaoMySQL().createStatement();
            String sql = "UPDATE my_table SET col_string='a new string' WHERE col_string = 'a string'";
            stmt.executeUpdate(sql);
            ConexaoMySQL.FecharConexao();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    
}
