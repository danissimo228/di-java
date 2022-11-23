package ru.nishpal.taskdi;

import ru.nishpal.taskdi.client.Organizer;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Organizer org = new Organizer();
        org.run();
    }
}