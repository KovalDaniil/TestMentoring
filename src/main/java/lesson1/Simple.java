package lesson1;

import static java.lang.Math.sqrt;

public class Simple {

    /**
     * Пример
     * <p>
     * Вычисление квадрата целого числа
     */
    public static int sqr(int x) {
        return x * x;
    }


    /**
     * Пример
     * <p>
     * Вычисление квадрата вещественного числа
     */
    public static double sqr(double x) {
        return x * x;
    }


    /**
     * Пример
     * <p>
     * Вычисление дискриминанта квадратного уравнения
     */
    public static double discriminant(double a, double b, double c) {
        return sqr(b) - (double) 4 * a * c;
    }


    /**
     * Пример
     * <p>
     * Поиск одного из корней квадратного уравнения
     */
    public static double quadraticEquationRoot(double a, double b, double c) {
        double var10000 = -b;
        double var6 = discriminant(a, b, c);
        return (var10000 + sqrt(var6)) / ((double) 2 * a);
    }


    /**
     * Пример
     * <p>
     * Поиск произведения корней квадратного уравнения
     */
    public static double quadraticRootProduct(double a, double b, double c) {
        double x1 = discriminant(a, b, c);
        double sd = sqrt(x1);
        x1 = (-b + sd) / ((double) 2 * a);
        double x2 = (-b - sd) / ((double) 2 * a);
        return x1 * x2;
    }


    /**
     * Пример главной функции
     * Можно попробовать её запустить по кнопке Play рядом с названием функции
     */
    public static void main(String[] args) {
        double x1x2 = quadraticRootProduct(1.0, 13.0, 42.0);
        String var3 = "Root product: " + x1x2;
        System.out.println(var3);
    }


    /**
     * Тривиальная
     * <p>
     * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
     * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
     */
    public static int seconds(int hours, int minutes, int seconds) {
        return (hours * 60 * 60) + (minutes * 60) + seconds;
    }


    /**
     * Тривиальная
     * <p>
     * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
     * Определить длину того же отрезка в метрах (в данном случае 18.98).
     * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
     */
    public static double lengthInMeters(int sagenes, int arshins, int vershoks) {
        double vershoksLength = 4.445;
        double sagenesToVershoks = 48 * sagenes;
        double arshinsToVershoks = 16 * arshins;
        double vershoksSum = vershoks;

        double totalLengthInCm = (sagenesToVershoks + arshinsToVershoks + vershoksSum) * vershoksLength;
        return totalLengthInCm / 100;
    }

    /**
     * Тривиальная
     * <p>
     * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
     * Вывести значение того же угла в радианах (например, 0.63256).
     */
    public static double angleInRadian(int grad, int min, int sec) {
        final double p314 = Math.PI;
        // объявил константу пи и по формуле вывел значение угла в радианах
        return (grad * (p314 / 180) + min * (p314 / (180 * 60)) + sec * (p314 / (180 * 60 * 60)));
    }

    /**
     * Тривиальная
     * <p>
     * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
     * Например, расстояние между (3, 0) и (0, 4) равно 5
     */
    public static double trackLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


    /**
     * Простая
     * <p>
     * Пользователь задает целое число, большее 100 (например, 3801).
     * Определить третью цифру справа в этом числе (в данном случае 8).
     */
    public static int thirdDigit(int number) {
        // Преобразуем число в строку
 //        String strFromNumber = String.valueOf(number);
        // Проверяем, что длина строки хотя бы 3
 //       if (strFromNumber.length() < 3) {
 //           throw new IllegalArgumentException("Число должно быть больше 100, чтобы иметь третью цифру справа.");
 //       }
        // Получаем третий символ справа и преобразуем в целое число
 //      char thirdDigit = strFromNumber.charAt(strFromNumber.length() - 3);
        // Преобразуем символ в цифру и возвращаем её
 //       return Character.getNumericValue(thirdDigitChar);
 Object
        return (number / 100) % 10;
    }


    /**
     * Простая
     * <p>
     * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
     * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
     * Определите время поезда в пути в минутах (в данном случае 216).
     */
    public static int travelMinutes(int hoursDepart, int minutesDepart, int hoursArrive, int minutesArrive) {
        int departureTime = hoursDepart * 60 + minutesDepart;
        int arrivalTime = hoursArrive * 60 + minutesArrive;
        return arrivalTime-departureTime;
    }


    /**
     * Простая
     * <p>
     * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
     * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
     * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
     */
    public static double accountInThreeYears(int initial, int percent) {
        return initial * Math.pow((1 + (double) percent / 100), 3);
    }


    /**
     * Простая
     * <p>
     * Пользователь задает целое трехзначное число (например, 478).
     * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
     */
    public static int numberRevert(int number) {
        // Преобразуем число в строку
        String numberStr = Integer.toString(number);

        // Перевернем строку
        String reversedStr = new StringBuilder(numberStr).reverse().toString();

        // Преобразуем обратно в целое число
        return Integer.parseInt(reversedStr);

        //TODO переделать без строк
    }
}