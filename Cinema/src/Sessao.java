import java.time.LocalDateTime;

public class Sessao {

    private final String codigo;
    private final Filme filme;
    private final LocalDateTime horarioInico;
    private final int capacidadeMaxima;
    private int ingressosVendidos;
    private double valorArrecadado;
    private static double valorIngresso = 20;

    public Sessao(String codigo, Filme filme, LocalDateTime horarioInico, int capacidadeMaxima) {

        this.codigo = codigo;
        this.filme = filme;
        this.horarioInico = horarioInico;
        if(capacidadeMaxima > 0) {
            this.capacidadeMaxima = capacidadeMaxima;
        } else {
            this.capacidadeMaxima = 50;
        }
        this.ingressosVendidos = 0;
        this.valorArrecadado = 0;
    }

    public Sessao(String codigo, Filme filme, LocalDateTime horarioInico) {
        this.codigo = codigo;
        this.filme = filme;
        this.horarioInico = horarioInico;
        this.capacidadeMaxima = 50;
        this.ingressosVendidos = 0;
        this.valorArrecadado = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public Filme getFilme() {
        return filme;
    }

    public double getMeiaEntrada() {
        return calcularValorVenda(0.5);
    }

    public LocalDateTime getHorarioInico() {
        return horarioInico;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    public static double getValorIngresso() {
        return valorIngresso;
    }

    public int consultarLugaresDisponiveis() {

        int qtdLugarDisponiveis = capacidadeMaxima - ingressosVendidos;

        return qtdLugarDisponiveis;
    }

    public static boolean alterarValor(double novoValor) {

        if(novoValor > 0) {
            valorIngresso = novoValor;
            return true;
        }

        return false;
    }

    private double calcularValorVenda(double percentualDesconto) {
        return valorIngresso * (1.0 - percentualDesconto);
    }

    public int venderIngresso(int idade) {

        if (consultarLugaresDisponiveis() == 0) {
            return -3;
        } else if (idade <= 0) {
            return -1;
        } else if (idade < filme.getClassificacao()) {
            return -2;
        }

        this.ingressosVendidos++;
        this.valorArrecadado += calcularValorVenda(0.0);
        return 1;
    }

    public int venderIngresso(int idade, String documento) {

        if(consultarLugaresDisponiveis() == 0) {
            return -3;
        } else if (idade <=0 || documento == null || documento.isBlank()) {
            return -1;
        } else if (idade < filme.getClassificacao()) {
            return -2;
        }

        this.ingressosVendidos++;
        this.valorArrecadado += calcularValorVenda(0.5);
        return 1;
    }

    public LocalDateTime consultarHorarioTermino() {
        return horarioInico.plusMinutes(filme.getDuracao());
    }
}
