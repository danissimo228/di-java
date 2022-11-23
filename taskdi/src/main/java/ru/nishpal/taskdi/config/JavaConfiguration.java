package ru.nishpal.taskdi.config;

public class JavaConfiguration implements Configuration{

    @Override
    public String getPackageToScan() {
        return "ru.nishpal.taskdi.example";
    }
}
