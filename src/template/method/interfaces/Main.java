package template.method.interfaces;

public class Main {
    public static void main(String[] args) {
        InterfaceDisplay d1 = new CharDisplay('H');
        InterfaceDisplay d2 = new StringDisplay("Hello, world.");
        InterfaceDisplay d3 = new StringDisplay("안녕하세요.");
        d1.display();
        d2.display();
        d3.display();
    }
}
