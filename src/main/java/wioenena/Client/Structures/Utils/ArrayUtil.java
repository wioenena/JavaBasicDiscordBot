package wioenena.Client.Structures.Utils;

import java.util.Arrays;

public class ArrayUtil {
    public static <T> T[] push(T[] array, T value) {
        T newArray[] = Arrays.copyOf(array, array.length + 1);

        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];

        newArray[array.length] = value;

        return newArray;
    }

    public static <T> T[] pop(T[] array) {
        return Arrays.copyOfRange(array, 1, array.length);
    }

    public static <T> String join(T[] array, String seperator) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1)
                result += array[i] + seperator;
            else
                result += array[i];
        }
        return result;
    }

    public static <T> String join(T[] array) {
        return join(array, " ");
    }
}