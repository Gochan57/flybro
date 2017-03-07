package com.volgadev.springtemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.volgadev.springtemplate.dto.DreamDTO;
import com.volgadev.springtemplate.model.Dream;
import com.volgadev.springtemplate.service.DreamService;




@Controller
@RequestMapping(value = "/dreams")
public class DreamController {

	@Autowired
	private DreamService dreamService;


	@Autowired
	private DreamService DreamService;

	

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public Dream findOne(@RequestParam Integer id) {
		return DreamService.getDreamBuId(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void addDream(@RequestBody DreamDTO dreamDTO) {
			DreamService.addDream(dreamDTO.castToDream(dreamDTO));
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteDream(@RequestParam Integer id) {
		this.DreamService.removeDream(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void editDream(@RequestBody DreamDTO dreamDTO) {
		DreamService.updateDream(dreamDTO.castToDream(dreamDTO));
	}

}
