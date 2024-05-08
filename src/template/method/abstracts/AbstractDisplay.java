package template.method.abstracts;

public abstract class AbstractDisplay {
    protected abstract void open();
    protected abstract void print();
    protected abstract void close();
    public final void display() {
        this.open();
        for (int i = 0; i < 5; i++) {
            this.print();
        }
        this.close();
    }
}
