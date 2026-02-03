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
        Map<User, String> userStringMap = new HashMap<>();
        User u = new User("a@mail.com");
        userStringMap.put(u, "value");

        // Мутація ключа
        u.email = "b@mail.com";
        //Буде null бо об'єкт мутував і хеш змінився
        System.out.println(userStringMap.get(u));

        Map<String, Integer> map = new HashMap<>();
        map.put("Рембо", 2);
        map.put("Термінатор", 3);
        map.put("Джон Вік", 4);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
        }

    }
}
