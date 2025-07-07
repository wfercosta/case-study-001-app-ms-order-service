package com.wfercosta.ms.order.entrypoint.rest;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wfercosta.ms.order.domain.entity.Order;
import com.wfercosta.ms.order.domain.usecase.CreateOrderUseCase;
import com.wfercosta.ms.order.entrypoint.dto.OrderDto;
import com.wfercosta.ms.order.entrypoint.dto.OrderDtoTemplate;
import com.wfercosta.ms.order.entrypoint.mappers.OrderMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = OrderController.class)
public class OrderControllerTest {

    private static final String EMPTY_JSON = "{}";
    private static final OrderMapper mapper = OrderMapper.INSTANCE;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CreateOrderUseCase useCase;
    
    @BeforeAll
    public static void beforeAll() {
        FixtureFactoryLoader.loadTemplates(OrderDtoTemplate.class.getPackageName());
    }

    @Test
    @DisplayName("Deve retornar status 201 quando o pedido for valido")
    public void Should_ReturnStatus201_When_OrderValid() throws Exception {

        //Arrange
        final OrderDto fixture = Fixture.from(OrderDto.class).gimme(OrderDtoTemplate.BASIC);

        final Order order = mapper.toEntity(fixture);

        Mockito.when(useCase.execute(Mockito.eq(order)))
                .thenReturn(order.toBuilder().id(1L).build());

        //Act | Assertions
        mockMvc.perform(post("/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fixture)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.id_pedido", greaterThan(0)));

    }
}
