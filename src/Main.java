import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) throws IOException, ZłeSłowoException //wyrzucenie exception IO, ZłeSłowo
    {
        LinkedList<String> słowaZabronione = new LinkedList<>();        //słowa zabronione
        słowaZabronione.add("PCHŁA");
        słowaZabronione.add("PCHAŁA");

        new Filtr(słowaZabronione).filtrujIOdwróć("in.txt", "out.txt"); //filtrowanie słów z pliku i odwrócenie kolejności

        try
        {
            new Filtr1(słowaZabronione).filtrujIOdwróć("in.txt", "out.txt");
        }
        catch (ZłeSłowoException exception)
        {
            System.err.println(exception.getMessage());
        }
        catch (FileNotFoundException exception)
        {
            System.err.println("Nie znaleziono pliku wejściowego");
        }
        catch (IOException exception)
        {
            System.err.println("Wystąpił nieznany wyjątek wejścia/wyjścia");
        }
    }
}
