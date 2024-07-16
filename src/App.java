import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println(VeiculoService.listarTodos());
        /*Veiculo v = new Veiculo();
        v.setCodigo(null);
        v.setFabricante("Ford");
        v.setModelo("Bronco LEO");
        v.setAnofabricacao(2024);
        v.setAnomodelo(2024);
        v.setValor(250000D);
        //VeiculoService.inserir(v);
        VeiculoService.alterar(v, 11);
        System.out.println(VeiculoService.listarTodos());*/
        System.out.println(VeiculoService.listarPorFabricante("Ford"));
        
    }

    public static Connection getConexao(){
        Connection con = null; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //String url = "jdbc:mysql://200.128.9.179:3306/veiculojdbc"
            String url = "jdbc:mysql://10.28.0.35:3306/veiculojdbc";
            String usuario = "remoto";
            String senha = "remoto";
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Não foi possível conectar ao BD.");
            e.printStackTrace();
        }
        return con;
    }
}
