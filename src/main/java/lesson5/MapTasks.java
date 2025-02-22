package lesson5;

import java.util.*;

public class MapTasks {

    /**
     * Пример
     * <p>
     * Для заданного списка покупок `shoppingList` посчитать его общую стоимость
     * на основе цен из `costs`. В случае неизвестной цены считать, что товар
     * игнорируется.
     */
    public static double shoppingListCost(List<String> shoppingList, Map<String, Double> costs) {
        double totalCost = 0.0;

        for (String cost : costs.keySet()) {
            if (shoppingList.contains(cost)) totalCost += costs.get(cost);
        }

        return totalCost;
    }

    /**
     * Пример
     * <p>
     * Для заданного текста `text` убрать заданные слова-паразиты `fillerWords`
     * и вернуть отфильтрованный текст
     */
    public static List removeFillerWords(List<String> text, String[] fillerWords) {

        Set fillerWordSet = Set.of(fillerWords);

        List res = new ArrayList();
        Iterator iterator = text.iterator();

        //Пример работы с итератором
        while (iterator.hasNext()) {
            String word = (String) iterator.next();
            if (!fillerWordSet.contains(word)) {
                res.add(word);
            }
        }

        return res;
    }

    /**
     * Пример
     * <p>
     * Для заданного текста `text` построить множество встречающихся в нем слов
     * НАПИШИТЕ ТЕСТ САМОСТОЯТЕЛЬНО
     */
    public static Set<String> buildWordSet(List<String> text) {
        return new HashSet<>(text);
    }

    /**
     * Средняя
     * <p>
     * Объединить два ассоциативных массива `mapA` и `mapB` с парами
     * "имя"-"номер телефона" в итоговый ассоциативный массив, склеивая
     * значения для повторяющихся ключей через запятую.
     * В случае повторяющихся *ключей* значение из mapA должно быть
     * перед значением из mapB.
     * <p>
     * Повторяющиеся *значения* следует добавлять только один раз.
     * <p>
     * Например:
     * mergePhoneBooks(
     * mapOf("Emergency" to "112", "Police" to "02"),
     * mapOf("Emergency" to "911", "Police" to "02")
     * ) -> mapOf("Emergency" to "112, 911", "Police" to "02")
     */
    public static Map<String, String> mergePhoneBooks(Map<String, String> mapA, Map<String, String> mapB) {
        Map<String, String> mergedMap = new HashMap<>();

        // Добавляем все записи из mapA
        for (Map.Entry<String, String> entry : mapA.entrySet()) {
            mergedMap.put(entry.getKey(), entry.getValue());
        }

        // Обрабатываем записи из mapB
        for (Map.Entry<String, String> entry : mapB.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            // Если ключ уже существует в mergedMap, добавляем значение
            if (mergedMap.containsKey(key)) {
                String existingValue = mergedMap.get(key);
                // Добавляем только уникальные значения
                if (!existingValue.contains(value)) {
                    mergedMap.put(key, existingValue + ", " + value);
                }
            } else {
                // Если ключа нет, просто добавляем его
                mergedMap.put(key, value);
            }
        }

        return mergedMap;
    }

    /**
     * Простая
     * <p>
     * По заданному ассоциативному массиву "студент"-"оценка за экзамен" построить
     * обратный массив "оценка за экзамен"-"список студентов с этой оценкой".
     * <p>
     * Например:
     * buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
     * -> mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат"))
     */

    public static Map<Integer, List<String>> buildGrades(Map<String, Integer> grades) {
        Map<Integer, List<String>> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            String student = entry.getKey();
            Integer grade = entry.getValue();

            // Если оценка уже есть в результирующем массиве, добавляем студента в список
            if (!result.containsKey(grade)) {
                result.put(grade, new ArrayList<>());
            }
            result.get(grade).add(student);
        }

