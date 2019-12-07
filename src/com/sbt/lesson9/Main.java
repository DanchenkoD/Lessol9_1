package com.sbt.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        list.add(new Person("Коля", 35, Gender.MALE));
        list.add(new Person("Настя", 17, Gender.FEMALE));
        list.add(new Person("Максим", 33, Gender.MALE));
        list.add(new Person("Света", 22, Gender.FEMALE));
        list.add(new Person("Витя", 17, Gender.MALE));

        Map m = Streams.of(list)
                .filter(p -> p.getAge() > 20)
                .transform(p -> new Person(p.getName(), p.getAge() + 30, p.getGender()))
                .toMap(p -> p.getName(), p -> p);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Имя: " + list.get(i).getName() + "; Возраст: " + list.get(i).getAge() + "; Пол: " + list.get(i).getGender());
        }

        System.out.println(m.size());
        m.forEach((p, v) -> System.out.println("Имя: " + p + "; Возраст: " + ((Person) v).getAge() + "; Пол: " + ((Person) v).getGender()));

    }
}