package com.geoffreylalic.springtutorial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
public class Controller {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.CREATED)
    public String sayHello2() {
        return "Hello World2";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ) {
        return "Posted successfully and message is " + message;
    }

    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ) {
        return "Posted successfully and message is " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ) {
        return "Posted successfully and message is " + order.toString();
    }

    @GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String username) {
        return "Hello " + username;
    }

    @GetMapping("/hello/param")
    public String paramVar(@RequestParam("userName") String username) {
        return "Hello " + username;
    }
}
