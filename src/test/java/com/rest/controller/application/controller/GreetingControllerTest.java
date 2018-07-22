package com.rest.controller.application.controller;

import com.rest.controller.application.model.Greeting;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.Assert.*;

public class GreetingControllerTest {

//    GIVEN
    private String content = "Hello anyName";
    private long id = 1;
    private String name = "anyName";

    @Test
    public void greetingTestOneCall() {
//        WHEN
        Greeting expected = new Greeting(id, content);
        GreetingController greetingController = new GreetingController();
        Greeting actual = greetingController.greeting(name);

//        THEN
        Assert.assertEquals(expected.getContent(), actual.getContent());
        Assert.assertEquals(expected.getId(), actual.getId());

    }

    @Test
    public void greetingShouldGenerateIncreasingId() {
//        WHEN
        Greeting expected = new Greeting(id, content);
        GreetingController greetingController = new GreetingController();
        Greeting actual = greetingController.greeting(name);
        Greeting actual2 = greetingController.greeting(name);

//        THEN
        Assert.assertEquals(expected.getContent(), actual2.getContent());
        Assert.assertEquals(expected.getId()+1, actual2.getId());

    }
}