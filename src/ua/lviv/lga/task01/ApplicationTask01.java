/*
 *LOGOS IT Academy test exception
 */
package ua.lviv.lga.task01;


import java.util.Scanner;

/**
 * @author Nataliia
 * @version 1.1  09 January 2024
 * @since java 1.8
 */

public class ApplicationTask01 {
    /**
     * @param no imput param
     * @return null
     * @throws WrongInputConsoleParametersException
     * @author Nataliia
     */


    /* Display the menu on the screen   */
    static void menu() {
        System.out.println();
        System.out.println("Щоб перевірити, чи є такий місяць, натисніть 1");
        System.out.println("Щоб вивести всі місяці пори року, натисніть 2");
        System.out.println("Щоб вивести всі місяці з певною кількістю днів, натисніть 3");
        System.out.println("Щоб вивести всі місяці з меншою кількістю днів, натисніть 4");
        System.out.println("Щоб вивести всі місяці з більшою кількістю днів, натисніть 5");
        System.out.println("Щоб вивести наступну пору року до вказаної, натисніть 6");
        System.out.println("Щоб вивести попередню пору року до вказаної, натисніть 7");
        System.out.println("Щоб вивести всі місяці із парною кількістю днів, натисніть 8");
        System.out.println("Щоб вивести всі місяці із непарною кількістю днів, натисніть 9");
        System.out.println("Щоб перевірити введений місяць на парність днів, натисніть 10");
        System.out.println();
    }

    public static void main(String[] args) throws WrongInputConsoleParametersException {
        /*reading the entered information*/
        Scanner sc = new Scanner(System.in);

        /*fill arrays with information*/
        Months months[] = Months.values();
        Sesons sesons[] = Sesons.values();

        /*additional variables*/
        String data;
        int data2;
        String message;

        /* processing of entered information */

        while (true) {
            menu();

            int num = -1;
            switch (sc.next()) {
                case "1":
                    System.out.println("Введіть назву місяця");
                    sc = new Scanner(System.in);
                    data = sc.next().toUpperCase();

                    num = getNumMonth(months, data, num);

                    if (num >= 0) System.out.println("Є такий місяць  " + data);

                    break;
                case "2":
                    System.out.println("Введіть назву пори року: ");
                    sc = new Scanner(System.in);
                    data = sc.next().toUpperCase();
                    num = getNumSesons(sesons, data, num);

                    if (num != -1) {
                        System.out.println("Місяці пори року " + data.toString() + " :");
                        for (Months m : months) {
                            if (m.seson.name().equals(data)) {
                                System.out.println(m.name());
                            }

                        }
                    }

                    break;
                case "3":
                    System.out.println("Введіть кількість днів: ");
                    sc = new Scanner(System.in);
                    data2 = sc.nextInt();

                    num = getNumDay(months, data2, num);


                    if (num > -1) {
                        for (Months m : months) {
                            if (m.getDay() == data2) {
                                System.out.println("Місяць " + m.name() + " має " + data2 + " днів");
                            }


                        }
                    }


                    break;
                case "4":
                    System.out.println("Введіть кількість днів: ");
                    sc = new Scanner(System.in);
                    data2 = sc.nextInt();
                    int count = 0;


                    for (Months m : months) {
                        if (m.getDay() < data2) {
                            System.out.println(m.name());
                            count++;
                        }

                    }
                    if (count != 0) System.out.println("Mенше,ніж " + data2 + " днів, мають " + count + " місяців");
                    else System.out.println("Немає місяця з меншою, ніж " + data2 + " днів");

                    break;
                case "5":
                    System.out.println("Введіть кількість днів: ");
                    sc = new Scanner(System.in);
                    data2 = sc.nextInt();
                    count = 0;


                    for (Months m : months) {
                        if (m.getDay() > data2) {
                            System.out.println(m.name());
                            count++;
                        }
                    }
                    if (count != 0) System.out.println("Більше,ніж " + data2 + " днів, мають " + count + " місяців");
                    else System.out.println("Немає місяця з більшою, ніж " + data2 + " днів");

                    break;
                case "6":
                    System.out.println("Введіть назву пори року: ");
                    sc = new Scanner(System.in);
                    data = sc.next().toUpperCase();
                    num = getNumSesons(sesons, data, num);


                    if (num != -1) {
                        if (num == 3) num = -1;
                        System.out.println("Наступною порою року за  " + data + " буде " + sesons[num + 1].name());

                    }

                    break;
                case "7":
                    System.out.println("Введіть назву пори року: ");
                    sc = new Scanner(System.in);
                    data = sc.next().toUpperCase();
                    num = getNumSesons(sesons, data, num);


                    if (num != -1) {
                        if (num == 0) num = 4;
                        System.out.println("Попередньою порою року до  " + data + " була " + sesons[num - 1].name());

                    }

                    break;
                case "8":
                    System.out.println("Парну кількість днів мають такі місяці: ");
                    for (Months m : months) {
                        if (m.day % 2 == 0) {
                            System.out.println(m.name());
                        }
                    }
                    break;
                case "9":
                    System.out.println("Непарну кількість днів мають такі місяці: ");
                    for (Months m : months) {
                        if (m.day % 2 != 0) {
                            System.out.println(m.name());
                        }
                    }
                    break;
                case "10":
                    System.out.println("Введіть назву місяця: ");
                    sc = new Scanner(System.in);
                    data = sc.next().toUpperCase();

                    num = getNumMonth(months, data, num);

                    if (num != -1) {
                        if (months[num].day % 2 == 0)
                            System.out.println("Місяць " + data + " має парну кількість днів");

                        else System.out.println("Місяць " + data + " має непарну кількість днів");
                    }
                    break;


            }
            System.out.println();
        }

    }

    /*checking the entered information for correctness
     * @param  months,  data2
     * @exception  ErrorMessage
     * @author Nataliia
     * @return int element number in the array or  stop on error
     *
     */
    private static int getNumDay(Months[] months, int data2, int num) throws WrongInputConsoleParametersException {
        for (Months m : months) {
            if (m.getDay() == data2) {
                num = m.ordinal();
            }

        }

        if (num < 0) {
            String message = "Немає місяця з такою кількістю днів : " + data2;
            throw new WrongInputConsoleParametersException(message);
        }
        return num;
    }

    /*checking the entered information for correctness
     * @param  sesons,  data2
     * @exception  ErrorMessage
     * @author Nataliia
     * @return int element number in the array or  stop on error
     *
     */
    private static int getNumSesons(Sesons[] sesons, String data, int num) throws WrongInputConsoleParametersException {
        for (Sesons m : sesons) {
            if (m.name().equals(data)) {
                num = m.ordinal();
            }

        }
        if (num < 0) {
            String message = "Немає такої пори року як " + data;
            throw new WrongInputConsoleParametersException(message);
        }


        return num;
    }

    /*checking the entered information for correctness
     * @param  months,  data
     * @exception  ErrorMessage
     * @author Nataliia
     * @return int element number in the array or  stop on error
     *
     */
    private static int getNumMonth(Months[] months, String data, int num) throws WrongInputConsoleParametersException {
        for (Months m : months) {
            if (m.name().equals(data)) {
                num = m.ordinal();
            }
        }
        if (num < 0) {
            String message = "Немає такого місяця як " + data;
            throw new WrongInputConsoleParametersException(message);
        }


        return num;
    }
}

