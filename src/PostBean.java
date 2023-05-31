/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;

public class PostBean {
    private int id_post;
    private String descricao;
    private String imagem; //caminho imagem
    private String username; // vai ser usado de chave estrangeira

    public PostBean(String descricao, String imagem, String username) {
        this.descricao = descricao;
        this.imagem = imagem;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "PostBean{" +
                "id_post=" + id_post +
                ", descricao='" + descricao + '\'' +
                ", imagem=" + (imagem) +
                '}';
    }
}
