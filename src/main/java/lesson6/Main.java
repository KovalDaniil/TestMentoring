package lesson6;

public class Main {

    public static String oddNumberCheck(int number){
        if(number % 2 != 0){
            return "Number is odd";
        } else
            return "Number is not odd";
    };

    public boolean checkDivision(int number){
        return (number%3==0) && (number%5==0);
    }

    public static void main(String[] args) {
        System.out.println(oddNumberCheck(2)); // Проверка числа 2
        System.out.println(oddNumberCheck(5)); // Проверка числа 5

        Main mainInstance = new Main(); // Создаем объект класса Main
        System.out.println(mainInstance.checkDivision(15)); // Вызов нестатичного метода checkDivision через объект
    }
}

class Person{
   private String name; // объявил поля
   private int age; // объявил поля

    // cоздать конструктор класса
   public Person(String name, int age){
       this.name = name;
       this.age = age;
   }
}
