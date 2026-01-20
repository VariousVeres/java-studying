package xamples.object_basic;

import org.junit.Test;
import training_package_another.Cat;

import java.util.HashSet;
import java.util.Set;

public class SimpleEqual {
    @Test
    public void test() {
        /** == слугує для порівняння значень примітивів **/
        int i1 = 2;
        int i2 = 2;
        int i3 = 19;
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(Integer.compare(i1, i2));
        System.out.println(Integer.compare(i1, i3) + "\n");

        boolean bool1 = false;
        boolean bool2 = false;
        System.out.println(bool1 == bool2);
        System.out.println(Boolean.compare(bool1, bool2));

        String s1 = "Johny";
        String s2 = "Johny";
        //Для стрінгів хоч це об'єкти так канає бо хоч і різні референси але дані беруться з одного String pool
        System.out.println(s1 == s2);

        //А отакий не канає бо це вже новий об'єкт ми створили, хоч його хеш і буде такий самий
        String s3 = new String("Johny");
        System.out.println(s1 == s3);

        //однаковий hashCode НЕ означає, що обʼєкти — той самий обʼєкт
        System.out.println("Хеші однакові в стрінгів " + s1.hashCode() + " " + s2.hashCode() + " " + s3.hashCode());

        /** == для об'єктів порівнює посилання на об'єкти чи ті ж самі об'єкти**/
        Set<String> set1 = new HashSet<>();
        set1.add("Panda");
        Set<String> set2 = new HashSet<>();
        set2.add("Panda");
        //Буде false бо це різні посилання на різні об'єкти, хоч об'єкти і логічно рівні
        System.out.println(set1 == set2);
        System.out.println(set1.hashCode());
        System.out.println(set2.hashCode());
        //А через equals true бо логічно вони рівні
        System.out.println(set1.equals(set2));

        //Буде true бо це посилання на один й той самий об'єкт
        Set<String> set3 = set1;
        System.out.println(set1 == set3);


    }
}
