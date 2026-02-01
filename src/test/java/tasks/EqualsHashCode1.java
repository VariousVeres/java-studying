package tasks;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCode1 {
    /** Потрібно
     Перевизначити equals і hashCode так, щоб: два User вважались рівними, якщо email однаковий
     name НЕ бере участі в порівнянні
     Написати тест:
     покласти User у HashSet
     змінити name
     перевірити, що обʼєкт не “загубився”
     👉 Питання на подумати:
     Чому змінювати name безпечно?
     А що буде, якщо змінити email? **/

    class User {
        String email;
        String name;

        public boolean equals(Object o)  {
            if(this == o) return true;
            if(!(o instanceof User)) return false;
            User user = (User) o;
            return Objects.equals(this.email, user.email);
        }

        public int hashCode()  {
            return Objects.hash(this.email);
        }
    }

    @Test
    public void test()  {
        User user1 = new User();
        user1.email="Emails";
        user1.name="Name";
        HashSet<User> set1 = new HashSet<>();

        set1.add(user1);
        System.out.println(set1.contains(user1));
        System.out.println(user1.hashCode());
        user1.name="Changed name";
        System.out.println(set1.contains(user1));
        System.out.println(user1.hashCode());
    }

}
