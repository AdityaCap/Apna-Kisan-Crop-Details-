package com.cropDetails.User.Controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropDetails.User.Jwt.JwtUtility;
import com.cropDetails.User.Model.Login;
import com.cropDetails.User.Response.JSONResponse;
import com.cropDetails.User.SecurityService.UserDetailsImpl;

import jakarta.validation.Valid;


@CrossOrigin
@RestController

@RequestMapping("/app")
public class AuthController {
	@Autowired
	private DaoAuthenticationProvider authenticationManager;
	@Autowired
	private JwtUtility jwtUtility;

	@PostMapping("/login")

	public ResponseEntity<?> validateUser(@Valid @RequestBody Login loginRequest) {

		Authentication authentication = authenticationManager.authenticate(

				new UsernamePasswordAuthenticationToken(loginRequest.getUserEmail(), loginRequest.getPassword())

		);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		String jwtToken = jwtUtility.generateToken(authentication);

		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

		List<String> li = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

		JSONResponse jsonResponse = new JSONResponse(jwtToken, userDetails.getUsername(), li);

		return ResponseEntity.ok(jsonResponse);

	}

}
