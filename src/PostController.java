
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PostController {
    public void createPost(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a criar um novo Post: ");
        System.out.println("Username: ");
        String username = input.next();
        System.out.print("Descrição: ");
        String descricao = input.next();
        System.out.print("Caminho para imagem: ");
        String imagem = input.next();

        PostBean pb = new PostBean(descricao, imagem, username);
        PostModel.create(pb, con);
        System.out.println("Post criado com sucesso!!");
    }

    void listarPosts(Connection con) throws SQLException {
        HashSet all = PostModel.listAll(con);
        Iterator<PostBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    void listarPostsUsuarios(Connection con) throws SQLException {
        HashSet all = PostModel.listAllWithUsuarios(con);
        Iterator<String> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
