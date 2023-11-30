import br.com.ayucare.www.classes.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Principal {

    public static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Random randId = new Random();

        int opcao;

        do {
            String opcaoStr = JOptionPane.showInputDialog(
                    """
                            ==> Boas vindas a AyuCare <==
                            [1] - Paciente
                            [2] - Profissional de Saúde
                            [3] - Login
                            [4] - Planos de Saúde
                            [5] - Sair
                            Digite a opção desejada:"""
            );

            opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1: {
                    JOptionPane.showMessageDialog(null, "==> CADASTRO DE PACIENTE <==");
                    Usuario user = new Usuario();

                    String nome = JOptionPane.showInputDialog("Digite o seu nome:");
                    user.setNome(nome);

                    String sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome:");
                    user.setSobrenome(sobrenome);

                    String dataNascimentoStr = JOptionPane.showInputDialog("Digite sua data de nascimento (YYYY-MM-DD):");
                    LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
                    user.setDataNasc(dataNascimento);

                    String endereco = JOptionPane.showInputDialog("Digite seu endereço completo:");
                    user.setEndereco(endereco);

                    String telefone = JOptionPane.showInputDialog("Digite seu telefone de contato:");
                    user.setTelefoneContato(telefone);

                    String email = JOptionPane.showInputDialog("Digite seu e-mail:");
                    user.setEmail(email);

                    String senha = JOptionPane.showInputDialog("Digite uma senha para seu login:");
                    user.setSenha(senha);

                    int idade = calcularIdade(user.getDataNasc());

                    String planoRecomendado = recomendarPlano(idade);

                    JOptionPane.showMessageDialog(null,
                            "\t\nDe acordo com sua idade, recomendaremos o plano mais adequado a você.\n" +
                                    "Plano recomendado: \t" + planoRecomendado + "\n");

                    user.setId(gerarId(randId));
                    usuarios.add(user);

                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(null, "==> CADASTRO DE PROFISSIONAL DE SAÚDE <==");
                    ProfissionalSaude user = new ProfissionalSaude();

                    String nome = JOptionPane.showInputDialog("Digite o seu nome:");
                    user.setNome(nome);

                    String sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome:");
                    user.setSobrenome(sobrenome);

                    String especialidade = JOptionPane.showInputDialog("Qual sua especialidade:");
                    user.setEspecialidade(especialidade);

                    String experiencia = JOptionPane.showInputDialog("Descreva sua experiência:");
                    user.setExperiencia(experiencia);

                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso! Aguarde agendamentos de consultas.");

                    user.setId(gerarId(randId));
                    usuarios.add(user);
                    break;
                }
                case 3: {
                    JOptionPane.showMessageDialog(null, "==> LOGIN <==");
                    String emailInput = JOptionPane.showInputDialog("Digite seu usuário:");
                    String senhaInput = JOptionPane.showInputDialog("Digite sua senha:");

                    boolean loginSucesso = false;
                    for (Usuario user : usuarios) {
                        String userEmailInput = user.getEmail();
                        String userSenhaInput = user.getSenha();

                        boolean emailInputConfere = emailInput.equals(userEmailInput);
                        boolean senhaInputConfere = senhaInput.equals(userSenhaInput);

                        if (emailInputConfere && senhaInputConfere) {
                            //Login feito com sucesso!
                            loginSucesso = true;
                            usuarioLogado = user;
                            break;
                        }
                    }
                    if (!loginSucesso) {
                        JOptionPane.showInputDialog(null, "E-mail/senha incorretos!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Login feito com sucesso! Boas vindas, " + usuarioLogado.getNome() + "!");
                        homePage();
                    }
                    break;
                }
                case 4: {
                    JOptionPane.showMessageDialog(null, "==> PLANOS DE SAÚDE <==");

                    String escolhaStr = JOptionPane.showInputDialog(
                            """
                                    Planos de Saúde Disponíveis:
                                    A - Plano Standart
                                    B - Plano Classic
                                    C - Plano Pro+"""
                    );

                    char escolha = escolhaStr.toUpperCase().charAt(0);

                    if (escolha == 'A') {
                        JOptionPane.showMessageDialog(null, "O Plano Basic é composto pelo pacote essencial de saúde.");
                    } else if (escolha == 'B') {
                        JOptionPane.showMessageDialog(null, "O Plano Classic é o mais escolhido pela maioria das famílias.");
                    } else if (escolha == 'C') {
                        JOptionPane.showMessageDialog(null, "O Plano Pro+ é especialmente para a melhor idade.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha entre as opções do menu.");
                    }
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;
                }
                default:
                    JOptionPane.showInputDialog("Opção inválida.");
            }
        } while (opcao != 5);
    }

    public static void homePage() {
        ArrayList<Prontuario> prontuarios = new ArrayList<>();
        ArrayList<Atendimento> atendimentos = new ArrayList<>();
        Usuario usuario = new Usuario();

        boolean rodando = true;
        while (rodando) {

            int opcao;
            String opcaoStr = JOptionPane.showInputDialog(
                    """
                            ==> HOME AyuCare <==
                            [1] - Cadastrar Prontuário Médico
                            [2] - Mostrar Prontuário Médico
                            [3] - Adquirir Plano de Saúde
                            [4] - Agendar Consulta
                            [5] - Meus Agendamentos
                            [6] - Logout
                            Digite a opção desejada:"""
            );
            opcao = Integer.parseInt(opcaoStr);

            switch(opcao) {
                case 1: {
                    JOptionPane.showMessageDialog(null, "==> CADASTRO DE PRONTUÁRIO MÉDICO <==");
                    Prontuario ficha = new Prontuario();

                    String genero = JOptionPane.showInputDialog("Registre aqui seu gênero (FEMININO ou MASCULINO:");
                    ficha.setGenero(genero);

                    String prescricao = JOptionPane.showInputDialog("Registre suas prescrições médicas:");
                    ficha.setPrescricao(prescricao);

                    String observacao = JOptionPane.showInputDialog("Registre observações (se não tiver, digite 'NÃO'):");
                    ficha.setObservacao(observacao);

                    String anormalidades = JOptionPane.showInputDialog("Registre as anormalidades (se não tiver, digite 'NÃO'):");
                    ficha.setAnormalidades(anormalidades);

                    String tratamento = JOptionPane.showInputDialog("Registre tratamentos que você faz (ou já fez):");
                    ficha.setTratamento(tratamento);

                    String diagnostico = JOptionPane.showInputDialog("Registre aqui diagnósticos médicos:");
                    ficha.setDiagnostico(diagnostico);

                    JOptionPane.showMessageDialog(null, "Prontuário médico registrado com sucesso.");

                    prontuarios.add(ficha);

                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(null, "==> PRONTUÁRIO MÉDICO <==");
                    for (Prontuario ficha : prontuarios) {
                        ficha.exibeProntuario(usuario);
                    }
                    break;
                }
                case 3: {
                    JOptionPane.showMessageDialog(null, "==> PLANOS DE SAÚDE <==");
                    PlanoSaude planoSaude = new PlanoSaude();
                    planoSaude.adquirirPlano();
                    planoSaude.exibirDetalhes();
                    break;
                }
                case 4: {
                    JOptionPane.showMessageDialog(null, "==> AGENDAMENTO DE CONSULTAS <==");
                    Atendimento agendamento = new Atendimento();
                    agendamento.agendarConsulta();

                    atendimentos.add(agendamento);

                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(null, "==> MEUS AGENDAMENTOS <==");
                    StringBuilder agendamentosStr = new StringBuilder();
                    for (Atendimento agendamento : atendimentos) {
                        agendamentosStr.append(agendamento.toString()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, agendamentosStr.toString());
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(null, "Logout...");
                    rodando = false;
                    break;
                }
            }
        }
    }

    private static int gerarId(Random randId) {
        return randId.nextInt(9000) + 1000; // Gera um número aleatório entre 1000 e 9999
    }

    public static int calcularIdade(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        return dataAtual.getYear() - dataNascimento.getYear();
    }

    public static String recomendarPlano(int idade) {
        if (idade <= 30) {
            return "Plano Basic";
        } else if (idade < 50) {
            return "Plano Classic";
        } else {
            return "Plano Pro+";
        }
    }

}