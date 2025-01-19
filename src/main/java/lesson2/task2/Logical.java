package lesson2.task2;

import static lesson1.Simple.sqr;

public class Logical {
    /**
     * Пример
     * <p>
     * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
     */
    public static boolean pointInsideCircle(double x, double y, double x0, double y0, double r) {
        return sqr(x - x0) + sqr(y - y0) <= sqr(r);
    }

    /**
     * Простая
     * <p>
     * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
     * Определить, счастливое ли заданное число, вернуть true, если это так.
     */
    public static boolean isNumberHappy(int number) {
        // Проверяем, что число четырехзначное
        if (number < 1000 || number > 9999) {
            return false; // Не четырехзначное число
        }

        // Извлекаем цифры числа
        int firstDigit = number / 1000; // Первая цифра
        int secondDigit = (number / 100) % 10; // Вторая цифра
        int thirdDigit = (number / 10) % 10; // Третья цифра
        int fourthDigit = number % 10; // Четвертая цифра

        // Проверяем, равны ли суммы первых двух и последних двух цифр
        return (firstDigit + secondDigit) == (thirdDigit + fourthDigit);
    }

    /**
     * Простая
     * <p>
     * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
     * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
     * Считать, что ферзи не могут загораживать друг друга.
     */
    public static boolean queenThreatens(int x1, int y1, int x2, int y2) {
        // Проверка на одной вертикали
        if (x1 == x2) {
            return true;
        }
        // Проверка на одной горизонтали
        if (y1 == y2) {
            return true;
        }
        // Проверка на одной диагонали
        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            return true;
        }
        // Если ни одно из условий не выполнено, ферзи не угрожают друг другу
        return false;
    }

    /**
     * Простая
     * <p>
     * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
     * Вернуть число дней в этом месяце этого года по григорианскому календарю.
     */
    public static int daysInMonth(int month, int year) {
        // Проверка на корректность входных данных
        if (month < 1 || month > 12 || year < 1) {
            return 0; // Возвращаем 0 для некорректных данных
        }

        // Определяем количество дней в месяце
        switch (month) {
            case 1: // Январь
            case 3: // Март
            case 5: // Май
            case 7: // Июль
            case 8: // Август
            case 10: // Октябрь
            case 12: // Декабрь
                return 31;
            case 4: // Апрель
            case 6: // Июнь
            case 9: // Сентябрь
            case 11: // Ноябрь
                return 30;
            case 2: // Февраль
                // Проверка на високосный год
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29; // Високосный год
                } else {
                    return 28; // Обычный год
                }
            default:
                return 0; // На всякий случай, хотя этот случай не должен возникнуть
        }
    }

    /**
     * Средняя
     * <p>
     * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
     * окружности с центром в (x2, y2) и радиусом r2.
     * Вернуть true, если утверждение верно
     */
    public static boolean circleInside(double x1, double y1, double r1, double x2, double y2, double r2) {
        // Вычисляем квадрат расстояния между центрами окружностей
        double distanceSquared = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);

        // Вычисляем квадрат разности радиусов
        double radiusDifferenceSquared = Math.pow(r2 - r1, 2);

        // Проверяем, находится ли окружность (x1, y1, r1) внутри окружности (x2, y2, r2)
        return distanceSquared < radiusDifferenceSquared && r1 < r2;
    }

    /**
     * Средняя
     * <p>
     * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
     * Стороны отверстия должны быть параллельны граням кирпича.
     * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
     * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
     * Вернуть true, если кирпич пройдёт
     */
    public static boolean brickPasses(int a, int b, int c, int r, int s) {
        // Сначала убедимся, что r - это меньшая сторона, а s - большая
        if (r > s) {
            int temp = r;
            r = s;
            s = temp;
        }

        // Проверяем все возможные комбинации сторон кирпича
        return (a <= r && b <= s) || (a <= s && b <= r) ||
                (c <= r && a <= s) || (c <= s && a <= r) ||
                (c <= r && b <= s) || (c <= s && b <= r);
    }
}
