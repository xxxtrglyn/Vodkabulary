package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // display list of user

    @GetMapping("/")
    public String viewHomePage(Model model){
        return findPaginated(1, "Name", "asc", model);
    }


    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind from data

        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/saveuser")
    public String saveuser(@ModelAttribute("user") User user){
        // save user to database
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        // get user from the service
        User user = userService.getUserById(id);

        //set user a model attribute to pre-population the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteuser(@PathVariable(value = "id") long id) {

        // call delete user method
        this.userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> listUsers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listusers", listUsers);
        return "index";
    }
}
