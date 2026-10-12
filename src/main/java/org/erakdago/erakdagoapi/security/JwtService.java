package org.erakdago.erakdagoapi.security;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.user.model.User;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final long EXPIRATION_SECONDS = 90;
    private final JwtEncoder jwtEncoder;

    public String generateToken(User user) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder().issuer("erakdago-api").issuedAt(now)
                .expiresAt(now.plusSeconds(EXPIRATION_SECONDS)).subject(user.getId().toString())
                .claim("email", user.getEmail()).claim("username", user.getUsername()).build();
        JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();

        return jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
    }

    public long getExpirationSeconds() {
        return EXPIRATION_SECONDS;
    }
}
