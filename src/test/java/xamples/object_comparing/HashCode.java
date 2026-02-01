package xamples.object_comparing;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Cherry  {
    String name;
    Cherry(String str)  {
        this.name = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cherry cherry = (Cherry) o;
        return Objects.equals(name, cherry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
public class HashCode {
    @Test
    public void test() {
        Cherry cherry1 = new Cherry("Sudova");
        Cherry cherry2 = new Cherry("Sudova");
        Cherry cherry3 = new Cherry("Viwnya");
        //Якщо hashCode превизначений то однакові об'єкти будуть мати однакові хеші
        System.out.println(cherry1.hashCode());
        System.out.println(cherry2.hashCode());
        System.out.println(cherry3.hashCode());

        Set<Cherry> cherrySet = new HashSet<>();
        cherrySet.add(cherry1);
        cherrySet.add(cherry2);
        //З превизначеним хешкодом в сет не додасть два однакові об'єкти
        System.out.println(cherrySet.size());

        //З стрінгами так само бо hashCode та equals в них перевизначений рівні будуть рівними навіть якщо це 2 окремих об'єкти
        HashSet <String> setOfString = new HashSet<>();
        setOfString.add(new String("Hate"));
        setOfString.add(new String("Hate"));
        System.out.println(setOfString.size());


        cherry1 = new Cherry("Pick");
        cherry2 = new Cherry("Pick");
        //Якщо equals і hashCode перевизначений то з мапи можна витягнути значення по ключу-об'єкту рівному тому ключу котрий ми помстили в мапу
        HashMap<Cherry, String> mapOfCherries = new HashMap<>();
        mapOfCherries.put(cherry1, "Cherry 1");

        System.out.println(mapOfCherries.get(cherry2));

        //А от мутувати об'єкт не варто бо зміниться хеш і вже ми так не зможем
        cherry2.name="Rotten cherry";
        System.out.println(mapOfCherries.get(cherry2));


    }
}
