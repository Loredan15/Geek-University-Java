public class Person {
    String name;
    String position;
    String email;
    String tel;
    int age;
    int salary;


    public Person(String name, String position, String email, String tel, int age, int salary) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
