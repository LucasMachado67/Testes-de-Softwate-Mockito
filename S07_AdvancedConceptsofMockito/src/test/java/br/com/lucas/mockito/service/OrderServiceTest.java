package br.com.erudio.mockito.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import br.com.lucas.mockito.service.Order;
import br.com.lucas.mockito.service.OrderService;

class OrderServiceTest {

	private final OrderService service = new OrderService();

	private final UUID defaultUuid = UUID.fromString("618b08a9-7df6-45ae-ba17-95908ef6208e");
	private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 7, 4, 15, 50);

	@DisplayName("Should Include Random OrderId When No OrderId Exists")
	@Test
	void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
		// Given / Arrange

		try (MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {

			mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

			// When / Act
			Order result = service.createOrder("MacBook Pro", 2L, null);

			// then / Assert
			assertEquals(defaultUuid.toString(), result.getId());
		}
	}

	@DisplayName("Should Include CurrentTime When Create A NewOrder")
	@Test
	void testShouldIncludeCurrentTime_When_CreateANewOrder() {
		// Given / Arrange

		try (MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {

			mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

			// When / Act
			Order result = service.createOrder("MacBook Pro", 2L, null);

			// then / Assert
			assertEquals(defaultLocalDateTime, result.getCreationDate());
		}
	}

}
