package fr.sle.testhowto.test;

import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author slemoine
 */
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockBasicAuthSecurityContextFactory.class)
public @interface WithMockBasicAuth {

    String principal();

    String[] roles() default {};
}
