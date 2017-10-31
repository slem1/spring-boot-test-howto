package fr.sle.testhowto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;

/**
 * @author slemoine
 */
@Service
@Transactional
public class MyEntityService {


    private final MyEntityJpaRepository myEntityJpaRepository;

    private final RestTemplate restTemplate;

    private final WebServiceTemplate webServiceTemplate;

    public MyEntityService(MyEntityJpaRepository myEntityJpaRepository, RestTemplate restTemplate, WebServiceTemplate webServiceTemplate) {
        this.myEntityJpaRepository = myEntityJpaRepository;
        this.restTemplate = restTemplate;
        this.webServiceTemplate = webServiceTemplate;
    }

    public void createnewMyEntity() {
        myEntityJpaRepository.save(new MyEntity());
    }

    public List<MyEntity> getAllMyEntity() {
        return myEntityJpaRepository.findAll();
    }

    public Map<String, String> getExternalData() {
        return restTemplate.getForObject("http://mythirdpartyhost/rest/api/data", Map.class);
    }


    public void callASoapWebService() {

        WebServiceMessageCallback requestCallback = message -> {

            SoapMessage soapMessage = (SoapMessage) message;

            SoapHeader soapHeader = soapMessage.getSoapHeader();
            soapHeader.addHeaderElement(new QName("namespace", "username")).setText("user1");
            soapHeader.addHeaderElement(new QName("namespace", "password")).setText("password1");

        };

        WebServiceMessageCallback responseCallback = message -> {
        };

        webServiceTemplate.sendAndReceive("/CosignWS/CosignWS", requestCallback, responseCallback);
    }
}
