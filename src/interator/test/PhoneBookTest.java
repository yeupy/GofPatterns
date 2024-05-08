package interator.test;


import interator.practice.phone.Person;
import interator.practice.phone.PhoneBook;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yeup Lee
 */
public class PhoneBookTest {
    public static void main(String[] args) {
        Logger.getGlobal().setLevel(Level.WARNING);
        PhoneBook phoneBook = new PhoneBook(3);
        phoneBook.append(new Person("Yeup", "Lee", "010-3344-5208", "yeupy1@gmail.com"));
        phoneBook.append(new Person("Sang Su", "Kim", "010-2433-7665", "yeupy1@gmail.com"));
        phoneBook.append(new Person("Keum Yong", "Park", "010-1231-8856", "yeupy1@gmail.com"));
        phoneBook.append(new Person("Jae Wook", "Won", "010-2223-3453", "yeupy1@gmail.com"));

        phoneBook.iterator().print();
        phoneBook.reversedIterator().print();

        phoneBook.removeAt(3);
        phoneBook.removeAt(1);
        phoneBook.append(new Person("Jae Sang", "Lee", "010-3344-2334", "yeupy1@gmail.com"));
        phoneBook.iterator().print();

        phoneBook.sort("firstName");
        phoneBook.iterator().print();

        phoneBook.removeAt(1);
        phoneBook.appendAt(new Person("Yeo Jin", "Lee", "010-3344-6642", "yeupy1@gmail.com"), 2);
        phoneBook.iterator().print();
    }
}
