package com.example.validateform.controller;


import com.example.validateform.model.User;
import com.example.validateform.service.DuplicateEmailException;
import com.example.validateform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller

public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/create-user")
    public ModelAndView checkValidation (@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        try {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/create");
        }
        iUserService.save(user);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new User());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
        }catch (DuplicateEmailException e){
            return new ModelAndView("/inputs-not-acceptable");
        }
    }

    @GetMapping("/users")
    public ModelAndView listCustomers() throws Exception {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("users", iUserService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @GetMapping("users/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/info");
            Optional<User> customerOptional = iUserService.findById(id);
            modelAndView.addObject("customer", customerOptional.get());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/users");
        }
    }

}
