package com.eval.coronakit.controller;

import java.util.ArrayList;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/custom-login")
	public String login() {
		return "login-form";
	}

	@GetMapping("/login")
	public ModelAndView validateLogin() {
		ModelAndView mv = new ModelAndView("main-menu");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			String role = new ArrayList<>(auth.getAuthorities()).get(0).getAuthority();

			mv.addObject("unm", auth.getName());
			mv.addObject("role", role);
			mv.addObject("principal.username", auth.getName());
		}
		return mv;
	}

	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}

}
