
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rebeca
 */
public class UsuarioModel {

    public static void create(UsuarioBean a, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("insert into usuario (username,nome,biografia) VALUES (?,?,?)");
            st.setString(1, a.getUsername());
            st.setString(2, a.getNome());
            st.setString(3, a.getBiografia());
            st.execute();
            st.close();  
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT username, nome, biografia FROM usuario";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new UsuarioBean(result.getString(1), result.getString(2), result.getString(3)));
            }
        return list;
    }

    static HashSet listUsuariosMaioresCurtidas(Connection con) throws  SQLException{
        Statement st;
        HashSet list = new HashSet();
        String retorno = new String();
        st = con.createStatement();
        String sql = "SELECT u.nome, COUNT(*) AS total_curtidas FROM usuario u INNER JOIN curtiu c ON u.username = c.username GROUP BY u.nome HAVING COUNT(*) = (SELECT MAX(total_curtidas) FROM (SELECT username, COUNT(*) AS total_curtidas FROM curtiu GROUP BY username)AS subconsulta);\n";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            retorno += "Nome: "+result.getString(1)+", Total de Curtidas recebidas: "+result.getInt(2)+"\n";
        }
        list.add(retorno);
        return list;
    }
}
