package kg.dpa.gov.evaluation.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

@Controller
public class LanguageController {

//    @GetMapping("/changeLanguage")
//    public String changeLanguage(@RequestParam("lang") String language,
//                                 HttpServletRequest request,
//                                 HttpServletResponse response) {
//        Locale locale = new Locale(language);
//        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//        localeResolver.setLocale(request, response, locale);
//
//        String referer = request.getHeader("Referer");
//        return "redirect:" + (referer != null ? referer : "/");
//    }
}
