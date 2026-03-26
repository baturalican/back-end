package com.example.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
        @GetMapping("/showForm")
        public String showForm() {
            return "helloworld-form";
        }

        @RequestMapping("/processForm")
        public String processForm() {
            return "helloworld";
        }

        // Getting data from the form and put it in the model
        @RequestMapping("/processFormVersionTwo")
        public String shoutData(HttpServletRequest request, Model model) {
            String theName = request.getParameter("studentName");

            theName = theName.toUpperCase();

            String result = "Ciao " + theName;

            model.addAttribute("message", result);

            return "helloworld";
        }
        @PostMapping("/processFormVersionThree")
        public String shoutDataAlternative(@RequestParam("studentName") String theName, Model model) {
            theName = theName.toUpperCase();

            String result = "Hey my friend " + theName;

            model.addAttribute("message", result);

            return "helloworld";
        }
}
