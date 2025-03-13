package i18n;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

public record Solution(int year, int day) {
    
    public Solver<?> determineSolver() {
        final var classPath = determineClassPath();
        final var clazz = determineClass(classPath);
        final var constructor = getConstructor(clazz);
        return determineSolver(constructor);
    }
    
    private String determineClassPath() {
        final var innerDirectories = String.format("i18n/year%d", year());
        final var dayPackageName = innerDirectories.replace('/', '.');
        return String.format("%s.Day%02d", dayPackageName, day());
    }
    
    private static Class<?> determineClass(String classPath) {
        try {
            return Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static Constructor<?> getConstructor(Class<?> clazz) {
        try {
            return clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static Solver<?> determineSolver(Constructor<?> executable) {
        try {
            return (Solver<?>) executable.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String retrieveInput() {
        final var filename = String.format("input/day%02d.txt", day());
        
        try {
            return Files.readString(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}