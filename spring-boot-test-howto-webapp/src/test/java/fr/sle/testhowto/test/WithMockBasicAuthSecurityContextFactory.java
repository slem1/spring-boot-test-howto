package fr.sle.testhowto.test;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author slemoine
 */
public class WithMockBasicAuthSecurityContextFactory implements WithSecurityContextFactory<WithMockBasicAuth>{

    @Override
    public SecurityContext createSecurityContext(WithMockBasicAuth basicAuth) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (final String role : basicAuth.roles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

        User principal = new User(basicAuth.principal(), "", grantedAuthorities);
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, grantedAuthorities);
        context.setAuthentication(authentication);
        return context;
    }
}
