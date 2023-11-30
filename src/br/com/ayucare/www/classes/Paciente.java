package br.com.ayucare.www.classes;

public class Paciente extends Usuario {
    private String genero;

    public Paciente(){
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void exibeProntuario() {
    }

    public String fornecerInformacoes() {
        return "Nome: " + getNome() + getSobrenome() +
                "\nData de Nascimento: " + getDataNasc() +
                "\nContato: " + getTelefoneContato() +
                "\nE-mail: " + getEmail();

    }
}
