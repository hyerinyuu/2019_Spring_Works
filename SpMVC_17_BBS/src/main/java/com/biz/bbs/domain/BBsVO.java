package com.biz.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BBsVO {

	private long bbs_id;	//bigint
	private String bbs_p_id;	//	bigint
	private String bbs_writer;	//	varchar(10)
	private String bbs_date;	//	varchar(10)
	private String bbs_time;	//	varchar(10)
	private String bbs_subject;	//	varchar(10)
	private String bbs_content;	//	varchar(10)
	private int bbs_count;	//	int

	
}
