package java_web_exam.demo.web.controller;


import java_web_exam.demo.model.binding.UserLoginBindingModel;
import java_web_exam.demo.model.binding.UserRegisterBindingModel;
import java_web_exam.demo.model.service.UserServiceModel;
import java_web_exam.demo.model.view.UserViewModel;
import java_web_exam.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    //FIXME
    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserRegisterBindingModel());
            model.addAttribute("error");
        }

        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserLoginBindingModel());
            model.addAttribute("error");
        }

        return "login";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute("user") UserRegisterBindingModel userRegisterBindingModel, BindingResult result,
                                  RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            attributes.addFlashAttribute("user", userRegisterBindingModel);
            return "redirect:register";
        }

        UserServiceModel userServiceModel = modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        try {
            userService.registerUser(userServiceModel);
        } catch (IllegalArgumentException ex) {
            attributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:register";
        }
        return "redirect:login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute("user") UserLoginBindingModel userLoginBindingModel, BindingResult result,
                               HttpSession session, Model model, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            attributes.addFlashAttribute("user", userLoginBindingModel);
            return "redirect:login";
        }

        UserServiceModel serviceModel = modelMapper.map(userLoginBindingModel, UserServiceModel.class);
        try {
            UserViewModel userViewModel =
                    modelMapper.map(userService.loginUser(serviceModel),
                            UserViewModel.class
                    );

            session.setAttribute("username", userViewModel.getUsername());
            session.setAttribute("id", userViewModel.getId());
        } catch (EntityNotFoundException ex) {
            attributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:login";
        }
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
