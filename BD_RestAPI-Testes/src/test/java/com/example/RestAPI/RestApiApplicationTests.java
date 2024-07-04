package com.example.RestAPI;
import com.example.RestAPI.controller.UserController;
import com.example.RestAPI.model.UserEntity;
import com.example.RestAPI.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class RestApiApplicationTests {

	@Test
	void testObterTodos() {
		List<UserEntity> userList = Arrays.asList(
				new UserEntity("1", "user1", "user1@email.com"),
				new UserEntity("2", "user2", "compton@gmail.com")
		);
		when(userService.obterTodos()).thenReturn(userList);
		List<UserEntity>result= userController.obterTodos();
		assertEquals(userList,result);
	}
	@SpringBootTest(classes = {com.example.RestAPI.application.RestApiApplication.class})
	class UserTest{
		@Mock
		private  UserService userService;
		@InjectMocks
		private UserController userController;

		@Test
		void testObterTodos(){}
		@Test
		void testObterPorId(){}
		@Test
		void testInserir(){}
		@Test
		void testAtualizar(){}
		@Test
		void testExcluir(){}


	}

}
