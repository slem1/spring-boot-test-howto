package fr.sle.testhowto;

import org.springframework.stereotype.Service;

/**
 * @author slemoine
 */
@Service
public class MyOtherService {

    private final MyComponent myComponent;

    public MyOtherService(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    public String doSomething(){
        return myComponent.giveMeAValue();
    }
}