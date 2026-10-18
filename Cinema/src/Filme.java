public class Filme {

    private final String titulo;
    private final int duracao;
    private final int classificacao;
    private String categoria;
    private String sinopse;

    public Filme(String titulo, int duracao, int classificacao) {
        this.titulo = titulo;

        if(duracao > 0) {
            this.duracao = duracao;
        } else {
            this.duracao = 90;
        }

        if(classificacao > 0) {
            this.classificacao = classificacao;
        } else {
            this.classificacao = 0;
        }

        this.categoria = "Ação";
        this.sinopse = "Não Informada!";
    }

    public Filme(String titulo, int duracao) {

        this.titulo = titulo;

        if(duracao > 0) {
            this.duracao = duracao;
        } else {
            this.duracao = 90;
        }

        this.classificacao = 0;
        this.categoria = "Ação";
        this.sinopse = "Não informada!";
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        if(!sinopse.isBlank()) {
            this.sinopse = sinopse;
        }
    }

    public boolean alterarCategoria(String novaCategoria) {

        if(novaCategoria == null || novaCategoria.isBlank()) {
            return false;
        }

        String[] categoriasValidas = {"AÇÃO", "AVENTURA", "COMÉDIA", "DRAMA", "TERROR"};

        String categoriaFormatada =  novaCategoria.toUpperCase().trim();

        for(String cat: categoriasValidas) {
            if(cat.equals(categoriaFormatada)) {
                this.categoria = novaCategoria;
                return true;
            }
        }

        return false;
    }

    public boolean podeAssistir(int idade) {

        if (idade < 0) {
            return false;
        }

        return idade >= classificacao;
    }
}
