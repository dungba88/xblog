package org.xblog.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xblog.app.models.entry.Entry;
import org.xblog.app.models.entry.EntryDAO;
import org.xblog.framework.advices.filters.DataTransformer;
import org.xblog.framework.controllers.XblogController;
import org.xblog.impl.models.entry.EntrySummaryAssembler;

@RestController
public class UserController extends XblogController {
	
	@Autowired
	private EntryDAO entryDAO;
	
	@DataTransformer(EntrySummaryAssembler.class)
	@RequestMapping("/user/{authorAlias}/posts")
	public List<Entry> getPosts(@PathVariable("authorAlias") String authorAlias) {
		return entryDAO.getEntriesByUser(authorAlias);
	}
}
