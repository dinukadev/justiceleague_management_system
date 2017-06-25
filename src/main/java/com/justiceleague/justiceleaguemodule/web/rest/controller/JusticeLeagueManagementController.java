package com.justiceleague.justiceleaguemodule.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.justiceleague.justiceleaguemodule.dao.JusticeLeagueRepository;
import com.justiceleague.justiceleaguemodule.web.dto.JusticeLeagueMemberDTO;
import com.justiceleague.justiceleaguemodule.web.dto.ResponseDTO;
import com.justiceleague.justiceleaguemodule.web.transformer.DTOToDomainTransformer;

@RestController
@RequestMapping("/justiceleague")
public class JusticeLeagueManagementController {

	@Autowired
	private JusticeLeagueRepository justiceLeagueRepo;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, path = "addMember")
	public ResponseDTO addJusticeLeagueMember(@RequestBody JusticeLeagueMemberDTO justiceLeagueMember) {

		justiceLeagueRepo.save(DTOToDomainTransformer.transform(justiceLeagueMember));
		return new ResponseDTO(ResponseDTO.Status.SUCCESS, null);
	}
}
