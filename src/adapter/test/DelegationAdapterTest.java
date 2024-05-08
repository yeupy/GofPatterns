package adapter.test;

import adapter.delegation.Print;
import adapter.delegation.PrintBanner;

public class DelegationAdapterTest {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
