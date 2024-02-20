package N1EX1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App {

    private App(){}

    public static void runProgram() {

        // 1. CREATE ARRAYLIST MONTHS
        ArrayList<Month> listMonths = new ArrayList<Month>();

        // 2. ADD 11 MONTHS OBJECT TO THE ARRAYLIST
        listMonths.add(new Month("January"));
        listMonths.add(new Month("February"));
        listMonths.add(new Month("March"));
        listMonths.add(new Month("April"));
        listMonths.add(new Month("May"));
        listMonths.add(new Month("June"));
        listMonths.add(new Month("July"));
        listMonths.add(new Month ("September"));
        listMonths.add(new Month("October"));
        listMonths.add(new Month("November"));
        listMonths.add(new Month("December"));

        // 3. ADD AUGUST IN THE CORRECT PLACE AND CHECKING WITH A PRINT THAT AUGUST MAINTAINS THE CORRECT ORDER
        Month month7 = new Month ("August");
        listMonths.add(7, month7);

        for(int i = 0; i<listMonths.size(); i++) {
            System.out.println(listMonths.get(i));
        }

        System.out.println();
        System.out.println("END OF ARRAYLIST PRINT");
        System.out.println();

        // 4. CONVERTING THE ARRAYLIST TO A HASHSET AND CHECKING FOR DUPLICATES
        Set<Month> listMonthsSet = new HashSet<Month>(listMonths);

        listMonthsSet.add(new Month("September"));

        try {
            for(Month month : listMonths)
                listMonthsSet.add(month);
        } catch(IllegalArgumentException e) {
            System.out.println("Set lists do not allow duplicates");
        }

        // 5. SEARCH THROUGH THE SET LIST WITH A FOR LOOP AND AN ITERATOR

        // USING FOREACH LOOP
        for (Month month : listMonthsSet) {
            System.out.println(month);
        }

        System.out.println();

        // USING AN ITERATOR
        Iterator<Month> listMonthsSetIterator = listMonthsSet.iterator();

        while(listMonthsSetIterator.hasNext()) {
            Month month = listMonthsSetIterator.next();
            System.out.println(month);
        }

    }

}
