package Expense_Tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

	@JsonProperty("token")
	private String token;
	@JsonProperty("username")
	private String username;
	@JsonProperty("email")
	private String email;

	public AuthResponse(String token, String username, String email) {
		super();
		this.token = token;
		this.username = username;
		this.email = email;
	}

}
 