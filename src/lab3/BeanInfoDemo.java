//Write a Java program to illustrate the use of the BeanInfo interface.
package lab3;

import java.beans.*;

public class BeanInfoDemo {

    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(StudentBean.class);
            System.out.println("=== Properties ===");
            for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
                System.out.println("Property Name: " + pd.getName());
                System.out.println("Getter Method: " + pd.getReadMethod());
                System.out.println("Setter Method: " + pd.getWriteMethod());
                System.out.println();
            }

            System.out.println("=== Methods ===");
            for (MethodDescriptor md : beanInfo.getMethodDescriptors()) {
                System.out.println("Method Name: " + md.getMethod().getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
