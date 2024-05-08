/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interator.practice.common;

/**
 * @author Yeup Lee
 */
public interface Aggregate<T> {
    Iterator<T> iterator();

    Iterator<T> reversedIterator();

    default int nextEmpty() {
        int index = 0;
        Iterator<T> itr = this.iterator();
        while (itr.hasNext()) {
            if (itr.next() == null) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
