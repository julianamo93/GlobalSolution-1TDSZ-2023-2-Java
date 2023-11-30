package br.com.ayucare.www.classes;

public class ProfissionalSaude extends Usuario {
    private String experiencia;
    private String especialidade;

    public ProfissionalSaude() {
    }

    public ProfissionalSaude(String experiencia, String especialidade) {
        this.experiencia = experiencia;
        this.especialidade = especialidade;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    //para o profissional de saúde poder acessar dados do paciente
    public void acessarPaciente(Paciente paciente) {
        String informacoesPaciente = paciente.fornecerInformacoes();
        System.out.println("Informações do paciente:\n" + informacoesPaciente);
    }

}
