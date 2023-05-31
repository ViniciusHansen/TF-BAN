/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class UsuarioBean {
    private String username;
    private String nome;
    private String biografia;

    public UsuarioBean(String username, String nome, String biografia){
        this.username = username;
        this.nome = nome;
        this.biografia = biografia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "UsuarioBean{" +
                "username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", biografia='" + biografia + '\'' +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}