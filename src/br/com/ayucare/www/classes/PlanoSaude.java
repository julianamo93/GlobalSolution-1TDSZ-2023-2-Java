package br.com.ayucare.www.classes;

import javax.swing.JOptionPane;

public class PlanoSaude extends Usuario {
    private String nomePlano;
    private String tipoPlano;
    private String cobertura;
    private String informacoes;
    private String custo;
    private Contrato contrato;

    public PlanoSaude() {
    }

    public PlanoSaude(String nomePlano, String tipoPlano, String cobertura, String informacoes, String custo, Contrato contrato) {
        this.nomePlano = nomePlano;
        this.tipoPlano = tipoPlano;
        this.cobertura = cobertura;
        this.informacoes = informacoes;
        this.custo = custo;
        this.contrato = contrato;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    //método para adquirir Plano de Saúde
    public void adquirirPlano() {
        String escolha = JOptionPane.showInputDialog(
                "Escolha um plano:\n" +
                        "A - Plano Basic\n" +
                        "B - Plano Classic\n" +
                        "C - Plano Pro+"
        );

        //If, else if e else para indicação do plano de saúde
        if (escolha != null) {
            escolha = escolha.toUpperCase();

            if (escolha.equals("A")) {
                nomePlano = "Basic";
                tipoPlano = "Individual ou família, essencial para pacientes com 30 anos ou menos.";
                cobertura = "Cobre 15 consultas ao mês, 10 exames e 02 internações.";
                informacoes = "Possui carência de 02 meses após assinar o contrato.";
                custo = "Parcelas de R$399,00 mensais.";
            } else if (escolha.equals("B")) {
                nomePlano = "Classic";
                tipoPlano = "Individual ou família, essencial para pacientes com mais de 30 anos.";
                cobertura = "Cobre 25 consultas ao mês, 15 exames, 05 internações e quarto individual.";
                informacoes = "Possui car~encia de 06 meses após assinar o contrato.";
                custo = "Parcelas de R$799,00 mensais.";
            } else if (escolha.equals("C")) {
                nomePlano = "Pro+";
                tipoPlano = "Individual ou família, essencial para pacientes na melhor idade.";
                cobertura = "Consultas, exames e internações ilimitados, quarto VIP.";
                informacoes = "Carência de 06 meses após assinar o contrato.";
                custo = "Parcelas de R$2199,00 mensais.";
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada.");
        }
    }

    //método para exibir detalhes do plano escolhido com seus benefícios
    public void exibirDetalhes() {
        JOptionPane.showMessageDialog(null,
                "Detalhes do Plano de Saúde:\n" +
                        "Nome: " + this.nomePlano + "\n" +
                        "Tipo: " + this.tipoPlano + "\n" +
                        "Cobertura: " + this.cobertura + "\n" +
                        "Informações: " + this.informacoes + "\n" +
                        "Custo: " + this.custo + "\n"
        );
    }

    @Override
    public String toString() {
        return "Detalhes do Plano de Saúde:\n" +
                "Nome: " + this.nomePlano + "\n" +
                "Tipo: " + this.tipoPlano + "\n" +
                "Cobertura: " + this.cobertura + "\n" +
                "Informações: " + this.informacoes + "\n" +
                "Custo: " + this.custo + "\n";
    }

    //método para configurar contrato de plano de saúde
    public void configurarContrato(String status, String termos) {
        contrato.setStatus(status);
        contrato.setTermos(termos);
    }
}
