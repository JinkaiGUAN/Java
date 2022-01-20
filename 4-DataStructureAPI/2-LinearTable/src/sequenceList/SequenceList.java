package sequenceList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author: Peter
 * @date: 20/01/2022
 * @description:
 */
public class SequenceList<T> implements Iterable<T>{
    private T[] eles;
    private int N;
    private int Capacity;

    public SequenceList() {}

    public SequenceList(int capacity) {
        this.Capacity = capacity;
        this.eles = (T[]) new Object[capacity];
        this.N = 0;
    }

    public void clear() {
        this.eles = (T[]) new Object[this.Capacity];
        this.N = 0;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        return eles[i];
    }

    public void insert(T t) {
        eles[N++] = t;
    }

    public void inset(int i, T t) {
        if (i >= Capacity) {
            throw new ArrayIndexOutOfBoundsException("The index is out of bound!");
        }

        // todo: Some problems here, we need to start from N, i.e., we lost a final value
        for(int idx = N; idx > i; idx--) {
            eles[idx] = eles[idx-1];
        }
        eles[i] = t;
        N++;
    }

    public T remove(int i) {
        T cur = eles[i];

        for (int idx = i; i < N - 2; i++ ) {
            eles[idx] = eles[idx + 1];
        }
        N--;

        return cur;
    }

    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }

        return -1;
    }


    // todo: Enable Generate missed test method function in IntelliJ
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    private class SIterator implements Iterator {
        private int cursor;

        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }
}
