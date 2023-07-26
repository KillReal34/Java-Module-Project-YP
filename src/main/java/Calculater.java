import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Calculater {

    int countingPersons(){
        try {
            int persons;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Введите количество человек");
                persons = scanner.nextInt();

                if (persons < 1) {
                    System.out.println("Вы ввели некорректное число человек");
                } else {
                    return persons;
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("Вы ввели некорректный символ вместо числа. Введите данные заново");
            return countingPersons();
        }
    }
    void countingProducts(){
        try {
            LinkedList<String> list = new LinkedList<>();
            Scanner scanner = new Scanner(System.in);
            String exit = "ЗАВЕРШИТЬ";
            int persons = countingPersons();
            double sum = 0;

            System.out.println("Введите название товара и его стоимость" +
                    "\nВведите 'Завершить' для того, чтобы завершить процесс добавления товаров.");

            while (true) {
                String name = scanner.next();

                if (name.equalsIgnoreCase(exit)) {
                    sum = sum / persons;
                    String sumProduct = "%.2f";
                    Converter converter = new Converter(sum);

                    System.out.println("Добавленные товары:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }

                    System.out.println("Каждый должен заплатить: " + String.format(sumProduct, sum)
                            + " " + converter.check());
                    break;
                }

                float price = scanner.nextFloat();

                list.add(name);

                sum = (sum + price);

                System.out.println("Товар успешно дабавлен! Хотите добавить ещё один товар?" +
                        "\nИли введите 'Завершить', чтобы завершить процесс добавления товаров.");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Вы ввели некорректный символ вместо числа. Введите данные заново");
            countingProducts();
        }
    }
}

class Converter{
    double count;

    Converter(double count){
        this.count = count;
    }

    String check(){
        if (count <= 1){
            return "рубль";
        }
        else if(count % 2 == 0 || count % 3 == 0 || count % 4 == 0){
            return "рубля";
        }
        else{
            return "рублей";
        }
    }
}
