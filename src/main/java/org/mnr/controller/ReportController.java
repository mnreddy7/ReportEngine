package org.mnr.controller;

import javax.validation.Valid;

import org.mnr.entity.ReportScheuduleEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Naveen Reddy
 * @version 1.0
 */

@Controller
public class ReportController {

	@RequestMapping(value = "/schedule")
	public ModelAndView scheduleReport(
			ReportScheuduleEntity reportScheuduleEntity) {
		return new ModelAndView("schedule");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveSchedule(
		    ReportScheuduleEntity reportScheuduleEntity,
			BindingResult bind, final RedirectAttributes redirectAttributes) {
		System.out.println("saveSchedule method");
		ModelAndView modelAndView = new ModelAndView("schedule");
		if (bind.hasErrors())
			return modelAndView;
		else {
			System.out.println("data:" + reportScheuduleEntity);
			reportScheuduleEntity = null;
			String message = "Data saved successfully!";
			reportScheuduleEntity = new ReportScheuduleEntity();
			redirectAttributes.addFlashAttribute("message", message);
			modelAndView.addObject("reportScheuduleEntity",
					reportScheuduleEntity);
			return new ModelAndView("schedule");
		}
	}
}
