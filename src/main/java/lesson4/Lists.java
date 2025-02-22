package lesson4;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;
import static lesson1.Simple.discriminant;

public class Lists {

    /**
     * Пример
     * <p>
     * Найти все корни уравнения x^2 = y
     */
    public static List<Double> sqRoots(Double y) {
        if (y < 0) {
            return List.of();
        }

        if (y == 0) {
            return List.of(0.0);
        } else {
            Double root = sqrt(y);
            return List.of(-root, root);
        }
    }

    /**
     * Пример
     * <p>
     * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
     * Вернуть список корней (пустой, если корней нет)
     */
    public static List biRoots(double a, double b, double c) {

        if (a == 0.0) {
            return b == 0.0 ? List.of() : sqRoots(-c / b);
        }
        double d = discriminant(a, b, c);
        if (d < 0.0) {
            return List.of();
        }
        if (d == 0.0) {
            return sqRoots(-b / (2.0 * a));
        }

        double y1 = (-b + Math.sqrt(d)) / (2.0 * a);
        double y2 = (-b - Math.sqrt(d)) / (2.0 * a);
        List<Double> result = new java.util.ArrayList<>(sqRoots(y1));
        result.addAll(sqRoots(y2));
        return result;
    }

    /**
     * Пример
     * <p>
     * Выделить в список отрицательные элементы из заданного списка
     */
    public static List<Integer> negativeList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (Integer element : list) {
            if (element < 0)
                result.add(element);
        }

