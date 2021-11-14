import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> aluno1 = new HashMap<>();

        aluno1.put("Nome", "João");
        aluno1.put("Idade", "17");
        aluno1.put("Media", "8.5");
        aluno1.put("Turma", "3a");

        System.out.println(aluno1);

        System.out.println(aluno1.keySet());
        System.out.println(aluno1.values());

        List<Map<String, String>> listaAlunos = new ArrayList<>();

        listaAlunos.add(aluno1);

        Map<String, String> aluno2 = new HashMap<>();

        aluno2.put("Nome", "Maria");
        aluno2.put("Idade", "18");
        aluno2.put("Media", "8.9");
        aluno2.put("Turma", "3b");

        listaAlunos.add(aluno2);

        System.out.println(listaAlunos);

        System.out.println(aluno1.containsKey("Nome"));

    }




}
