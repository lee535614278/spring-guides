package com.weilian.covid19.controller;

import com.weilian.covid19.JpaRepository.VoidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CovidController {

    @Autowired
    private VoidRepository covidRepository;

    @RequestMapping("/query")
    @ResponseBody
    public List queryAll(){
        return covidRepository.findAll();
    }

    @RequestMapping("/")
    public String Show(Model model){
        model.addAttribute("covid", covidRepository.findAll());

        return "index";
    }
}
