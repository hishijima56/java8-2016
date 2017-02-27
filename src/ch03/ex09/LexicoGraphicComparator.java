/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Objects;

/**
 * 練習問題03_09
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/27
 */
public class LexicoGraphicComparator {

    private LexicoGraphicComparator(){
    }

    public static Comparator<Object> lexicoGraphicComparator(String... fieldNames){
        Objects.requireNonNull(fieldNames, "fieldNames is not null.");

        return (o1,o2) ->{
            Objects.requireNonNull(o1, "compare object is not null.");
            Objects.requireNonNull(o2, "compare object is not null.");

            @SuppressWarnings("rawtypes")
            Class clazz = o1.getClass();
            Field field;
            int result;
            for(String fieldName : fieldNames){
                try {
                    field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);

                    try {
                        @SuppressWarnings("unchecked")
                        Comparable<Object> v1 = (Comparable<Object>) field.get(o1);
                        Object v2 = field.get(o2);
                        result = v1.compareTo(v2);
                        if(result != 0){
                            return result;
                        }

                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }

                } catch (NoSuchFieldException | SecurityException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            return 0;
        };
    }

}
