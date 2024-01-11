package ua.lviv.lga.task02;

public class MyException extends Exception {
    private String mes;

    public MyException(String mes) {
        super(mes);
        this.mes = mes;
    }

    public String getMessage() {
        return mes;
    }
}
