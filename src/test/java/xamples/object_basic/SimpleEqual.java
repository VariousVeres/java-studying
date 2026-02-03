package xamples.object_basic;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

class Bear {
    String type;
}

public class SimpleEqual {
    @Test
    public void test() {
        /** == слугує для порівняння значень примітивів **/
        int i1 = 2;
        int i2 = 2;
        int i3 = 19;
        System.out.println("int: ");
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(Integer.compare(i1, i2));
        System.out.println(Integer.compare(i1, i3) + "\n");

        System.out.println("boolean: ");
        boolean bool1 = false;
        boolean bool2 = false;
        System.out.println(bool1 == bool2);
        System.out.println(Boolean.compare(bool1, bool2) + "\n");

        System.out.println("string: ");
        String s1 = "Johny";
        String s2 = "Johny";
        //Для стрінгів хоч це об'єкти так канає бо хоч і різні референси але дані беруться з одного String pool
        System.out.println(s1 == s2);

        //А отакий не канає бо це вже новий об'єкт ми створили, хоч його хеш і буде такий самий
        String s3 = new String("Johny");
        System.out.println(s1 == s3);

        //однаковий hashCode НЕ означає, що обʼєкти — той самий обʼєкт
        System.out.println("Хеші однакові в стрінгів " + s1.hashCode() + " " + s2.hashCode() + " " + s3.hashCode() + "\n");

        System.out.println("object: ");
        /** == для об'єктів порівнює посилання на об'єкти чи ті ж самі об'єкти**/
        Bear b1 = new Bear();
        b1.type = "Panda";
        Bear b2 = new Bear();
        b2.type = "Panda";
        //Буде false бо це різні посилання на різні об'єкти, хоч об'єкти і логічно рівні
        System.out.println(b1 == b2);
        System.out.println("Хеші різні в логічно однакових об'єктів " + b1.hashCode() + " " + b2.hashCode());

        //Буде true бо це посилання на один й той самий об'єкт
        Bear b3 = b1;
        System.out.println(b1 == b3);
        System.out.println("Буде той самий хеш що в b1 бо це просто інша лінка яка на нього зсилається " + b3.hashCode());


    }
}
