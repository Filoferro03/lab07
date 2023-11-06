package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.function.Predicate;

import it.unibo.inner.api.IterableWithPolicy;

import java.util.ArrayList;


public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    
    private final T[] array;
    public IterableWithPolicyImpl (T[] array) {
        this.array=array;
    }

    private class Iterator implements java.util.Iterator<T> {

        int index=0;

        @Override
        public boolean hasNext() {
            return IterableWithPolicyImpl.this.array.length>this.index;
        }

        @Override
        public T next() {
            return IterableWithPolicyImpl.this.array[index++];
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return this.new Iterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
    }

    

} 