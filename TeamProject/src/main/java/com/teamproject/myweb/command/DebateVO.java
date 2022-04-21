package com.teamproject.myweb.command;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DebateVO {
	
	private Integer debate_no;
	
	private String debate_writer;
	
	private String debate_title;
	
	private String debate_content;
	
	private LocalDateTime debate_regdate;
	
}
