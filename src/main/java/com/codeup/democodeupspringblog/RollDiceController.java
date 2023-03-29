package com.codeup.democodeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showRollDicePage() {

        return "roll-dice-page";
    }

    @GetMapping("/roll-dice/{guess}")
    public String showRollDicePage(@PathVariable int guess, Model model) {
        int roll = new Random().nextInt(6) + 1;
        model.addAttribute("roll", roll);
        model.addAttribute("guess", guess);
        model.addAttribute("message", guess == roll ? "You guessed right!" : "You guessed wrong!");
        return "roll-dice-page";
    }

    @PostMapping("/roll-dice")
    public String showRollDicePage(@PathVariable int guess) {
        return "redirect:/roll-dice/" + guess;

    }
}
