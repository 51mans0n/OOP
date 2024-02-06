package lab3ex4;

import java.util.Comparator;

public class NameComparator implements Comparator<Manager> {
    @Override
    public int compare(Manager o1, Manager o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
