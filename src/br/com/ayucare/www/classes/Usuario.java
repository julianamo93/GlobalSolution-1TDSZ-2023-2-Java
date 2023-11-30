package br.com.ayucare.www.classes;

import java.time.LocalDate;
import java.util.Random;

public class Usuario {
    private int id;
    private String nome;
    private String sobrenome;
    private LocalDate dataNasc;
    private String endereco;
    private String telefoneContato;
    private String email;
    private String senha;

    public Usuario() {
        this.id = gerarId();
    }

    public Usuario(String nome, String sobrenome, LocalDate dataNasc, String endereco, String telefoneContato, String email, String senha) {
        this.id = gerarId();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefoneContato = telefoneContato;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int gerarId() {
        Random rand = new Random();
        return rand.nextInt(9000) + 1000; // Gera um número aleatório entre 1000 e 9999
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = "Rua " + "número " + "bairro " + "cidade " + "CEP: ";
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    //método para definir senha e retornar true para indicar que foi configurada com sucesso
    public boolean setSenha(String senha) {
        this.senha = senha;
        return true; // Retorna true para indicar que a senha foi configurada com sucesso
    }

    //toString para retornar dados do usuário
    public String toString() {
        return "ID: " + this.getId() + "Nome completo: " + this.nome + this.sobrenome + "Plano: " + getNomePlano();
    }

    //String para retornar nome do plano de saúde indicado
    private String getNomePlano() {
        return getNomePlano();
    }
}
