import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class NestedIterator implements Iterator<Integer> {

    private final List<Integer> flattenedList;
    private final Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenedList = new LinkedList<>();
        flatten(nestedList);
        it = flattenedList.iterator();
    }

    private void flatten(List<NestedInteger> nestedList) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                flattenedList.add(i.getInteger());
            } else {
                flatten(i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}