        return result;
    }

    /**
     * Пример
     * <p>
     * Изменить знак для всех положительных элементов списка
     */
    public static List<Integer> invertPositives(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list);

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) > 0)
                result.set(i, -result.get(i));
        }

        return result;
    }

    /**
     * Пример
     * <p>
     * Из имеющегося списка целых чисел, сформировать список их квадратов
     */
    public static List<Integer> squares(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        list.forEach(it -> result.add(it * it));
        return result;
    }


    /**
     * Пример
     * <p>
     * По заданной строке str определить, является ли она палиндромом.
     * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
     * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
     * Пробелы не следует принимать во внимание при сравнении символов, например, строка
     * "А роза упала на лапу Азора" является палиндромом.
     */
    public static boolean isPalindrome(String str) {

        str = str.toLowerCase().replace(" ", "");

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }

    /**
     * Пример
     * <p>
     * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
     * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
     */
    public static String buildSumExample(List<Integer> list) {

        List<String> stringList = new ArrayList<>();
        int sum = 0;

        for (Integer element : list) {
            stringList.add(element.toString());
            sum = sum + element;
        }

        return String.join(" + ", stringList) + " = " + sum;
    }

    /**
     * Простая
     * <p>
     * Найти модуль заданного вектора, представленного в виде списка v,
     * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
     * Модуль пустого вектора считать равным 0.0.
     */
    public static double abs(List<Double> v) {
        if (v.isEmpty()) {
            return 0.0; // Модуль пустого вектора равен 0.0
        }

        double sum = 0.0; // Переменная для хранения суммы квадратов
        for (double component : v) {
            sum += component * component; // Суммируем квадраты компонентов
        }

        return Math.sqrt(sum); // Возвращаем квадратный корень из суммы квадратов
    }

    /**
     * Простая
     * <p>
     * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
     */
    public static double mean(List<Double> list) {
        if (list.isEmpty()) {
            return 0.0; // Если список пуст, возвращаем 0.0
        }

        double sum = 0.0; // Переменная для хранения суммы элементов
        for (double number : list) {
            sum += number; // Суммируем элементы списка
        }

        return sum / list.size(); // Возвращаем среднее арифметическое
    }


    /**
     * Средняя
     * <p>
     * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
     * Если список пуст, не делать ничего. Вернуть изменённый список.
     * <p>
     * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
     */
    public static List<Double> center(List<Double> list) {
        if (list == null || list.isEmpty()) {
            return list; // Если список пуст или null, ничего не делаем и возвращаем его
        }

        double meanValue = mean(list); // Вычисляем среднее арифметическое
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) - meanValue); // Уменьшаем каждый элемент на среднее
        }

        return list; // Возвращаем измененный список
    }

    /**
     * Средняя
     * <p>
     * Найти скалярное произведение двух векторов равной размерности,
     * представленные в виде списков a и b. Скалярное произведение считать по формуле:
     * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
     */
    public static double times(List<Double> a, List<Double> b) {
        // Проверка на пустые списки или разную длину
        if (a.isEmpty() || b.isEmpty() || a.size() != b.size()) {
            return 0.0; // Если один из списков пуст или размеры не совпадают, возвращаем 0.0
        }

        double productSum = 0.0; // Переменная для хранения суммы произведений
        for (int i = 0; i < a.size(); i++) {
            productSum += a.get(i) * b.get(i); // Суммируем произведения соответствующих элементов
        }

        return productSum; // Возвращаем скалярное произведение
    }

    /**
     * Средняя
     * <p>
     * Рассчитать значение многочлена при заданном x:
     * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
     * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
     * Значение пустого многочлена равно 0.0 при любом x.
     */
    public static double polynom(List<Double> p, double x) {
        // Если список пустой, возвращаем 0.0
        if (p.isEmpty()) {
            return 0.0;
        }

        double result = 0.0; // Переменная для хранения результата
        for (int i = 0; i < p.size(); i++) {
            result += p.get(i) * Math.pow(x, i); // Суммируем произведения коэффициентов и соответствующих степеней x
        }

        return result; // Возвращаем значение многочлена
    }

    /**
     * Средняя
     * <p>
     * В заданном списке list каждый элемент, кроме первого, заменить
     * суммой данного элемента и всех предыдущих.
     * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
     * Пустой список не следует изменять. Вернуть изменённый список.
     * <p>
     * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
     */
    public static List<Double> accumulate(List<Double> list) {
        // Если список пустой, ничего не делаем
        if (list.isEmpty()) {
            return list;
        }

        // Переменная для хранения текущей суммы
        double currentSum = list.get(0); // Начинаем с первого элемента

        // Проходим по списку, начиная со второго элемента
        for (int i = 1; i < list.size(); i++) {
            currentSum += list.get(i); // Добавляем текущий элемент к сумме
            list.set(i, currentSum); // Обновляем текущий элемент
        }

        return list; // Возвращаем изменённый список
    }


    /**
     * Средняя
     * <p>
     * Разложить заданное натуральное число n > 1 на простые множители.
     * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
     * Множители в списке должны располагаться по возрастанию.
     */
    public static List<Integer> factorize(int n) {
        List<Integer> factors = new ArrayList<>(); // Список для хранения множителей

        // Проверяем делимость на 2
        while (n % 2 == 0) {
            factors.add(2); // Добавляем 2 в список множителей
            n /= 2; // Делим n на 2
        }

        // Проверяем делимость на нечетные числа от 3 до sqrt(n)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i); // Добавляем i в список множителей
                n /= i; // Делим n на i
            }
        }

        // Если n стало больше 2, то оно является простым числом
        if (n > 2) {
            factors.add(n); // Добавляем n в список множителей
        }

        return factors; // Возвращаем список множителей
    }

    /**
     * Сложная
     * <p>
     * Разложить заданное натуральное число n > 1 на простые множители.
     * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
     * Множители в результирующей строке должны располагаться по возрастанию.
     */
    public static String factorizeToString(int n) {
        List<Integer> factors = new ArrayList<>(); // Список для хранения множителей

        // Проверяем делимость на 2
        while (n % 2 == 0) {
            factors.add(2); // Добавляем 2 в список множителей
            n /= 2; // Делим n на 2
        }

        // Проверяем делимость на нечетные числа от 3 до sqrt(n)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i); // Добавляем i в список множителей
                n /= i; // Делим n на i
            }
        }

        // Если n стало больше 2, то оно является простым числом
        if (n > 2) {
            factors.add(n); // Добавляем n в список множителей
        }

        // Формируем строку из множителей
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < factors.size(); i++) {
            result.append(factors.get(i));
            if (i < factors.size() - 1) {
                result.append("*"); // Добавляем * между множителями
            }
        }

        return result.toString(); // Возвращаем строку с множителями
    }

    /**
     * Средняя
     * <p>
     * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
     * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
     * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
     */
    public static List<Integer> convert(int n, int base) {
        List<Integer> digits = new ArrayList<>(); // Список для хранения цифр

        if (n == 0) {
            digits.add(0); // Если n равно 0, добавляем 0 в список
            return digits;
        }

        while (n > 0) {
            int digit = n % base; // Находим последнюю цифру в системе счисления base
            digits.add(digit); // Добавляем цифру в список
            n /= base; // Уменьшаем n, деля его на base
        }

        // Переворачиваем список, чтобы получить цифры от старшей к младшей
        List<Integer> result = new ArrayList<>();
        for (int i = digits.size() - 1; i >= 0; i--) {
            result.add(digits.get(i));
        }

        return result; // Возвращаем список цифр
    }

    /**
     * Сложная
     * <p>
     * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
     * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
     * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
     * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
     */
    public static String convertToString(int n, int base) {
        if (n == 0) {
            return "0"; // Если n равно 0, возвращаем "0"
        }

        StringBuilder result = new StringBuilder(); // Строка для хранения результата

        while (n > 0) {
            int digit = n % base; // Находим последнюю цифру в системе счисления base
            if (digit < 10) {
                result.append(digit); // Добавляем цифру (0-9)
            } else {
                result.append((char) ('a' + (digit - 10))); // Добавляем букву (a-z)
            }
            n /= base; // Уменьшаем n, деля его на base
        }

        return result.reverse().toString(); // Переворачиваем строку и возвращаем результат
    }

    /**
     * Средняя
     * <p>
     * Перевести число, представленное списком цифр digits от старшей к младшей,
     * из системы счисления с основанием base в десятичную.
     * Например: digits = (1, 3, 12), base = 14 -> 250
     */
    public static int decimal(List<Integer> digits, int base) {
        int result = 0; // Переменная для хранения результата
        int power = 1;  // Переменная для хранения текущей степени основания

        // Проходим по списку цифр от младшей к старшей
        for (int i = digits.size() - 1; i >= 0; i--) {
            result += digits.get(i) * power; // Увеличиваем результат на значение цифры, умноженное на соответствующую степень основания
            power *= base; // Увеличиваем степень основания
        }

        return result; // Возвращаем результат
    }

    /**
     * Сложная
     * <p>
     * Перевести число, представленное цифровой строкой str,
     * из системы счисления с основанием base в десятичную.
     * Цифры более 9 представляются латинскими строчными буквами:
     * 10 -> a, 11 -> b, 12 -> c и так далее.
     * Например: str = "13c", base = 14 -> 250
     */
    public static int decimalFromString(String str, int base) {
        int result = 0; // Переменная для хранения результата
        int length = str.length(); // Длина строки

        // Проходим по строке от старшей к младшей цифре
        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i); // Получаем текущий символ
            int digit;

            // Проверяем, является ли символ цифрой или буквой
            if (Character.isDigit(currentChar)) {
                digit = currentChar - '0'; // Преобразуем символ цифры в целое число
            } else {
                digit = currentChar - 'a' + 10; // Преобразуем символ буквы в целое число
            }

            // Увеличиваем результат на значение цифры, умноженное на соответствующую степень основания
            result = result * base + digit;
        }

        return result; // Возвращаем результат
    }

    /**
     * Сложная
     * <p>
     * Перевести натуральное число n > 0 в римскую систему.
     * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
     * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
     * Например: 23 = XXIII, 44 = XLIV, 100 = C
     */
    public static String roman(int n) {
        // Массив римских цифр и соответствующих значений
        String[] romanNumerals = {
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] values = {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder result = new StringBuilder(); // Строка для хранения результата

        // Проходим по массиву значений
        for (int i = 0; i < values.length; i++) {
            // Пока n больше или равно текущему значению
            while (n >= values[i]) {
                result.append(romanNumerals[i]); // Добавляем соответствующую римскую цифру
                n -= values[i]; // Уменьшаем n на текущее значение
            }
        }

        return result.toString(); // Возвращаем результат
    }

    /**
     * Очень сложная
     * <p>
     * Записать заданное натуральное число 1..999999 прописью по-русски.
     * Например, 375 = "триста семьдесят пять",
     * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
     */
    public static String russian(int n) {
        if (n < 1 || n > 999999) {
            throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 999999");
        }

        String[] units = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] teens = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
                "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
        String[] tens = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
                "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] hundreds = {"", "сто", "двести", "триста", "четыреста", "пятьсот",
                "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        String[] thousands = {"", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи",
                "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч"};

        StringBuilder result = new StringBuilder();

        // Обработка тысяч
        int thousandPart = n / 1000;
        if (thousandPart > 0) {
            result.append(thousands[thousandPart]).append(" ");
        }

        // Обработка сотен
        int hundredPart = (n % 1000) / 100;
        result.append(hundreds[hundredPart]).append(" ");

        // Обработка десятков и единиц
        int tenPart = (n % 100) / 10;
        int unitPart = n % 10;

        if (tenPart == 1 && unitPart > 0) {
            result.append(teens[unitPart - 1]).append(" ");
        } else {
            result.append(tens[tenPart]).append(" ");
            result.append(units[unitPart]).append(" ");
        }

        return result.toString().trim(); // Убираем лишние пробелы
    }


}
