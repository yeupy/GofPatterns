package misc;

import java.lang.reflect.Field;

public class Test {
    public String name;
    public int age;
    public Inner inner;

    public Test() {
        inner = new Test.Inner();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                sb.append(field.getName()).append(": ").append(field.get(this)).append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public void print() {
        inner.printCommon();
    }

    static class Inner implements Cloneable {
        private int x;
        public static String common = "common";

        static {
            common = "chagned common";
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void printCommon() {
            System.out.println(common);
        }

        public void printHash() {
            System.out.println(this.hashCode());
        }

        @Override
        protected Inner clone() throws CloneNotSupportedException {
            return (Inner) super.clone();
        }

        public String toString() {
            return x + ": " + common;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        Test test = new Test();
//        Test.print(test);
//        test.name = "Test";
//        test.age = 16;
//        Test.print(test);
//        AbstractDisplay d = new StringDisplay("hello");
//        d.display();
        Inner i1 = new Inner();
        i1.setX(1);
        Inner i2 = new Inner();

//        Inner.common = "changed coomon";
        Inner i3 = i1.clone();
        i1.setX(100);

        i1.printHash();
        i3.printHash();

        System.out.println(i3);

       /* i1.printHash();
        i2.printHash();

        Test test = new Test();
        test.inner.printHash();*/

    }
}
