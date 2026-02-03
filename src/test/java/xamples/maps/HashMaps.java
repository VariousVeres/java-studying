package xamples.maps;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

public class HashMaps {

    @Test
    public void main() {
        Map<User, String> map = new HashMap<>();
        User u = new User("a@mail.com");
        map.put(u, "value");

        // Мутація ключа
        u.email = "b@mail.com";

        System.out.println(map.get(u));

    }
}
