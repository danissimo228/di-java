package ru.nishpal.taskdi.factory;

import ru.nishpal.taskdi.config.Configuration;
import ru.nishpal.taskdi.config.JavaConfiguration;
import ru.nishpal.taskdi.configurator.BeanConfigurator;
import ru.nishpal.taskdi.configurator.JavaBeanConfigurator;
import java.lang.reflect.InvocationTargetException;

/** 
 * Pattern Simple Fabric
 * Паттерн Простая фабрика необходим для простой инкапсуляции процесса 
 * создания объектов от рабочего кода с помощью другого, отдельного класса.
 */
public class BeanFactory {
    private static final BeanFactory BEAN_FACTORY = new BeanFactory();
    private final BeanConfigurator beanConfigurator;
    private final Configuration configuration;

    /**
     * Simple singleton
     */
    private BeanFactory() {
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan());
    }

    public static BeanFactory getInstance() {
        return BEAN_FACTORY;
    }

    public <T> T getBean(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Class<? extends T> implementationClass = clazz; // Класс потенциально расширяется
        if (implementationClass.isInterface()) {
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }
        return implementationClass.getDeclaredConstructor().newInstance();
    }
}
