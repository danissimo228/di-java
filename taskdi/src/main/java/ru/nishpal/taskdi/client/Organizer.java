package ru.nishpal.taskdi.client;

import ru.nishpal.taskdi.example.Human;
import ru.nishpal.taskdi.factory.BeanFactory;
import java.lang.reflect.InvocationTargetException;

public class Organizer {
    private Human human = BeanFactory.getInstance().getBean(Human.class);


    public Organizer() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    }
    public void run() {
        human.say();
    }
}
