
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

public class UsuarioController {
    
    public void createUsuario(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a criar um novo Usuário: ");
        System.out.print("username (deve ser único): ");
        String username = input.next();
        System.out.print("Nome real: ");
        String nome = input.next();
        System.out.print("Biografia: ");
        String biografia = input.next();
        UsuarioBean ub = new UsuarioBean(username,nome,biografia);
        UsuarioModel.create(ub, con);
        System.out.println("Usuário criado com sucesso!!");
    }

    void listarUsuario(Connection con) throws SQLException {
        HashSet all = UsuarioModel.listAll(con);
        Iterator<UsuarioBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
