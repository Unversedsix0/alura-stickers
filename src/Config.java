import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Config {
    public static String apiKey() throws FileNotFoundException {
        StringBuilder conteudo = new StringBuilder();
        File arquivo = new File("./config.txt");
        try {
            Scanner leitor = new Scanner(arquivo);
            while (leitor.hasNextLine()) {
                conteudo.append(leitor.nextLine());
                conteudo.append(System.lineSeparator());
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }

         return conteudo.toString();
    }
}
