package lottery.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "jwt.config")
public class JwtHelper {
    private final static String subject = "ytks";
    private final static SecureDigestAlgorithm<SecretKey, SecretKey> ALGORITHM = Jwts.SIG.HS256;
    private Long tokenExpiration;//有效时间
    private String tokenSignKey;//token密钥
    private SecretKey key;

    @PostConstruct
    void init() {
        key = Keys.hmacShaKeyFor(tokenSignKey.getBytes());
    }

    /**
     * 输入userId生成token
     * @param userId
     * @return
     */
    public String createToken(Long userId) {
        return Jwts.builder()
                .header()
                .add("alg", "HS256")
                .add("typ", "JWT")
                .and()
                .subject(subject)
                .expiration(new Date(System.currentTimeMillis() + tokenExpiration * 1000 * 60)) //单位分钟
                .claim("userId", userId)
                .signWith(key, ALGORITHM)
                .compressWith(Jwts.ZIP.GZIP)
                .compact();
    }

    /**
     * 检验token是否过期
     * @param token
     * @return
     */
    public boolean isExpiration(String token) {
        try {
            return Jwts
                    .parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getExpiration()
                    .before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 通过token返回用户id
     * @param token
     * @return
     */
    public Long getUserId(String token) {
        if (StringUtils.isEmpty(token)) return null;
        Integer userId = (Integer) Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("userId");
        return userId.longValue();
    }


}
