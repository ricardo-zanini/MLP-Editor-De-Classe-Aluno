package Classes;

import Alert.UserAlert;
import java.time.LocalDate;

public class Aluno extends Pessoa{
    private Niveis nivel;
    private String matricula;

    public enum Niveis {

        INDEFINIDO("INDEFINIDO"),
        GRADUACAO("GRADUACAO"),
        ESPECIALIZACAO("ESPECIALIZAÇÃO"),
        MESTRADO("MESTRADO"),
        DOUTORADO("DOUTORADO");

        private final String descricao;

        Niveis(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public Aluno(){
        setNome("Indefinido");
        setGenero(Generos.INDEFINIDO);
        setDataNascimento(LocalDate.now());

        this.nivel = Niveis.INDEFINIDO;
        this.matricula = "000000";

        UserAlert userAlert = new UserAlert("Classe Aluno Instânciada!");
    }

    public Aluno(String nomeR, Generos generoR, LocalDate dataNascimentoR, Niveis nivelR, String matriculaR){

        setNome(nomeR.compareTo("") == 0 ? "Indefinido" : nomeR);
        setGenero(generoR);
        setDataNascimento(dataNascimentoR);

        this.nivel = nivelR == null ? Niveis.INDEFINIDO : nivelR;
        if(matriculaR.length() < 6){
            String aux = matriculaR;
            for(int k = 0; k < (6 - matriculaR.length()); k++){
                aux = aux.concat("0");
            }
            matriculaR = aux;
        }else if(matriculaR.length() > 6){
            matriculaR = matriculaR.substring(0,6);
        }
        this.matricula = matriculaR.compareTo("") == 0 ? "000000" : matriculaR;

        UserAlert userAlert = new UserAlert("Classe Aluno Instânciada!");
    }

    public void printAluno(){
        UserAlert userAlert = new UserAlert(String.format(
            "Dados:\n - Nome - %s,\n - Genero - %s,\n - Nascimento - %s,\n - Nivel - %s,\n - Matricula - %s",
            getNome(),
            getGenero().getDescricao(),
            getDataNascimento().toString(),
            this.nivel.getDescricao(),
            this.matricula
        )); 
    }

    public Niveis getNivel() {
        return nivel;
    }
    public void setNivel(Niveis nivel) {
        this.nivel = nivel;
    }


    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
