
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

public class PostModel {

    static void create(PostBean m, Connection con) throws SQLException {
        PreparedStatement st, st2;
            st = con.prepareStatement("INSERT INTO post (id_post,descricao,imagem) "
                    + "VALUES (?,?,?)");
            //gerar autoincremento pro id post
            st.setString(1, m.getDescricao());
            st.setString(2, m.getImagem());
            st.execute();
            st.close();
            st2= con.prepareStatement("insert into publicacoes (id_post, username)");
            // usar o mesmo autoincremento
            st2.setString(1, m.getUsername());
    }
    
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "select id_post, descricao, imagem from post";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new PostBean(result.getInt(1), result.getString(2), result.getString(3)));
            }
        return list;
    }    

    static HashSet listAllWithUsuarios(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT p.*, u.* FROM post p NATURAL JOIN usuario u";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            PostBean pb = new PostBean(result.getInt(1), result.getString(2), result.getInt(3),
                    result.getString(4), result.getLong(5), result.getString(6), result.getInt(7));
            UsuarioBean a = new UsuarioBean(result.getInt(7), result.getInt(8), result.getInt(9));
            pb.setUsername(a);
            list.add(pb);
        }
        return list;
    }
}
