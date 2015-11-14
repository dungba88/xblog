package org.xblog.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xblog.app.models.entry.Entry;
import org.xblog.app.models.entry.EntryDAO;
import org.xblog.app.models.user.User;
import org.xblog.app.models.user.UserDAO;
import org.xblog.framework.controllers.XblogController;

@Controller
@RequestMapping("/author")
public class UserController extends XblogController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private EntryDAO entryDAO;
	
	@RequestMapping("/{authorName}")
	public void index(@PathVariable("authorName") String authorName, Model model) {
		User user = userDAO.getByAlias(authorName);
		if (user == null) {
			// TODO invalid user
		}
		List<Entry> entries = entryDAO.getEntriesByUser(user.getId());
		
		model.addAttribute("user", user);
		model.addAttribute("entries", entries);
	}
}
