/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interator.practice.common;

import interator.practice.common.Iterator;
import interator.practice.common.Shelf;

/**
 * @author Yeup Lee
 */
public class ShelfIterator<T> implements Iterator<T> {

    protected Shelf<T> shelf;
    protected int index;

    public ShelfIterator(Shelf<T> shelf) {
        this.shelf = shelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < this.shelf.getMaximum();
    }

    @Override
    public T next() {
        return this.shelf.getAt(index++);
    }

}
