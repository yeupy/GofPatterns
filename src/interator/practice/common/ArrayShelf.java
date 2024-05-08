package interator.practice.common;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

import static java.text.MessageFormat.format;

public abstract class ArrayShelf<T> extends Shelf<T> {

    private T[] collection;

    public ArrayShelf(int maximum) {
        this.collection = (T[]) new Object[maximum];
    }

    @Override
    public int getMaximum() {
        return this.collection.length;
    }

    @Override
    public T getAt(int index) {
        try {
            this.exceptionIfInvalid(index);
            T element = this.collection[index];
            log.info(format("{0}", element));
            return element;
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }

    @Override
    public void removeAt(int index) {
        try {
            this.exceptionIfInvalid(index);
            T element = collection[index];
            this.exceptionIfNull(element);
            log.info(format("{0}", element));
            collection[index] = null;
            size--;
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    @Override
    public void appendAt(T element, int index) {
        try {
            this.exceptionIfInvalid(index);
            this.exceptionIfMaximum();
            this.exceptionIfNotNull(this.collection[index]);
            this.collection[index] = element;
            log.info(format("{0}", element));
            size++;
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    @Override
    public T[] getCollection() {
        return this.collection;
    }

    public void sort(String key) {
        Field field;
        try {
            field = getParameterTypeField(key);
        } catch (NoSuchFieldException e) {
            log.warning(format("Invalid sorting key ({0})! Operation canceled.", key));
            return;
        }

        T[] collection = getCollection();
        Arrays.sort(collection, (a, b) -> {
            try {
                return String.valueOf(field.get(a)).compareTo(String.valueOf(field.get(b)));
            } catch (IllegalAccessException e) {
                log.warning(format("key ({0}) not accessible! Operation canceled.", key));
                return 0;
            }
        });
    }
}
