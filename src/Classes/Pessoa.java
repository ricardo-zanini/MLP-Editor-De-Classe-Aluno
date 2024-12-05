package Classes;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Generos genero;

    public enum Generos {
        INDEFINIDO("INDEFINIDO"),
        HOMEM_CIS("HOMEM CIS"),
        MULHER_CIS("MULHR CIS"),
        NAO_BINARIO("NÃO BINÁRIO"),
        TRANSGENERO("TRANSGÊNERO");

        private final String descricao;

        Generos(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public Pessoa(){
        this.nome = "Indefinido";
        this.dataNascimento = LocalDate.now();
        this.genero = Generos.INDEFINIDO;

        System.out.println("Classe Pessoa Instanciada! \n");
    }

    public Pessoa(String nomeRecebido, Generos generoRecebido, LocalDate dataNascimentoRecebido){
        this.nome = nomeRecebido == null ? "Indefinido" : nomeRecebido;
        this.dataNascimento = dataNascimentoRecebido == null ? LocalDate.now() : dataNascimentoRecebido;
        this.genero = generoRecebido == null ? Generos.INDEFINIDO : generoRecebido;

        System.out.println("Classe Pessoa Instanciada! \n");
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public Generos getGenero() {
        return genero;
    }
    public void setGenero(Generos genero) {
        this.genero = genero;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
