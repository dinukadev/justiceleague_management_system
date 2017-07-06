package com.justiceleague.justiceleaguemodule.web.transformer;

import com.justiceleague.justiceleaguemodule.domain.JusticeLeagueMemberDetail;
import com.justiceleague.justiceleaguemodule.web.dto.JusticeLeagueMemberDTO;

/**
 * This class will have transformers from and to different types we need. A
 * common class is used in this instance due to the simplicity of the
 * application.
 * 
 * @author dinuka
 *
 */
public class DTOToDomainTransformer {

	/**
	 * This method will trasform an instance of {@link JusticeLeagueMemberDTO}
	 * to {@link JusticeLeagueMemberDetail}
	 * 
	 * @param memberDTO
	 *            an instance of {@link JusticeLeagueMemberDTO} with the details
	 *            of the member.
	 * @return an instance of {@link JusticeLeagueMemberDetail} with the details
	 *         of the member.
	 */
	public static JusticeLeagueMemberDetail transform(final JusticeLeagueMemberDTO memberDTO) {
		JusticeLeagueMemberDetail memberDomain = new JusticeLeagueMemberDetail();
		memberDomain.setName(memberDTO.getName());
		memberDomain.setSuperPower(memberDTO.getSuperPower());
		memberDomain.setLocation(memberDTO.getLocation());
		return memberDomain;
	}
}
