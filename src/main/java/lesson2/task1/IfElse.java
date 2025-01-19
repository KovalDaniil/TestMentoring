package lesson2.task1;

import static java.lang.Math.sqrt;
import static lesson1.Simple.discriminant;

public class IfElse {

    /**
     * Пример
     * <p>
     * Найти число корней квадратного уравнения ax^2 + bx + c = 0
     */
    public static int quadraticRootNumber(double a, double b, double c) {
        double discriminant = discriminant(a, b, c);
        return discriminant > 0.0 ? 2 : (discriminant == 0.0 ? 1 : 0);
    }

    /**
     * Пример
     * <p>
     * Получить строковую нотацию для оценки по пятибалльной системе
     */
    public static String gradeNotation(int grade) {
        String notation;
        switch (grade) {
            case 2:
                notation = "неудовлетворительно";
                break;
            case 3:
                notation = "удовлетворительно";
                break;
            case 4:
                notation = "хорошо";
                break;
            case 5:
                notation = "отлично";
                break;
            default:
                notation = "несуществующая оценка " + grade;
        }
        return notation;
    }

    /**
     * Пример
     * <p>
     * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
     */
    public static double minBiRoot(double a, double b, double c) {
        // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
        if (a == 0.0) {
            if (b == 0.0) return Double.NaN; // ... и ничего больше не делать
            double bc = -c / b;
            if (bc < 0) return Double.NaN;
            return -sqrt(bc);
            // Дальше функция при a == 0.0 не идёт
        }
        double d = discriminant(a, b, c);//2
        if (d < 0.0) return Double.NaN;//3
        //4:
        double y1 = (-b + sqrt(d)) / ((double) 2 * a);
        double y2 = (-b - sqrt(d)) / ((double) 2 * a);
        double y3 = Math.max(y1, y2); //5
        if (y3 < 0.0) return Double.NaN; //6
        return -sqrt(y3); //7
    }

    /**
     * Простая
     * <p>
     * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
     * вернуть строку вида: «21 год», «32 года», «12 лет».
     */
    public static String ageDescription(int age) {
        if (age < 0) {
            return "Возраст не может быть меньше 0 лет";
        } else if (age > 200) {
            return "Возраст не может быть больше 200 лет";
        } else {
            String suffix;
            if (age % 10 == 1 && age % 100 != 11) {
                suffix = "год";
            } else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
                suffix = "года";
            } else {
                suffix = "лет";
            }
            return age + " " + suffix;
        }
    }

    /**
     * Простая
     * <p>
     * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
     * и t3 часов — со скоростью v3 км/час.
     * Определить, за какое время он одолел первую половину пути?
     */
    public static double timeForHalfWay(double t1, double v1, double t2, double v2, double t3, double v3) {
        double d1 = t1 * v1;
        double d2 = t2 * v2;
        double d3 = t3 * v3;

        double totalDistance = d1 + d2 + d3;

        double halfDistance = totalDistance / 2;

        // Время, затраченное на первую половину пути
        double timeSpent = 0;

        if (halfDistance <= d1) {
            timeSpent = halfDistance / v1;
        } else if (halfDistance <= (d1 + d2)) {
            timeSpent = t1 + (halfDistance - d1) / v2;
        } else {
            timeSpent = t1 + t2 + (halfDistance - (d1 + d2)) / v3;
        }

        return timeSpent;
    }

    /**
     * Простая
     * <p>
     * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
     * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
     * и 3, если угроза от обеих ладей.
     * Считать, что ладьи не могут загораживать друг друга
     */
    public static int whichRookThreatens(int kingX, int kingY, int rookX1, int rookY1, int rookX2, int rookY2) {
        boolean threatFromRook1 = (kingX == rookX1 || kingY == rookY1);
        boolean threatFromRook2 = (kingX == rookX2 || kingY == rookY2);

        if (threatFromRook1 && threatFromRook2) {
            return 3; // Угроза от обеих ладей
        } else if (threatFromRook1) {
            return 1; // Угроза только от первой ладьи
        } else if (threatFromRook2) {
            return 2; // Угроза только от второй ладьи
        } else {
            return 0; // Угрозы нет
        }
    }

    /**
     * Простая
     * <p>
     * На шахматной доске стоят черный король и белые ладья и слон
     * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
     * Проверить, есть ли угроза королю и если есть, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
     * и 3, если угроза есть и от ладьи и от слона.
     * Считать, что ладья и слон не могут загораживать друг друга.
     */
    public static int rookOrBishopThreatens(int kingX, int kingY, int rookX, int rookY, int bishopX, int bishopY) {
        boolean threatFromRook = (kingX == rookX || kingY == rookY);
        boolean threatFromBishop = (Math.abs(kingX - bishopX) == Math.abs(kingY - bishopY));

        if (threatFromRook && threatFromBishop) {
            return 3; // Угроза от обеих фигур
        } else if (threatFromRook) {
            return 1; // Угроза только от ладьи
        } else if (threatFromBishop) {
            return 2; // Угроза только от слона
        } else {
            return 0; // Угрозы нет
        }
    }

    /**
     * Простая
     * <p>
     * Треугольник задан длинами своих сторон a, b, c.
     * Проверить, является ли данный треугольник остроугольным (вернуть 0),
     * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
     * Если такой треугольник не существует, вернуть -1.
     */
    public static int triangleKind(double a, double b, double c) {
        // Сначала проверяем существование треугольника
        if (a + b <= c || a + c <= b || b + c <= a) {
            return -1; // Треугольник не существует
        }

        // Убедимся, что c - это самая длинная сторона
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        if (b > c) {
            double temp = b;
            b = c;
            c = temp;
        }
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }

        // Проверка типа треугольника
        double a2 = a * a;
        double b2 = b * b;
        double c2 = c * c;

        if (a2 + b2 > c2) {
            return 0; // Остроугольный
        } else if (a2 + b2 == c2) {
            return 1; // Прямоугольный
        } else {
            return 2; // Тупоугольный
        }
    }


    /**
     * Средняя
     * <p>
     * Даны четыре точки на одной прямой: A, B, C и D.
     * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
     * Найти длину пересечения отрезков AB и CD.
     * Если пересечения нет, вернуть -1.
     * (Можно написать двумя способами - через switch statement или if statement
     * будет классно, если будут имплементированы оба и будет написан второй тест)
     */
    public static int segmentLength(int a, int b, int c, int d) {
        // Проверяем, пересекаются ли отрезки
        if (b < c || d < a) {
            return -1; // Пересечения нет
        }

        // Находим начало и конец пересечения
        int start = Math.max(a, c);
        int end = Math.min(b, d);

        // Возвращаем длину пересечения
        return end - start;
    }
}
