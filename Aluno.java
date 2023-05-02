package udemy;
import java.util.*;

public class Aluno {
    String nome;
ArrayList<Curso> cursos = new ArrayList<>();  

Aluno(String nome){
    this.nome = nome;
}
Curso obterCursopornome(String nome){
    for(Curso curso: this.cursos){
        if(curso.nome.equalsIgnoreCase(nome)){
            return curso;
        }

    }
    return null;
}
void adicionarCurso(Curso curso){

    this.cursos.add(curso);
    curso.alunos.add(this);
}
public String toString(){
return "O meu nome é " + nome;
}
}
