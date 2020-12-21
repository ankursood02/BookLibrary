package com.casestudy.gatewayJWT.response;


public class AuthenticationResponse {
	
	private static final long serialVersionUID = -8091879091924046844L;
	private String jwttoken;
	public AuthenticationResponse(String token) {
		this.jwttoken = token;
	}
	/**
	 * @return the jwttoken
	 */
	public String getJwttoken() {
		return jwttoken;
	}
	/**
	 * @param jwttoken the jwttoken to set
	 */
	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	
	
}
