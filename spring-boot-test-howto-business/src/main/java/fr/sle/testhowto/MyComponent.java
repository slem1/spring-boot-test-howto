package fr.sle.testhowto;

import org.springframework.stereotype.Component;

/**
 * @author slemoine
 */
@Component
public class MyComponent {

    public void print(){}

    public String giveMeAValue(){
        return "foo";
    }
}
