package ru.nishpal.taskdi.configurator;

import org.reflections.Reflections;

import java.util.Set;

public class JavaBeanConfigurator implements BeanConfigurator {
    final Reflections scanner;

    public JavaBeanConfigurator(String packageToScan) {
        this.scanner = new Reflections(packageToScan);
    }

    /**
     * Метод возвращает класс, который реализует интерфейс.
     * @param interfaceClass
     * @return
     * @param <T>
     */
    @Override
    public <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass) {
        // Возвращает Set классов, которые кеализуют этот интерфейс
        Set<Class<? extends T>> implementationClasses =  scanner.getSubTypesOf(interfaceClass);
        System.out.println(implementationClasses);
        if (implementationClasses.size() != 1) {
            throw new RuntimeException("Интерфейс имеет 0 или более 1 реализации");
        }
        return implementationClasses.stream().findFirst().get();
    }
}
