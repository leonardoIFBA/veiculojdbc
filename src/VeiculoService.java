import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    public static List<Veiculo> listarTodos(){
        String sql = "select * from veiculo";
        List<Veiculo> veiculos = new ArrayList<>();

        try(Connection con = App.getConexao()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Veiculo v = new Veiculo();
                v.setCodigo(rs.getInt("codigo"));
                v.setFabricante(rs.getString("fabricante"));
                v.setModelo(rs.getString("modelo"));
                v.setAnofabricacao(rs.getInt("anofabricacao"));
                v.setAnomodelo(rs.getInt("anomodelo"));
                v.setValor(rs.getDouble("valor"));
                veiculos.add(v);
            }
        }catch(SQLException e){
            System.out.println("Não foi possível listar os veiculos");
            e.printStackTrace();
        }
        return veiculos;
    }

    public static void inserir(Veiculo v){
        String sql = "insert into veiculo (fabricante, modelo," +
          " anofabricacao, anomodelo, valor) values (?, ?, ?, ?, ?)";
        try(Connection con = App.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, v.getCodigo());
            ps.setString(1, v.getFabricante());
            ps.setString(2, v.getModelo());
            ps.setInt(3, v.getAnofabricacao());
            ps.setInt(4, v.getAnomodelo());
            ps.setDouble(5, v.getValor());

            int resultado = ps.executeUpdate();
            if (resultado > 0){
                System.out.println("Veículo cadastrado com sucesso!!!");
            }            
        } catch (Exception e) {
            System.out.println("Erro ao inserir um veículo");
            e.printStackTrace();
        }
    }

    public static void alterar(Veiculo v, Integer codigo ){
        String sql = "update veiculo set fabricante = ?, modelo = ?," +
          " anofabricacao = ?, anomodelo = ?, valor = ? where codigo = ?";
        try(Connection con = App.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, v.getFabricante());
            ps.setString(2, v.getModelo());
            ps.setInt(3, v.getAnofabricacao());
            ps.setInt(4, v.getAnomodelo());
            ps.setDouble(5, v.getValor());
            ps.setInt(6, codigo);

            int resultado = ps.executeUpdate();
            if (resultado > 0){
                System.out.println("Veículo alterado com sucesso!!!");
            }            
        } catch (Exception e) {
            System.out.println("Erro ao alterar um veículo");
            e.printStackTrace();
        }
    }

    public static void excluir(Integer codigo){
        String sql = "delete from veiculo where codigo = ?";
        try(Connection con = App.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            int resultado = ps.executeUpdate();
            if (resultado > 0){
                System.out.println("Veículo excluído com sucesso!!!");
            }            
        } catch (Exception e) {
            System.out.println("Erro ao excluir um veículo");
            e.printStackTrace();
        }
    }

    public static List<Veiculo> listarPorFabricante(String fabricante){
        String sql = "select * from veiculo where fabricante = ?";
        List<Veiculo> veiculos = new ArrayList<>();
        try(Connection con = App.getConexao()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fabricante);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                Veiculo v = new Veiculo();
                v.setCodigo(res.getInt("codigo"));
                v.setFabricante(res.getString("fabricante"));
                v.setModelo(res.getString("modelo"));
                v.setAnofabricacao(res.getInt("anofabricacao"));
                v.setAnomodelo(res.getInt("anomodelo"));
                v.setValor(res.getDouble("valor"));
                veiculos.add(v);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar veículo");
            e.printStackTrace();
        }
        return veiculos;
    }
}
