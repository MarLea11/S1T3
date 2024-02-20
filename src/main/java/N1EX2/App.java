package N1EX2;

import java.util.ArrayList;
import java.util.ListIterator;

public class App {

    private App(){}

    public static void runProgram() {

        // 1. Create a list of integers
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 2. Adding elements to it
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        list.add(66);
        list.add(77);
        list.add(88);
        list.add(99);

        // Print of the first list in normal order
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Finished printing the first list in normal order");

        // 3. Creating a second list of integers
        ArrayList<Integer> listReverse = new ArrayList <Integer>();

        // 4. Inserting the elements of the previous list into the new one but in reverse order

        // Using FOR Loop
        /*for (int i = list.size()-1; i>= 0; i--) {
            listReverse.add(list.get(i));
        }*/

        // Using ListIterator Object methods
        ListIterator<Integer> iterator = list.listIterator(list.size());
        while(iterator.hasPrevious()) {
            listReverse.add(iterator.previous());
        }

        // Print of the second list in reverse order

        // Using FOR loop
        /*for (int i = 0; i<listReverse.size(); i++) {
            System.out.println(listReverse.get(i));
          }*/

        // Using an ITERATOR
        ListIterator<Integer> iterator2 = listReverse.listIterator();
        while(iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println("Finished printing the second list in reversed order");

    }

}
