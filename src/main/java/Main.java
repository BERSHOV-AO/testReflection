import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Hello reflect");

        Employee employee = new Employee("Ben");

        System.out.println(employee);
        Class c = employee.getClass(); // будут поля только для employee, у родителей мы их не получим

        for (Field field : c.getDeclaredFields()) {
            Class fieldType = field.getType();
            if (Modifier.isPrivate(field.getModifiers())) { // если тип private, ниже ломаем Accessible(доступ)
                field.setAccessible(true); // если поле private, мы делаем setAccessible(true), получаем к нему доступ
                // Лучше сравнивать по названию поля
                if (fieldType.equals(String.class)) { // сравниваем, ели это строка, то set (employee, "Sam"); ниже
                    field.set(employee, "Sam");
                    // String newValue = (String) field.get(employee);
                }
            }
        }
        System.out.println(employee);
    }
}
