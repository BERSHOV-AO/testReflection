import java.lang.reflect.Constructor;

public class ReflectConstructor {

    public static void main(String[] args) {
        Employee employee = new Employee("Max");
        Class c = employee.getClass();

        Constructor[] constructors = c.getConstructors();

        for (Constructor constr : constructors) {
            Class[] paramTypes = constr.getParameterTypes(); // из конструктора получаем его параметры
            for (Class paramType : paramTypes) {
                System.out.println(paramType.getName() + "");
            }
            System.out.println("-------------------");
        }
    }
}
