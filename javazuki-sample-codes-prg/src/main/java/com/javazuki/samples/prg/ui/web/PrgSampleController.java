package com.javazuki.samples.prg.ui.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("prg")
@Slf4j
public class PrgSampleController {
  public static final String ERRORS_MODEL_KEY = BindingResult.MODEL_KEY_PREFIX + "prgSampleForm";

  @ModelAttribute PrgSampleForm prgSampleForm() {
    return new PrgSampleForm();
  }

  @GetMapping("form") public String form(Model model) {
    model.addAttribute("movies", Movie.values());
    return "prg/form";
  }

  @PostMapping("result") public String next(@Valid PrgSampleForm form, BindingResult result, Model model, RedirectAttributes attributes) {
    log.info("form:[{}] BindingResult:[{}]", form, result);

    if (result.hasErrors()) {
      // attributes.addFlashAttribute(form);
      // return "prg/form";

      attributes.addFlashAttribute(form);
      attributes.addFlashAttribute(ERRORS_MODEL_KEY, result);
      return "redirect:form";
    }

    model.addAttribute("name", form.getName());
    return "prg/result";
  }

}
