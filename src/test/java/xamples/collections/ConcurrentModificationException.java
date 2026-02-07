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
//            intSet.remove(23);
//            it1.next();// 💥 ConcurrentModificationException
//        }

//        /**ConcurrentModificationException через iterator та add **/
//        Iterator<Integer> it2 = intSet.iterator();
//        while (it2.hasNext()) {
//
//            intSet.add(111); // 💥 ConcurrentModificationException
//            it2.next();
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
//        /**ConcurrentModificationException через foreach та add **/
//        for (String str: list)  {
//            list.remove(str);
//        }

//        for (String str: list)  {
//            list.add("Кубло");
//        }

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Європа", "Амстердам");
        linkedHashMap.put("Азія", "Улан-Батор");
        linkedHashMap.put("Австралія", "Канбера");

        /**ConcurrentModificationException в мапі через foreach та remove **/
        Iterator<Map.Entry<String, String>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            //Remove в мапі працює по ключу
            linkedHashMap.remove(it.next().getKey());
        }


    }
}
