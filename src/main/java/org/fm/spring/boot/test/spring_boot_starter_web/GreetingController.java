package org.fm.spring.boot.test.spring_boot_starter_web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Greeting", description ="Greeting Rest Service")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting",method= RequestMethod.GET)
    @ApiOperation(notes ="Reterieve Greeting", value = "")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/greeting",method= RequestMethod.POST)
    @ApiOperation(notes ="Update greeting", value = "")
    public Greeting createGreeting(@RequestParam(value="name") String name) {
    	System.out.print("@@@@ Create greeting");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/greetings",method= RequestMethod.GET)
    @ApiOperation(notes ="Reterieve Greetings", value = "")
    public List<Greeting> getGreetings() {
    	ArrayList<Greeting> gs = new ArrayList<Greeting>();
    	gs.add(new Greeting(1, "Senthil"));
    	gs.add(new Greeting(2, "Kumar"));
    	return gs;
    }
}