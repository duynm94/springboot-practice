package com.nmd.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nmd.example.person.dto.PersonDTO;
import com.nmd.example.person.entity.Person;

@Controller
public class PersonController {

	private static List<Person> persons = new ArrayList<>();

	static {
		persons.add(new Person("Bill", "Gate"));
		persons.add(new Person("Steve", "Jobs"));
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("msg", "This is msg");
		return "index";
	}

	@RequestMapping(value = "/personList", method = RequestMethod.GET)
	public String personList(Model model) {
		model.addAttribute("persons", persons);
		return "personList";
	}
	
	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
	public String showAddPersonPage(Model model) {

		PersonDTO personDTO = new PersonDTO();
		model.addAttribute("personForm", personDTO);

		return "addPerson";
	}
	
	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
	public String savePerson(Model model, //
			@ModelAttribute("personForm") PersonDTO personDTO) {

		String firstName = personDTO.getFirstName();
		String lastName = personDTO.getLastName();

		if (firstName != null && firstName.length() > 0 //
				&& lastName != null && lastName.length() > 0) {
			Person newPerson = new Person(firstName, lastName);
			persons.add(newPerson);

			return "redirect:/personList";
		}

		model.addAttribute("errorMessage", "This is a error msg!");
		return "addPerson";
	}

}
