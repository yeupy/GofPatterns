/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interator.practice.common;

import java.util.Iterator;

/**
 * @author Yeup Lee
 */
public class ShelfReversedIterator<T> extends ShelfIterator<T> implements Iterator<T> {

    public ShelfReversedIterator(Shelf<T> shelf) {
        super(shelf);
        index = shelf.getSize();
    }

    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public T next() {
        return this.shelf.getAt(--index);
    }

}
