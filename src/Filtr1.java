import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Filtr1
{
    private LinkedList<String> słowaZabronione;

    public Filtr1(LinkedList<String> słowaZabronione)
    {
        this.słowaZabronione = słowaZabronione;
    }

    public void filtrujIOdwróć(String fileIn, String fileOut) throws IOException, ZłeSłowoException
    {
        LinkedList<String> result = new LinkedList<>();
        try(Scanner reader = new Scanner(new File(fileIn)))
        {
            int wordCount = 0;
            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                for(String słowo : line.split("\\s"))
                {
                    if (słowaZabronione.contains(słowo))
                    {
                        throw new ZłeSłowoException(słowo, wordCount);      //zwrócenie wyjątku
                    }
                    else
                    {
                        result.add(słowo);
                    }
                    wordCount++;
                }
            }
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut)))    //budowa odwróconej listy
        {
            for (int i = result.size() - 1; i >= 0; i--)
            {
                writer.append(result.get(i)).append(" ");
            }
        }
    }
}
