package ru.nishpal.taskdi.example;

import ru.nishpal.taskdi.factory.BeanFactory;
import java.lang.reflect.InvocationTargetException;

public class Human {
    private Age age = BeanFactory.getInstance().getBean(Age.class);
    private Name name = BeanFactory.getInstance().getBean(Name.class);

    public Human() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    }

    public void say() {
        name.say();
        age.say();
        System.out.println("I`m human!!!!");
    }
}
