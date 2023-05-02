package udemy;
import java.util.*;

public class Curso {
    String nome;
ArrayList<Aluno> alunos = new ArrayList<>();
Curso(String nome){
    this.nome = nome;
}
Aluno obteralunopornome(String nome){
  for(Aluno aluno: this.alunos){
    if(aluno.nome.equalsIgnoreCase(nome)){
        return aluno;
    }
  }
  return null;
}
void adicionarAluno(Aluno aluno){
    this.alunos.add(aluno);
    aluno.cursos.add(this);
}
public String toString(){
    return nome;
}

}
