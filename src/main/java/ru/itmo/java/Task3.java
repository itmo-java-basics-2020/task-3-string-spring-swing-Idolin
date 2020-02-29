package ru.itmo.java;

import java.util.Arrays;
import java.util.HashMap;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null) {
            return new int[0];
        }
        if (inputArray.length < 2) {
            return inputArray;
        }
        int last = inputArray[inputArray.length - 1];
        System.arraycopy(inputArray, 0, inputArray, 1, inputArray.length - 1);
        inputArray[0] = last;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        int min_value = inputArray[0], max_value = inputArray[0], result = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            result = Math.max(result, inputArray[i] * min_value);
            result = Math.max(result, inputArray[i] * max_value);
            if (inputArray[i] < min_value) {
                min_value = inputArray[i];
            } else if (inputArray[i] > max_value) {
                max_value = inputArray[i];
            }
        }
        return result;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int countABChars = 0;
        String lowerCaseInput = input.toLowerCase();
        for (int i = 0; i < lowerCaseInput.length(); i++) {
            if (lowerCaseInput.charAt(i) == 'a' || lowerCaseInput.charAt(i) == 'b') {
                countABChars++;
            }
        }
        return countABChars * 100 / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        do {
            int startPosition = i;
            char c = input.charAt(i++);
            while (i < input.length() && input.charAt(i) == c) {
                i++;
            }
            builder.append(c);
            builder.append(i - startPosition);
        } while (i < input.length());
        return builder.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() != two.length() || one.length() == 0) {
            return false;
        }
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < one.length(); i++) {
            charCount.put(one.charAt(i), charCount.getOrDefault(one.charAt(i), 0) + 1);
            charCount.put(two.charAt(i), charCount.getOrDefault(two.charAt(i), 0) - 1);
        }
        for (Integer count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == characters[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m[0].length == 0) {
            return new int[][]{{}, {}};
        }
        int[][] transposed = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                transposed[i][j] = m[j][i];
            }
        }
        return transposed;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null) {
            return "";
        }
        return String.join((separator != null) ? separator.toString() : " ", inputStrings);
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }
        int count = 0;
        for (String s : inputStrings) {
            if (s.startsWith(prefix)) {
                count++;
            }
        }
        return count;
    }
}
