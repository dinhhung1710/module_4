package com.example.player_thymeleaf.controller;

import com.example.player_thymeleaf.entity.Player;
import com.example.player_thymeleaf.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("player/list");
        modelAndView.addObject("playerList", playerService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("player", new Player());
        return "player/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("player") Player player,
                       RedirectAttributes redirectAttributes) {
        playerService.add(player);
        redirectAttributes.addFlashAttribute("message", "Add success");
        return "redirect:/players";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,
                         RedirectAttributes redirectAttributes) {
        playerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/players";
    }
}
