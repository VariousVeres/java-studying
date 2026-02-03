package xamples.collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class User {
    String email;

    User(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        //Пропуск
        User user = (User) o;
        return Objects.equals(this.email, user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}

public class HashSets {
    @Test
    public void test() {
        User user = new User("Aloka");
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        user.email="Bicep";
        System.out.println(userSet.contains(user)); //  false
        System.out.println(userSet.remove(user));   //  false
        System.out.println(userSet.size());
    }

}
