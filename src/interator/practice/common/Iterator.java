package interator.practice.common;

public interface Iterator<T> {
    boolean hasNext();

    T next();

    default void print() {
        System.out.println("Printing...");
        int index = 0;
        while (this.hasNext()) {
            System.out.println(this.next());
        }
    }
}
