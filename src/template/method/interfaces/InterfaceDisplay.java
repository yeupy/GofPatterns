package template.method.interfaces;

public interface InterfaceDisplay {
    void open();
    void print();
    void close();
    default void display() {
        this.open();
        for (int i = 0; i < 5; i++) {
            this.print();
        }
        this.close();
    }
}
