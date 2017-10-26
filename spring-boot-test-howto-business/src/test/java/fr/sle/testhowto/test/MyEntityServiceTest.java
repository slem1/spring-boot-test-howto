package fr.sle.testhowto.test;

import fr.sle.testhowto.MyEntity;
import fr.sle.testhowto.MyEntityService;
import fr.sle.testhowto.test.config.AdditionalTestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    private MyEntityService myEntityService;

    @Test
    public void saveMyEntityShouldCreateNewEntity() {
        testEntityManager.persistAndGetId(new MyEntity());
    }

    @Test
    @Sql("/datasets/MyEntityServiceTest/injectedSqlTestMethod.sql")
    public void injectedSqlTestMethod() {
        List<MyEntity> allMyEntity = myEntityService.getAllMyEntity();
        Assert.assertEquals(1, allMyEntity.size());
    }
}
