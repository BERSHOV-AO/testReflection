import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Employee employee = new Employee("Mary");
        Class c = employee.getClass();

        // Исследование информации о методах
        Method[] publicMethods = c.getMethods(); // публичные методы всей иерархии
        Method[] methods = c.getDeclaredMethods(); // получаем все методы текущего класса
        // вызов метода
        // создаем массив параметров, это нам пригодится дальше для поиска метода
        Class[] paramType = new Class[]{String.class, int.class};
        // у нашего класс получаем метод по имени calculate, так же передаем ему параметры paramType, что бы
        // удостовериться что это наш метод, с данными аргументами, иначе получим исключение
        Method method = c.getMethod("calculate", paramType);
        // Object[] argsParam = new Object[] { new String("String"), 10};
        Object[] argsParam = new Object[]{new String("String"), new Integer(10)};
        Double d = (Double) method.invoke(employee, argsParam);
        System.out.println(d);
    }
}
