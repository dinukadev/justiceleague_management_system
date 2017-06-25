package com.justiceleague.justiceleaguemodule.web.transformer;

import com.justiceleague.justiceleaguemodule.domain.JusticeLeagueMemberDetail;
import com.justiceleague.justiceleaguemodule.web.dto.JusticeLeagueMemberDTO;

public class DTOToDomainTransformer {

	public static JusticeLeagueMemberDetail transform(final JusticeLeagueMemberDTO memberDTO) {
		JusticeLeagueMemberDetail memberDomain = new JusticeLeagueMemberDetail();
		memberDomain.setName(memberDTO.getName());
		memberDomain.setSuperPower(memberDTO.getSuperPower());
		memberDomain.setLocation(memberDTO.getLocation());
		return memberDomain;
	}
}
