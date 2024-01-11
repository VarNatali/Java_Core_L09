package ua.lviv.lga.task02;

public class Methods {
    private double a;
    private double b;

    public Methods(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void checkingVariables() throws MyException, IllegalAccessException {
        if (this.a < 0 && this.b < 0) {
            throw new IllegalArgumentException();
        }
        if ((this.a == 0 && this.b != 0) || (this.a != 0 && this.b == 0)) {
            throw new ArithmeticException();
        }
        if (this.a == 0 && this.b == 0) {
            throw new IllegalAccessException();
        }
        if (this.a > 0 && this.b > 0) throw new MyException("Результату чомусь немає");

    }

    double add() {

        return (this.a + this.b);
    }

    double minus() {

        return (this.a - this.b);
    }

    double multiplication() {

        return (this.a * this.b);

    }

    double divide() {
        return (this.a / this.b);

    }

}
