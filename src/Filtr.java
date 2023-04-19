import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Filtr
{
    private LinkedList<String> słowaZabronione;

    public Filtr(LinkedList<String> słowaZabronione)
    {
        this.słowaZabronione = słowaZabronione;
    }

    public void filtrujIOdwróć(String fileIn, String fileOut) throws IOException
    {
        Scanner reader = new Scanner(new File(fileIn));     //skanuje plik in i tworzy wyjscie
        LinkedList<String> result = new LinkedList<>();
        while (reader.hasNextLine())    //wczytywanie pliku linia po linii
        {
            String line = reader.nextLine();        //podział każdej linii na słowa
            for (String słowo : line.split("\\s"))  //oddzielenie słów spacją
            {
                if (!słowaZabronione.contains(słowo))       //filtrowanie słów zabronionych
                {
                    result.add(słowo);
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));    //writer do priku wyjściowego w odwrotnej kolejności
        for (int i = result.size() -1; i >= 0; i--)     //odwraca
        {
            writer.append(result.get(i)).append(" "); //dodaje spację między słowami
        }
        writer.close(); //zamyka writer
    }
}
