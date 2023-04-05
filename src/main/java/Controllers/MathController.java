package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{a}/and/{b}")
    @ResponseBody
    public String add(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(a + b);
    }

    @GetMapping("/subtract/{b}/from/{a}")
    @ResponseBody
    public String subtract(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(a - b);
    }

    @GetMapping("/multiply/{a}/and/{b}")
    @ResponseBody
    public String multiply(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(a * b);
    }

    @GetMapping("/divide/{a}/by/{b}")
    @ResponseBody
    public String divide(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(a / b);
    }
}
