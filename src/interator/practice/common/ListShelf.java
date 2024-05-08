package interator.practice.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;

public abstract class ListShelf<T> extends Shelf<T> {

    private List<T> collection;
    private int maximum;

    public ListShelf(int maximum) {
        this.collection = new ArrayList<>(maximum);

        int i = 0;
        while (i < maximum) {
            this.collection.add(null);
            i++;
        }

        this.maximum = maximum;
    }

    @Override
    public int getMaximum() {
        return this.maximum;
    }

    @Override
    public T getAt(int index) {
        try {
            this.exceptionIfInvalid(index);
            T element = collection.get(index);
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
            T element = collection.get(index);
            this.exceptionIfNull(element);
            log.info(format("{0}", element));
            collection.set(index, null);
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

            T _element = collection.get(index);
            this.exceptionIfNotNull(_element);
            collection.set(index, element);
            log.info(format("{0}", element));
            size++;
        } catch (Exception e) {
            log.warning(e.getMessage());
        }
    }

    @Override
    public List<T> getCollection() {
        return this.collection;
    }

    @Override
    public void sort(String key) {
        Field field;
        try {
            field = getParameterTypeField(key);
        } catch (NoSuchFieldException e) {
            log.warning(format("Invalid sorting key ({0})! Operation canceled.", key));
            return;
        }

        List<T> collection = getCollection();
        collection.sort((a, b) -> {
            try {
                return String.valueOf(field.get(a)).compareTo(String.valueOf(field.get(b)));
            } catch (IllegalAccessException e) {
                log.warning(format("key ({0}) not accessible! Operation canceled.", key));
                return 0;
            }
        });
    }
}
