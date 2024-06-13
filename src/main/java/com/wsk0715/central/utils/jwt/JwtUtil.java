package com.wsk0715.central.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
	private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;  // 1 DAY
	private static final String SECRET_KEY = "aP2$dF7#yZxM9uK4&rTqW!nL8@vBbCcG2";
	private static final Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);


	public static String generateToken(String memberId) {
		return JWT.create()
				  .withSubject(memberId)
				  .withIssuedAt(new Date())
				  .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				  .sign(algorithm);
	}

	public static String getMemberIdFromToken(String token) {
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT decodedJWT = verifier.verify(token);
		return decodedJWT.getSubject();
	}

	public static boolean validateToken(String token) {
		try {
			JWTVerifier verifier = JWT.require(algorithm).build();
			verifier.verify(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
