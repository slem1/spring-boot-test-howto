package fr.sle.testhowto.test;

import fr.sle.testhowto.MyComponent;
import fr.sle.testhowto.MyOtherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

/**
 * @author slemoine
 */
@RunWith(JUnit4.class)
public class MyOtherServiceUnitTest {

    @Test
    public void aTest() {

        MyComponent myComponent = Mockito.mock(MyComponent.class);
        Mockito.when(myComponent.giveMeAValue()).thenReturn("mock value");
        MyOtherService myOtherService = new MyOtherService(myComponent);

        String result = myOtherService.doSomething();

        Assert.assertEquals("mock value", result);
    }
}
