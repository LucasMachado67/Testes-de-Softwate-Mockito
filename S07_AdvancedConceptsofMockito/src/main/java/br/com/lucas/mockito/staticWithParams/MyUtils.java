package br.com.lucas.mockito.staticWithParams;

public class MyUtils {

	public static String getWelcomeMessage(String username, boolean isCostumer) {
		if (isCostumer) {
			return "Dear " + username;
		} else {
			return "Hello " + username;
		}
	}
}
