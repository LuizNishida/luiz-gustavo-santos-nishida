package udemy;

public class cursoteste {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("José");
        Aluno aluno2 = new Aluno("Luiz");
        Aluno aluno3 = new Aluno("joão");

        Curso curso1 = new Curso("Java Completo");
        Curso curso2 = new Curso("Programação Web");
        Curso curso3 = new Curso("Python Completo");

        curso1.adicionarAluno(aluno3);
        curso1.adicionarAluno(aluno2);
        curso1.adicionarAluno(aluno1);

        System.out.println(curso1.alunos.size());

        for(Aluno aluno : curso1.alunos){
            System.out.println("Estou matriculado no curso " + curso1.nome + " e meu nome é " + aluno.nome);
        }
        
        Curso cursoencontrado = aluno1.obterCursopornome("Java Completo");

        if(cursoencontrado != null){
            System.out.println(cursoencontrado.nome);
            System.out.println(cursoencontrado.alunos);
        }else{
            System.out.println("Curso não encontrado");
        }
        Aluno alunoe = curso1.obteralunopornome("luiz");

        if(alunoe != null){
            System.out.println(alunoe.nome);
            System.out.println(alunoe.cursos);
        }
    }
}
