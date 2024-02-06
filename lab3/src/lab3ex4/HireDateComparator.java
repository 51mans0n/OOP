package lab3ex4;

import java.util.Comparator;

public class HireDateComparator implements Comparator<Manager> {
    @Override
    public int compare(Manager o1, Manager o2) {
        return o1.getHireDate().compareTo(o2.getHireDate());
    }
}