        return result;
    }

    /**
     * Простая
     * <p>
     * Определить, входит ли ассоциативный массив a в ассоциативный массив b;
     * это выполняется, если все ключи из a содержатся в b с такими же значениями.
     * <p>
     * Например:
     * containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")) -> true
     * containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")) -> false
     */
    public static boolean containsIn(Map<String, String> a, Map<String, String> b) {
        // Проходим по всем записям в массиве a
        for (Map.Entry<String, String> entry : a.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            // Проверяем, существует ли ключ в b и совпадает ли значение
            if (!b.containsKey(key) || !b.get(key).equals(value)) {
                return false; // Если ключа нет или значения не совпадают, возвращаем false
            }
        }
        return true; // Если все ключи и значения совпадают, возвращаем true
    }

    /**
     * Средняя
     * <p>
     * Для заданного списка пар "акция"-"стоимость" вернуть ассоциативный массив,
     * содержащий для каждой акции ее усредненную стоимость.
     * <p>
     * Например:
     * averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
     * -> mapOf("MSFT" to 150.0, "NFLX" to 40.0)
     */
    public static Map<String, Double> averageStockPrice(List<Map.Entry<String, Double>> stockPrices) {
        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> countPrices = new HashMap<>();

        // Проходим по всем парам "акция"-"стоимость"
        for (Map.Entry<String, Double> entry : stockPrices) {
            String stock = entry.getKey();
            Double price = entry.getValue();

            // Обновляем общую стоимость
            totalPrices.put(stock, totalPrices.getOrDefault(stock, 0.0) + price);
            // Увеличиваем счетчик
            countPrices.put(stock, countPrices.getOrDefault(stock, 0) + 1);
        }

        // Создаем результирующий ассоциативный массив с усредненными значениями
        Map<String, Double> averagePrices = new HashMap<>();
        for (String stock : totalPrices.keySet()) {
            averagePrices.put(stock, totalPrices.get(stock) / countPrices.get(stock));
        }

        return averagePrices;
    }

    /**
     * Средняя
     * <p>
     * Входными данными является ассоциативный массив
     * "название товара"-"пара (тип товара, цена товара)"
     * и тип интересующего нас товара.
     * Необходимо вернуть название товара заданного типа с минимальной стоимостью
     * или null в случае, если товаров такого типа нет.
     * <p>
     * Например:
     * findCheapestStuff(
     * mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
     * "печенье"
     * ) -> "Мария"
     */
    public static String findCheapestStuff(Map<String,Double> stuff, String kind) {
        return "";
    }

    /**
     * Сложная
     * <p>
     * Для заданного ассоциативного массива знакомых через одно рукопожатие `friends`
     * необходимо построить его максимальное расширение по рукопожатиям, то есть,
     * для каждого человека найти всех людей, с которыми он знаком через любое
     * количество рукопожатий.
     * Считать, что все имена людей являются уникальными, а также что рукопожатия
     * являются направленными, то есть, если Марат знает Свету, то это не означает,
     * что Света знает Марата.
     * <p>
     * Например:
     * propagateHandshakes(
     * mapOf(
     * "Marat" to setOf("Mikhail", "Sveta"),
     * "Sveta" to setOf("Marat"),
     * "Mikhail" to setOf("Sveta")
     * )
     * ) -> mapOf(
     * "Marat" to setOf("Mikhail", "Sveta"),
     * "Sveta" to setOf("Marat", "Mikhail"),
     * "Mikhail" to setOf("Sveta", "Marat")
     * )
     */
    public static Map<String,String> propagateHandshakes(Map<String,Set<String>> friends) {
        return null;
    }

    /**
     * Простая
     * <p>
     * Удалить из изменяемого ассоциативного массива все записи,
     * которые встречаются в заданном ассоциативном массиве.
     * Записи считать одинаковыми, если и ключи, и значения совпадают.
     * <p>
     * ВАЖНО: необходимо изменить переданный в качестве аргумента
     * изменяемый ассоциативный массив
     * <p>
     * Например:
     * subtractOf(a = MapOf("a" to "z"), mapOf("a" to "z"))
     * -> a changes to MapOf() aka becomes empty
     */
    public static boolean subtractOf(Map<String,String> a, Map<String,String> b) {
        return false;
    }


    /**
     * Простая
     * <p>
     * Для двух списков людей найти людей, встречающихся в обоих списках
     */
    public static List<String> whoAreInBoth(List<String> a, List<String> b) {
        return null;
    }

    /**
     * Средняя
     * <p>
     * Найти в заданном списке повторяющиеся элементы и вернуть
     * ассоциативный массив с информацией о числе повторений
     * для каждого повторяющегося элемента.
     * Если элемент встречается только один раз, включать его в результат
     * не следует.
     * <p>
     * Например:
     * extractRepeats(listOf("a", "b", "a")) -> mapOf("a" to 2)
     */
    public static Map<String,Integer> extractRepeats(List<String> list) {
        return null;
    }

    /**
     * Средняя
     * <p>
     * Для заданного списка слов определить, содержит ли он анаграммы
     * (два слова являются анаграммами, если одно можно составить из второго)
     * <p>
     * Например:
     * hasAnagrams(listOf("тор", "свет", "рот")) -> true
     */
    public static boolean hasAnagrams(List<String> words) {
        return false;
    }


    /**
     * Очень сложная
     * <p>
     * Входными данными является ассоциативный массив
     * "название сокровища"-"пара (вес сокровища, цена сокровища)"
     * и вместимость вашего рюкзака.
     * Необходимо вернуть множество сокровищ с максимальной суммарной стоимостью,
     * которые вы можете унести в рюкзаке.
     * <p>
     * Пример на псевдокоде:
     * bagPacking(
     * mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
     * 850
     * ) -> setOf("Кубок")
     * bagPacking(
     * mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
     * 450
     * ) -> emptySet()
     */


    public static Set<String> bagPacking(Map<String,Integer> treasures, int capacity) {
        return null;
    }

    }
