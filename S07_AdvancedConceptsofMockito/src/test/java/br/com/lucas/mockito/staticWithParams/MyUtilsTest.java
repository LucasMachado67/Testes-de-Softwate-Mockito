package br.com.erudio.mockito.staticWithParams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import br.com.lucas.mockito.staticWithParams.MyUtils;

class MyUtilsTest {

	@Test
	void shouldMockStaticMethodWithParams() {
		try (MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)) {
			mockedStatic.when(() -> MyUtils.getWelcomeMessage(eq("Lucas"), anyBoolean())).thenReturn("Howdy Lucas");

			String result = MyUtils.getWelcomeMessage("Lucas", false);

			assertEquals("Howdy Lucas", result);
		}
	}

}
