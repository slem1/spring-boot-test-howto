package fr.sle.testhowto.test;

import fr.sle.testhowto.MyComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author slemoine
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyComponentTestClass {

    @Autowired
    private MyComponent component;

    @Test
    public void myComponentTestMethod(){

    }
}
