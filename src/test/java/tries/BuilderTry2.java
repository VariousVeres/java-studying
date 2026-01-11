package tries;

import org.junit.Test;

 class Outer {
    private int age;
    private int count;
    private String level;

    public String getLevel()  {
        return this.level;
    }



    private Outer(Builder builder)  {
        this.age=builder.age;
        this.count= builder.count;
        this.level= builder.level;

    }


    public static class Builder {
        private int age;
        private int count;
        private String level;

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setCount(int count) {
            this.count = count;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Outer build()  {
            return new Outer(this);
        }

    }





}

public class BuilderTry2 {
    @Test
    public void test()  {
        Outer.Builder builerTry21 = new Outer.Builder();
        Outer outer = builerTry21.setAge(1).setCount(2).setLevel("Левел").build();
        System.out.println(outer.getLevel());
        System.out.println(outer);

    }


}
