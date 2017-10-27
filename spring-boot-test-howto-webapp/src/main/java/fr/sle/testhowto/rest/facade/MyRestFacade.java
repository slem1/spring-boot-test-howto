package fr.sle.testhowto.rest.facade;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slemoine
 */
@RestController
@RequestMapping(MyRestFacade.ROOT_RESOURCE)
public class MyRestFacade {

    public static final String ROOT_RESOURCE = "/myrestfacade";

    @GetMapping
    public String getAString(){
        return "Hello !";
    }

}
