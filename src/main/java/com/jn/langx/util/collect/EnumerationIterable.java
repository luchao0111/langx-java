package com.jn.langx.util.collect;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterable<E> implements Iterable<E> {
    private EnumerationIterator<E> iterator;

    public EnumerationIterable(Enumeration<E> enumeration) {
        this(new EnumerationIterator<E>(enumeration));
    }

    public EnumerationIterable(EnumerationIterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<E> iterator() {
        return iterator;
    }
}
