package feature.jwt;

import feature.entity.models.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static feature.jwt.SecurityConstants.EXPIRATION_TIME;

@Component
public class TokenUtil {

    @Value("${security.jwt.token}")
    private String secretKey;

    public String createToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        Map<String,Object> claims = new HashMap<>();
        claims.put("id", (userId));
        claims.put("username", user.getUsername());
        claims.put("role", user.getRole().getName().name());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, getSigninKey())
                .compact();
    }

    public boolean validateToken(String token){
        try{
            Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return true;
        }catch (SignatureException ex){
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException ex){
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            System.out.println("Expired JWT Token");
        }catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT Token");
        }catch (IllegalArgumentException ex){
            System.out.println("JWT claims string is empty");
        }
        return false;
    }

    public Long getUserIdFromJWT(String token){
        Claims claims = Jwts
                .parser()
                .setSigningKey(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String id = (String)claims.get("id");
        return Long.parseLong(id);
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return (String)claims.get("username");
    }

    private Key getSigninKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
