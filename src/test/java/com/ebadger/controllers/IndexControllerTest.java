package com.ebadger.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IndexControllerTest {

    @LocalServerPort
    private int serverPort;

    private URL requestUrl;
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws Exception {

        requestUrl = new URL("http://localhost:" + serverPort + "/hello");
        testRestTemplate = new TestRestTemplate();
    }

    @Test
    public void getTime() throws Exception {

        ResponseEntity<String> response = testRestTemplate.getForEntity(requestUrl.toString(), String.class);
        assertThat(response.getBody(), equalTo("Hello everyone!"));
    }

}