package xamples.maps;

import org.testng.annotations.Test;

import java.util.*;

public class LinkedAndTreeMaps {
    @Test
    public void test() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Європа", "Амстердам");
        linkedHashMap.put("Азія", "Улан-Батор");
        linkedHashMap.put("Австралія", "Канбера");

        Iterator<Map.Entry<String, String>> it = linkedHashMap.entrySet().iterator();
        //Виведе в порядку вставки
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }



        Comparator <String>comparator = (o1, o2) -> o1.length() - o2.length();
        //Створимо TreeMap з компаратором
        TreeMap<String, String> treeMap = new TreeMap<>(comparator);
        treeMap.put("Європа", "Амстердам");
        treeMap.put("Азія", "Улан-Батор");
        treeMap.put("Австралія", "Канбера");

        //Посортує по довжині ключів (без компаратора посортувало б нативно по ключам)
        Iterator<Map.Entry<String, String>> it2 = treeMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, String> entry = it2.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }








        }





}
