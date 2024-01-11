package ua.lviv.lga.task01;

public class WrongInputConsoleParametersException extends Exception {
    private String mes;

    public WrongInputConsoleParametersException(String mes) {
        super(mes);
        this.mes = mes;
    }

    public String getMessage() {
        return mes;
    }
}
