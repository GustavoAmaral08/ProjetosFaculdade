import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Filme filme1 = new Filme("Spider-Man", 90);
        Filme filme2 = new Filme("Nuremberg", 180, 18, "Ação");
        Filme filme3 = new Filme("Interstellar", 169, 10, "Drama");

        LocalDateTime horarioSessao1 = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 30));
        LocalDateTime horarioSessao2 = LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 00));
        LocalDateTime horarioSessao3 = LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 30));
        LocalDateTime horarioSessao4 = LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 30));
        LocalDateTime horarioSessao5 = LocalDateTime.of(LocalDate.now(), LocalTime.of(07, 30));

        Sessao sessao1 = new Sessao("1A2345B", filme1, horarioSessao1, 2);
        Sessao sessao2 = new Sessao("1A2345C", filme1, horarioSessao2);
        Sessao sessao3 = new Sessao("1A2345D", filme2, horarioSessao3);
        Sessao sessao4 = new Sessao("1A2345E", filme2, horarioSessao4, 100);
        Sessao sessao5 = new Sessao("1A2345G", filme3, horarioSessao5, 75);

        menuPrincipal(sc, filme1, filme2, filme3, sessao1, sessao2, sessao3, sessao4, sessao5);
    }

    public static void menuPrincipal(Scanner sc, Filme spiderMan, Filme nuremberg, Filme interstellar, Sessao sessao1, Sessao sessao2, Sessao sessao3, Sessao sessao4, Sessao sessao5) {

        int opcao = 0;

        do {

            System.out.println("========================================");
            System.out.println("            MENU PRINCIPAL              ");
            System.out.println("========================================");
            System.out.println("1- Gerenciar Filmes");
            System.out.println("2- Gerenciaer sessões e vender ingressos");
            System.out.println("3- Consultar e atualizar informaçoes do cinema");
            System.out.println("0- Sair");

            System.out.println("Informe a opção desejada:");
            opcao = sc.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    gerenciarFilmes(sc, spiderMan, nuremberg, interstellar);
                    break;
                case 2:
                    gerenciarSessao(sc,sessao1, sessao2, sessao3, sessao4, sessao5);
                    break;
                case 3:
                    gerenciarInformacao(sc, sessao1, sessao2, sessao3, sessao4, sessao5);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }


    public static void gerenciarFilmes(Scanner sc, Filme spiderMan, Filme nuremberg, Filme interstellar) {

        int opcao = 0;
        System.out.println("1- " + spiderMan.getTitulo());
        System.out.println("2- " + nuremberg.getTitulo());
        System.out.println("3- " + interstellar.getTitulo());

        System.out.println("Informe a opção desejada:");
        opcao = sc.nextInt();
        System.out.println();

        switch (opcao) {
            case 1:
                subMenuFilmes(sc, spiderMan);
                break;

            case 2:
                subMenuFilmes(sc, nuremberg);
                break;

            case 3:
                subMenuFilmes(sc, interstellar);
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void subMenuFilmes(Scanner sc, Filme filme) {

        int opcao = 0;

        do {
            System.out.println("1 - Consultar os dados do filme");
            System.out.println("2 - Alterar a categoria");
            System.out.println("3 - Alterar a sinopse");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("========================================");
                    System.out.println("            DADOS DO FILME              ");
                    System.out.println("========================================");
                    System.out.println("Título: " + filme.getTitulo());
                    System.out.println("Duração: " + filme.getDuracao());
                    if(filme.getClassificacao() == 0) {
                        System.out.println("Classificação: Livre");
                    } else {
                        System.out.println("Classificação: " + filme.getClassificacao());
                    }
                    System.out.println("Categoria: " + filme.getCategoria());
                    System.out.println("Sinopse: " + filme.getSinopse());
                    System.out.println("========================================");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Categirias disponíveis: Ação, Aventura, Comédia, Drama, Terror");
                    System.out.println("Digite a nova categoria: ");
                    String novaCategoria = sc.nextLine();

                    boolean resultado = filme.alterarCategoria(novaCategoria);

                    if (resultado == true) {
                        System.out.println("Categoria trocada com sucesso!");
                    } else {
                        System.out.println("Categoria inválida!");
                    }

                    System.out.println();

                    break;

                case 3:
                    System.out.println("Informe a nova sinopse: ");
                    String sinopse = sc.nextLine();

                    filme.setSinopse(sinopse);

                    System.out.println();

                    break;

                case 0:
                    System.out.println("Voltando para o menu principal...");
                    System.out.println();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    System.out.println();
                    break;
            }
        } while (opcao != 0);
    }

    public static void gerenciarSessao(Scanner sc, Sessao sessao1, Sessao sessao2, Sessao sessao3, Sessao sessao4, Sessao sessao5) {

        int opcao = 0;

        System.out.println("1 - Código: " + sessao1.getCodigo() + " | Filme: " + sessao1.getFilme().getTitulo() + " | Início: " + sessao1.getHorarioInicio());
        System.out.println("2 - Código: " + sessao2.getCodigo() + " | Filme: " + sessao2.getFilme().getTitulo() + " | Início: " + sessao2.getHorarioInicio());
        System.out.println("3 - Código: " + sessao3.getCodigo() + " | Filme: " + sessao3.getFilme().getTitulo() + " | Início: " + sessao3.getHorarioInicio());
        System.out.println("4 - Código: " + sessao4.getCodigo() + " | Filme: " + sessao4.getFilme().getTitulo() + " | Início: " + sessao4.getHorarioInicio());
        System.out.println("5 - Código: " + sessao5.getCodigo() + " | Filme: " + sessao5.getFilme().getTitulo() + " | Início: " + sessao5.getHorarioInicio());
        System.out.println("Informe a sessão desejada: ");
        opcao = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (opcao) {
            case 1:
                submenuSessao(sc, sessao1);
                break;

            case 2:
                submenuSessao(sc, sessao2);
                break;

            case 3:
                submenuSessao(sc, sessao3);
                break;

            case 4:
                submenuSessao(sc, sessao4);
                break;

            case 5:
                submenuSessao(sc, sessao5);
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void submenuSessao(Scanner sc, Sessao sessao) {

        int opcao = 0;

        do {

            System.out.println("1 - Consultar os detalhes da sessão");
            System.out.println("2 - Vender ingresso");
            System.out.println("3 - Mostrar lugares disponíveis");
            System.out.println("4 - Consultar o horário de término");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("Informe a opção desejada:");
            opcao = sc.nextInt();

            sc.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("========================================");
                    System.out.println("          DETALHES DA SESSÃO            ");
                    System.out.println("========================================");
                    System.out.println("Código: " + sessao.getCodigo());
                    System.out.println("Horário de início: " + sessao.getHorarioInicio());
                    System.out.println("Horário de término: " + sessao.consultarHorarioTermino());
                    System.out.println("Capacidade: " + sessao.getCapacidadeMaxima());
                    System.out.println("Ingressos vendidos: " + sessao.getIngressosVendidos());
                    System.out.println("Lugares disponíveis: " + sessao.consultarLugaresDisponiveis());
                    System.out.println("Valor arrecadado: " + sessao.getValorArrecadado());
                    System.out.println("----------------------------------------");
                    System.out.println("DADOS DO FILME:");
                    System.out.println("Filme: " + sessao.getFilme().getTitulo());
                    System.out.println("Duração: " + sessao.getFilme().getDuracao());
                    if(sessao.getFilme().getClassificacao() == 0) {
                        System.out.println("Classificação: Livre");
                    } else {
                        System.out.println("Classificação: " + sessao.getFilme().getClassificacao());
                    }
                    System.out.println("Categoria: " + sessao.getFilme().getCategoria());
                    System.out.println("Sinopse: " + sessao.getFilme().getSinopse());
                    System.out.println("========================================");
                    System.out.println();

                    break;

                case 2:
                    venderIngressos(sessao, sc);
                    break;

                case 3:
                    System.out.println("Lugares disponíveis: " + sessao.consultarLugaresDisponiveis());
                    break;

                case 4:
                    System.out.println("Horário previsto para o término do filme: " + sessao.consultarHorarioTermino());
                    break;
                case 0:
                    System.out.println("Voltando para o menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }while (opcao != 0);
    }

    public static void venderIngressos(Sessao sessao, Scanner sc) {

        System.out.println("========================================");
        System.out.println("           VENDA DE INGRESSOS           ");
        System.out.println("========================================");
        System.out.println("1 - Ingresso Integral");
        System.out.println("2 - Meia Entrada");
        System.out.println("Informe o tipo de ingresso que deseja comprar:");
        int opcao = sc.nextInt();
        sc.nextLine();

        int idade;
        int resultado;

        switch (opcao) {

            case 1:
                System.out.println("Informe a sua idade: ");
                idade = sc.nextInt();

                resultado = sessao.venderIngresso(idade);

                if(resultado == -3) {
                    System.out.println("Compra não realizada. Sem lugar disponível!");
                } else if (resultado == -2) {
                    System.out.println("Compra não realizada. Idade inferior a classificação!");
                } else if (resultado == -1) {
                    System.out.println("Compra não realizada. Idade inválida!");
                } else if (resultado == 1) {
                    System.out.println("Compra do ingresso no valor de: R$ " + Sessao.getValorIngresso() + " realizada com sucesso!");
                }

                break;

            case 2:
                System.out.println("Inforeme a sua idade: ");
                idade = sc.nextInt();
                sc.nextLine();

                System.out.println();
                System.out.println("Informe o documento: ");
                String documento = sc.nextLine();

                resultado = sessao.venderIngresso(idade, documento);

                if(resultado == -3) {
                    System.out.println("Compra não realizada. Sem lugar disponível!");
                } else if (resultado == -2) {
                    System.out.println("Compra não realizada. Idade inferior a classificação!");
                } else if (resultado == -1) {
                    System.out.println("Compra não realizada. Idade ou documento inválido!");
                } else if (resultado == 1) {
                    System.out.println("Compra do ingresso no valor de: R$ " + sessao.getMeiaEntrada() + " realizada com sucesso!");
                }

                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void gerenciarInformacao(Scanner sc, Sessao s1, Sessao s2, Sessao s3, Sessao s4, Sessao s5) {

        int opcao = 0;

        do {
            System.out.println("1 - Consultar o preço integral do ingresso");
            System.out.println("2 - Alterar o preço integral do ingresso");
            System.out.println("3 - Consultar os totais de ingressos vendidos e de arrecadação");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("Informe a opção desejada: ");
            opcao = sc.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println("Valor do ingresso: R$ " + Sessao.getValorIngresso());
                    break;

                case 2:
                    System.out.println("Informe o novo valor: ");
                    double novoValor = sc.nextDouble();

                    boolean resultado = Sessao.alterarValor(novoValor);

                    if(resultado == true) {
                        System.out.println("Valor alterado com sucesso!");
                    } else if (resultado == false) {
                        System.out.println("Valor inválido!");
                    }

                    break;

                case 3:
                    int totalIngressos = s1.getIngressosVendidos() + s2.getIngressosVendidos() + s3.getIngressosVendidos() + s4.getIngressosVendidos() + s5.getIngressosVendidos();
                    double totalArrecadado = s1.getValorArrecadado() + s2.getValorArrecadado() + s3.getValorArrecadado() + s4.getValorArrecadado() + s5.getValorArrecadado();

                    System.out.println("Total de ingressos vendidos: " + totalIngressos);
                    System.out.println("Total arrecadado: R$ " + totalArrecadado);
                    break;

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
