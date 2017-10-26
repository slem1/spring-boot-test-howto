package fr.sle.testhowto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author slemoine
 */
@Service
@Transactional
public class MyEntityService {

    @Autowired
    private MyEntityJpaRepository myEntityJpaRepository;

    public void createnewMyEntity() {
        myEntityJpaRepository.save(new MyEntity());
    }

    public List<MyEntity> getAllMyEntity() {
        return myEntityJpaRepository.findAll();
    }
}
