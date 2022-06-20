package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Matīss", "Geinerts", 28);
        Faker faker1 = new Faker();

        String name = faker1.name().firstName();
        String lastName = faker1.name().lastName();
        int age = faker1.number().numberBetween(18,55);
        Employee employee2 = new Employee(name, lastName, age);
        Employee employee3 = new Employee(faker1.name().firstName(),faker1.name().lastName(),faker1.number().numberBetween(18,55) );
        System.out.println(employee2.toString());
        System.out.println(employee1.toString());
        System.out.println(employee3.toString());
        System.out.println(faker1.letterify("1234??fasdfasfasdferhtf455"));


    }
}
