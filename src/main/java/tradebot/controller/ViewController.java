package tradebot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ViewController {
    @RequestMapping("/pnd")
    public String pnd(Model model,@RequestParam Map<String, String> reqParam) {
        model.addAttribute("title", "PND DATA - DASHOBOARD");
        return "pnd/index";
    }

    @RequestMapping("/vbo")
    public String vbo(Model model,@RequestParam Map<String, String> reqParam) {
        model.addAttribute("title", "VBO DATA - DASHOBOARD");
        return "vbo/index";
    }

    @RequestMapping("/num")
    public String num(Model model,@RequestParam Map<String, String> reqParam) {
        model.addAttribute("title", "NUM DATA - DASHOBOARD");
        return "num/index";
    }

    @RequestMapping("/")
    public String index(Model model,@RequestParam Map<String, String> reqParam) {
        model.addAttribute("title", "HOME - DASHOBOARD");
        return "index";
    }
}
