package com.example.spring_web_thymeleaf_file_management.controller;

import com.example.spring_web_thymeleaf_file_management.model.User;
import com.example.spring_web_thymeleaf_file_management.model.UserFiles;
import com.example.spring_web_thymeleaf_file_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FileUploadController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String users(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        model.addAttribute("user",new User());
        model.addAttribute("userFiles",new ArrayList<UserFiles>());
        model.addAttribute("idAdd",true);
        return "view/user";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute User user, RedirectAttributes redirectAttributes,Model model){
        User dbUser=userService.save(user);
        if(dbUser !=null){
            redirectAttributes.addFlashAttribute("successMessage","User is saved successfully");
            return "redirect:/";
        }else {
            model.addAttribute("errorMessage","User is not saved, Please try again");
            model.addAttribute("user",user);
            return "view/user";
        }

    }
    @GetMapping("/editUser/{userId}")
    public String editUser(@PathVariable Long userId,Model model){
User user=userService.findById(userId);

List<UserFiles> userFiles=userService.findFilesByUserId(userId);

List<User> users=userService.getAllUsers();

model.addAttribute("users",users);
        model.addAttribute("user", user);
model.addAttribute("userFiles",userFiles);
model.addAttribute("idAdd",false);
return "view/user";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user,RedirectAttributes redirectAttributes,Model model){
        User dbUser=userService.update(user);
        if(dbUser !=null){
            redirectAttributes.addFlashAttribute("successMessage","User is updated successfully");
            return "redirect:/";
        }else{
            model.addAttribute("errorMessage","User is not updated , Please try again");
            model.addAttribute("user",user);
            return "view/user";
        }
    }
    @GetMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Long userId,RedirectAttributes redirectAttributes){
        userService.deleteFilesByUserId(userId);
        userService.deleteUser(userId);

        redirectAttributes.addFlashAttribute("successMessage","User is deleted successfully");
        return "redirect:/";
    }
    @GetMapping("/viewUser/{userId}")
    public String viewUser(@PathVariable Long userId,Model model){
        User user= userService.findById(userId);
        List<UserFiles> userFiles = userService.findFilesByUserId(userId);

        List<User> users= userService.getAllUsers();
        model.addAttribute("users",users);
        model.addAttribute("user",user);
        model.addAttribute("userFiles",userFiles);
        model.addAttribute("isAdd",false);
        return "view/viewUser";
    }

}
