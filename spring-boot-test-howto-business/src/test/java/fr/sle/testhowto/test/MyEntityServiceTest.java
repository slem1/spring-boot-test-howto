package fr.sle.testhowto.test;

import fr.sle.testhowto.MyEntity;
import fr.sle.testhowto.test.config.AdditionalTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author slemoine
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdditionalTestConfig.class)
@AutoConfigureTestEntityManager
@Transactional
public class MyEntityServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveMyEntityShouldCreateNewEntity() {
        testEntityManager.persistAndGetId(new MyEntity());
    }
}
