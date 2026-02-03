package xamples.java_core;

import org.testng.annotations.Test;

class User {
    String name;


    void changeName(User u) {
        u.name = "Bob";
    }

    void reassign(User u) {
        u.name = "Angel";
        u = new User();
        u.name = "Dorothy";
    }
}


public class PassByValue {

    @Test
    public void test() {
        User user = new User();
        user.name = "Alex";
        user.changeName(user);
        System.out.println(user.name);
        user.reassign(user);
        System.out.println(user.name);

    }
}
