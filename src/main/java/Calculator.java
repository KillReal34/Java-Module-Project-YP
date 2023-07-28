import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {
    int persons;
    float price;
    String name;

    int countingPersons(){
        try {
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
        LinkedList<Product> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String exit = "ЗАВЕРШИТЬ";
        int persons = countingPersons();
        float sum = 0;

        System.out.println("Введите название товара и его стоимость в формате: \n[Наименование]\n" +
                "[руб,коп]" +
                "\nВведите 'Завершить' для того, чтобы завершить процесс добавления товаров.");

        while (true) {
            name = scanner.next();

            if (name.equalsIgnoreCase(exit)) {
                sum = sum / persons;
                String sumProduct = "%.2f";
                Converter converter = new Converter(sum);

                System.out.println("Добавленные товары:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).name + " " + list.get(i).price);
                }
                System.out.println("Каждый должен заплатить: " + String.format(sumProduct, sum)
                        + " " + converter.check());
                break;
            }

            while (true) {
                try {
                    price = scanner.nextFloat();
                    if (price <= 0) {
                        System.out.println("Вы ввели некорректную сумму товара! Попробуйте ввести сумму товара снова.");
                    }
                    else{
                        break;
                    }
                }
                catch (InputMismatchException e){
                    System.out.println("Вы ввели некорректный символ вместо числа или ввели некоректное число.");
                    countingProducts();
                }
            }
            Product product = new Product(name, price);

            list.add(product);

            sum = (sum + product.price);

            System.out.println("Товар успешно добавлен! Хотите добавить ещё один товар?" +
                    "\nИли введите 'Завершить', чтобы завершить процесс добавления товаров.");
        }
    }
}


