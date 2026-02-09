package xamples.generics.neww;

import org.testng.annotations.Test;

import java.util.List;

public class GenericWildcards {

    private static void getFromParents(List<? super Integer> list) {
        //На запис спрацює
        list.add(1,2);
        //Тут неспрацює get бо ми не знаємо точно тип, але він може бути Integer або вище - поки не догнав повністю
//        return list.get(2);
    }

    private static void getFromChilds(List<? extends Integer> list) {
        //Тут навпаки не спрацює add бо ми е знаємо точно тип який саме наслідує Integer - поки не догнав повністю
//        list.add(1,2);
        //На читання спрацює
        list.get(2);
    }


    @Test
    public void test() {
        getFromParents(List.of(1, 2,3));
        getFromParents(List.of(1, 2,3));

    }
}
