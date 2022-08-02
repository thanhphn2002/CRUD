package com.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping ("/users-management")
    public String showUserTable(Model model)
    {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "users-management";
    }

    @GetMapping ("/users-management/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) throws UserNotFoundException
    {
        try
        {
            User user = userService.search(id);
            model.addAttribute("userList", user);
            return "users-management";
        }
        catch (UserNotFoundException ex)
        {
            model.addAttribute("error", ex.getMessage());
            return "not-found";
        }
    }

    @GetMapping("/users-management/add")
    public String showAddForm(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add user");
        return "add-form";
    }

    @PostMapping ("/users-management/save")
    public String saveUser(User user)
    {
        userService.save(user);
        return "redirect:/users-management";
    }

    @GetMapping ("/users-management/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) throws UserNotFoundException {
        try
        {
            User user = userService.search(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit user with ID " + id);

            return "add-form";
        }
        catch (UserNotFoundException ex)
        {
            model.addAttribute("error", ex.getMessage());
            return "not-found";
        }
    }

    @GetMapping ("/users-management/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id)
    {
        userService.delete(id);
        return "redirect:/users-management";
    }


}
