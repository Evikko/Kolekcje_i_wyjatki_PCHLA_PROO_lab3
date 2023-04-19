public class ZłeSłowoException extends Exception
{
    private String problematyczneSłowo;
    private int pozycjaSłowa;

    public ZłeSłowoException(String problematyczneSłowo, int pozycjaSłowa)  //sprawdza wystąpienie problematycznych słów i pozycję wystąpienia wyjątku
    {
        this.problematyczneSłowo = problematyczneSłowo;
        this.pozycjaSłowa = pozycjaSłowa;
    }
    @Override
    public String getMessage()
    {
        return "Wystąpił nieoczekiwany błąd w słowie nr " + pozycjaSłowa + ", złe słowo to: " + problematyczneSłowo;    //wiadomość dla użytkownika
    }
}
