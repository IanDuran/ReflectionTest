import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String... args) throws Exception{
        //Crear objeto
        //Como parametros para el getConstructor van las clases de los parametros que tiene
        Constructor constructor = TestClass.class.getConstructor(int.class, int.class, double.class);
        TestClass tc = (TestClass) constructor.newInstance(1, 2, 4.0);
        //Obtener clase
        Class objClass = tc.getClass();
        System.out.println(objClass);

        //Obtener anotaciones
        /*
        Puede usarse tanto para clases como para metodos y atributos
        Las anotaciones tienen que tener la anotacion Retention con el
        valor RetentionPolicy.RUNTIME
         */
        Annotation[] annotations = objClass.getAnnotations();
        for(int i = 0; i < annotations.length; i++){
            System.out.println(annotations[i].toString());
        }

        //Obtener atributos
        /*
        Retorna los atributos
         */
        //Para atributos publicos
        //Field[] fields = objClass.getFields();

        //Para atributos publicos y privados
        Field[] fields = objClass.getDeclaredFields();

        for(int i = 0; i < fields.length; i++){
            System.out.println(fields[i].getGenericType().toString() + ": " + fields[i].getName());
        }


        //Obtener metodos
        //getMethods para TODOS los metodos, getDeclaredMethods para solo los declarados por uno
        //El orden no siempre va a ser el mismo
        Method[] methods = objClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Returns " + methods[i].getReturnType().getName() + ": " + methods[i].getName());
        }

        //Invocar metodos
        try {
            //Otra manera de conseguir un metodo
            Method method = objClass.getMethod("factorial", int.class);
            System.out.println("Result of method " + method.getName() + ": "+method.invoke(tc, 5));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
