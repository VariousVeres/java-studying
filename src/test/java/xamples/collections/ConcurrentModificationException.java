package xamples.collections;

import org.testng.annotations.Test;

import java.util.*;

public class ConcurrentModificationException {
    @Test
    public void test() {
        Set<Integer> intSet = new HashSet<>();
        intSet.add(23);
        intSet.add(100);
        intSet.add(-4);

//        /**ConcurrentModificationException через iterator та remove **/
//        Iterator<Integer> it1 = intSet.iterator();
//        while (it1.hasNext()) {
//            Integer c = it1.next();
//            intSet.remove(c); // 💥 ConcurrentModificationException
//        }
//
//        /**ConcurrentModificationException через iterator та add **/
//        Iterator<Integer> it2 = intSet.iterator();
//        while (it2.hasNext()) {
//            it2.next();
//            intSet.add(111); // 💥 ConcurrentModificationException
//        }

        List<String> list = new ArrayList<>();
        list.add("РУка");
        list.add("Рога");
        list.add("Нога");

        /**ConcurrentModificationException через foreach та remove **/

//        Iterator<String> it3 = list.listIterator();
//        while (it3.hasNext()) {
//            String i = it3.next();
//            list.remove(i);
//        }
        /**ConcurrentModificationException через foreach та add **/
        for (String str: list)  {
            list.remove(str);
        }


    }
}
