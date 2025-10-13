package com.example.player_springboot.controller;

import com.example.player_springboot.dto.PlayerDTO;
import com.example.player_springboot.service.PlayerService;
import com.example.player_springboot.service.TeamService;
import com.example.player_springboot.validate.PlayerValidate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerValidate playerValidate;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/player/list");
        modelAndView.addObject("playerList", playerService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("playerDTO", new PlayerDTO());
        model.addAttribute("teams", playerService.findAll());
        return "player/add";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute(name = "playerDTO") PlayerDTO playerDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        playerValidate.validate(playerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("teams", teamService.findAll());
            return "player/add";
        }

        playerService.add(playerDTO);
        redirectAttributes.addFlashAttribute("message", "Add success");
        return "redirect:/players";
    }
}