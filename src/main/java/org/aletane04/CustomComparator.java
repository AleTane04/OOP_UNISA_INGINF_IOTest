package org.aletane04;

import java.util.Comparator;

public class CustomComparator implements Comparator<Impiegato>
{
    @Override
    public int compare(Impiegato i1, Impiegato i2)
    {
        return i1.getStipendio().compareTo(i2.getStipendio());
    }
}
