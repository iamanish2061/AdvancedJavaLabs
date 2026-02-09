//Write a Java program to illustrate the use of Bound and Constrained properties.
package lab3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class BoundAndConstrainedDemo {

    public static void main(String[] args) {

        PersonBean person = new PersonBean();

        // Bound property listener
        person.addPropertyChangeListener((PropertyChangeEvent evt) ->
                System.out.println(evt.getPropertyName() +
                        " changed to " + evt.getNewValue())
        );

        // Constrained property listener
        person.addVetoableChangeListener(evt -> {
            int newAge = (int) evt.getNewValue();
            if (newAge < 18) {
                throw new PropertyVetoException("Age below 18 not allowed", evt);
            }
        });

        // Bound property test
        person.setName("Alice");

        // Constrained property test
        try {
            person.setAge(20);   // allowed
            person.setAge(15);   // vetoed
        } catch (PropertyVetoException e) {
            System.out.println(e.getMessage());
        }
    }
}
