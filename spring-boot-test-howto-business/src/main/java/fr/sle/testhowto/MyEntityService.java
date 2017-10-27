package fr.sle.testhowto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author slemoine
 */
@Service
@Transactional
public class MyEntityService {

    @Autowired
    private MyEntityJpaRepository myEntityJpaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void createnewMyEntity() {
        myEntityJpaRepository.save(new MyEntity());
    }

    public List<MyEntity> getAllMyEntity() {
        return myEntityJpaRepository.findAll();
    }

    public Map<String,String> getExternalData(){
        return restTemplate.getForObject("http://mythirdpartyhost/rest/api/data", Map.class);
    }
}
