package interator.practice.common;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.logging.Logger;

import static java.text.MessageFormat.format;

public abstract class Shelf<T> implements Aggregate<T> {

    protected final static Logger log = Logger.getGlobal();
    protected int size = 0;

    public abstract int getMaximum();

    public abstract T getAt(int index);

    protected void exceptionIfMaximum() throws Exception {
        if (getSize() == getMaximum()) {
            throw new Exception(format("Maximum({0}) reached! Operation canceled.", this.getMaximum()));
        }
    }

    protected void exceptionIfInvalid(int index) throws Exception {
        if (index < 0 || index >= this.getMaximum()) {
            throw new Exception(format("Invalid index({0})! Operation canceled.", index));
        }
    }

    protected void exceptionIfNull(T element) throws Exception {
        if (element == null) {
            throw new Exception("Item is null! Operation canceled.");
        }
    }

    protected void exceptionIfNotNull(T element) throws Exception {
        if (element != null) {
            throw new Exception("Item is not null! Operation canceled.");
        }
    }

    public abstract void removeAt(int index);

    public abstract void appendAt(T element, int index);

    public void append(T element) {
        int index = this.nextEmpty();
        this.appendAt(element, index);
    }

    public int getSize() {
        return this.size;
    }

    protected Field getParameterTypeField(String key) throws NoSuchFieldException {
        Class<T> type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Field field = type.getDeclaredField(key);
        field.setAccessible(true);
        return field;
    }

    @Override
    public Iterator<T> iterator() {
        return new ShelfIterator<>(this);
    }

    @Override
    public Iterator<T> reversedIterator() {
        return new ShelfReversedIterator<>(this);
    }

    protected abstract Object getCollection();

    public abstract void sort(String key);
}
