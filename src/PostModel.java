
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

    public static int selectNextID() throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        String query = "select max(id_post)+1 from post";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao achar o próximo ID no banco");
        }
        return 0;
    }

    static void create(PostBean m, Connection con) throws SQLException {
        PreparedStatement st, st2;
            st = con.prepareStatement("INSERT INTO post (id_post,descricao,imagem) "
                    + "VALUES (?,?,?)");
            int id = selectNextID();
            st.setInt(1,id);
            st.setString(2, m.getDescricao());
            st.setString(3, m.getImagem());
            st.execute();
            st.close();
            st2= con.prepareStatement("insert into publicacoes (id_post, username) VALUES (?,?)");
            st2.setInt(1,id);
            st2.setString(2, m.getUsername());
            st2.execute();
            st2.close();
    }

    public static void novaCurtida(int postID, String username, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("insert into curtiu values(?,?)");
        st.setInt(1, postID);
        st.setString(2, username);
        st.execute();
        st.close();
    }
    
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT p.*, u.username FROM post p, usuario u, publicacoes pu where pu.id_post = p.id_post and pu.username=u.username";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new PostBean(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }
        return list;
    }    

    static HashSet listAllWithUsuarios(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        String retorno = new String();
        st = con.createStatement();
        String sql = "SELECT p.*, u.* FROM post p, usuario u, publicacoes pu where pu.id_post = p.id_post and pu.username=u.username ";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            String username=result.getString(4);
            retorno += "ID Post: "+result.getInt(1)+", Descrição: "+result.getString(2)+
            ", Imagem: "+result.getString(3)+", Username: "+username+", Nome: "+result.getString(5)+
            ", Biografia: "+result.getString(6)+"\n";
        }
        list.add(retorno);
        return list;
    }

}
