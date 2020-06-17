package com.example.demo.Controller;

import com.example.demo.Modell.Console;
import com.example.demo.Modell.Game;
import com.example.demo.Service.ConsoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsoleController {
    private final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService) { this.consoleService = consoleService; }

    @PostMapping( path = "/addConsole")
    public Console createConsole(@RequestBody Console c) { return consoleService.createConsole(c); }

    @GetMapping(path = "/getAllConsoles")
    public List<Console> getAllConsoles() { return consoleService.getAllConsoles(); }

    @RequestMapping( method = RequestMethod.GET, value = "/getConsole/{id}")
    public Console getConsoleById(@PathVariable("id") Long consoleID) { return consoleService.getConsoleById(consoleID); }

    @PostMapping( path = "/updateConsole")
    public Console updateConsole(@RequestBody Console c) { return consoleService.updateConsole(c); }

    @RequestMapping( method = RequestMethod.DELETE, value = "/deleteConsole/{id}")
    public void deleteConsole(@PathVariable("id") Long consoleID) { consoleService.deleteConsole(consoleID);}

    @GetMapping(value = "/getConsolesByPriceRange/{minPrice}-{maxPrice}")
    public List<Console> getConsolesByPriceRange(Integer minPrice, Integer maxPrice){
        return consoleService.getConsolesByPriceRange(minPrice, maxPrice);
    }
}
