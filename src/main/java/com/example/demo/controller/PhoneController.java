package com.example.demo.controller;

import com.example.demo.models.Phone;
import com.example.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping(path = "/")
    public String showTable(Model model){
        model.addAttribute("phones", getPhoneList());
        return "home";
    }

    @GetMapping(path = "/add")
    public String showAddForm(Model model){
        Phone phone = new Phone();
        model.addAttribute("phone", phone);
        return "add";
    }

    @GetMapping(path = "/phones")
    public List<Phone> getPhoneList() {
        return phoneService.getPhones();
    }

    @GetMapping(path = "/phone/search")
    public Optional<Phone> getPhoneById(@RequestParam(name = "id") Long id) {
        return phoneService.getPhoneId(id);
    }

//    @PostMapping(path = "/add")
//    public void addPhone(@RequestBody Phone phone) {
//        phoneService.addPhone(phone);
//    }

//    @RequestMapping(value = { "/add" }, method = RequestMethod.POST)
//    public String addPhone(Model model, @ModelAttribute("phone") Phone phone) {
//
//        String brand = phone.getBrand();
//        String color = phone.getBrand();
//        double price = phone.getPrice();
//
//        return "add";
//    }
}
