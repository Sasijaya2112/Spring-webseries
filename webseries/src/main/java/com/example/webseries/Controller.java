package com.example.webseries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    
    @Autowired
    Repository repo;

    @RequestMapping("/addSeries")
	@ResponseBody
	public List<Webentity> in(@RequestParam String Id,@RequestParam String name,@RequestParam String season,@RequestParam String episode,@RequestParam String rating)
	{
		Webentity web = new Webentity();
		// cust.setId(id);
		web.setId(Id);
		web.setName(name);
        web.setSeason(season);
        web.setEpisode(episode);
        web.setRating(rating);

		repo.save(web);
		
		return repo.display(Id);
	}

    @RequestMapping("/update")
	@ResponseBody
	public List<Webentity> changeStatus(@RequestParam String name,@RequestParam String Id)
	{
        Webentity web = new Webentity();
		// cust.setId(id);
		// web.setId(Id);
		web.setName(name);
        // web.setSeason(season);
        // web.setEpisode(episode);
        // web.setRating(rating);

		// repo.save(web);
		
		return repo.Update(Id);
	}

    @RequestMapping("/series")
	@ResponseBody
	public List<Webentity> getall()
	{
		return repo.findAll();
	}

    @RequestMapping("/series/id")
	@ResponseBody
	public List<Webentity> del(@RequestParam String Id)
	{

         return repo.GetById(Id);
	}

    @RequestMapping("/delete")
	@ResponseBody
	public List<Webentity> getask(@RequestParam String Id)
	{

        repo.deleteById(Id);
        return repo.DelById(Id);
	}

}
