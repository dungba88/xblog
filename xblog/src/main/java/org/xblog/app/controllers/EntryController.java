package org.xblog.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xblog.app.models.entry.Entry;
import org.xblog.app.models.entry.EntryDAO;

@Controller
@RequestMapping("/post")
public class EntryController {
	
	@Autowired
	private EntryDAO entryDAO;

	@RequestMapping("/{alias}")
	public String index(@PathVariable("alias") String alias, Model model) {
		Entry entry = entryDAO.getByAlias(alias);
		
		model.addAttribute("entry", entry);
		
		return "/WEB-INF/jsp/entry/index.jsp";
	}
}
