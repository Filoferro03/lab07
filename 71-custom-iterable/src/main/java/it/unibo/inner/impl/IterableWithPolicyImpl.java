package it.unibo.inner.impl;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import it.unibo.inner.api.IterableWithPolicy;


public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    
    private final T[] array;
    private Predicate<T> filter;
    
    public IterableWithPolicyImpl (T[] array) {
        this (array, new Predicate<T>() {
            @Override
            public boolean test(T elem) {
                return true;
            }
        }
        );
    }

    public IterableWithPolicyImpl (T[] array, Predicate<T> filter) {
        this.array=array;
        this.filter=filter;
    }

    private class Iterator implements java.util.Iterator<T> {

        int index=0;

        @Override
        public boolean hasNext() {
            while (index<array.length) {
                T elem = array[index];
                if (filter.test(elem)) {
                    return true;
                }
                index++;
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return array[index++];
            }
            throw new NoSuchElementException();
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter=filter;
    }

    

} 