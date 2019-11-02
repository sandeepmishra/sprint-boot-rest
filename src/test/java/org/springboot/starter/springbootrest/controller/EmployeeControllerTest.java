package org.springboot.starter.springbootrest.controller;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    private int port = 8089;

    @Rule
    private WireMock wireMock = new WireMock(port);
    
}
