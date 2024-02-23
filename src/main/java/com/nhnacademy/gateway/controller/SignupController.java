package com.nhnacademy.gateway.controller;

import com.nhnacademy.gateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class SignupController {
    private final AccountService accountService;

    @GetMapping("/signup")
    public String getSignupPage(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            return "redirect:/";
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("userId") String userId,
                        @RequestParam("password") String password,
                        @RequestParam("email") String email,
                        HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if (accountService.signup(userId, password, email)) {
            accountService.signup(userId, password, email);
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            return "redirect:/";
        } else  {
            redirectAttributes.addFlashAttribute("error", "User Already Exists");
            return "redirect:/signup";
        }
    }

    @PostMapping("/signout")
    public String signout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            accountService.signout(String.valueOf(session.getAttribute("userId")));
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            session.invalidate();
            return "redirect:/login";
        }
        return "redirect:/";
    }
}
