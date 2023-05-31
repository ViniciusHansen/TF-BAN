/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author rebeca
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1: new UsuarioController().createUsuario(con);
                            break;
                    case 2: new PostController().createPost(con);
                            break;
                    case 3: new UsuarioController().listarUsuario(con);
                            break;
                    case 4: new PostController().listarPosts(con);
                            break;
                    //case 5: new PostController().listarMedicosAmbulatorios(con);
                     //       break;
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<6);  
        con.close();
    }    
    
    private static int menu() {
        System.out.println("");
        System.out.println("Informe o número da opção que desejas executar: ");
        System.out.println("1 - Inserir um novo Usuário");
        System.out.println("2 - Inserir um novo Post");
        System.out.println("3 - Exibir todos os Usuários");
        System.out.println("4 - Exibir todos os Posts");
        System.out.println("5 - Exibir todos os médicos e seus respectivos ambulatórios");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
