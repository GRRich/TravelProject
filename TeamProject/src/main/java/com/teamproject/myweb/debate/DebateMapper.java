package com.teamproject.myweb.debate;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;


import com.teamproject.myweb.command.DebateUploadVO;
import com.teamproject.myweb.command.DebateVO;
import com.teamproject.myweb.util.Criteria;

@Mapper
public interface DebateMapper {
	
	public int regist(DebateVO vo);
	public int registFile(DebateUploadVO vo);
	
	public ArrayList<DebateVO> getList(); //목록
	public int getTotal(Criteria cri); //전체게시글 수
	
	public DebateVO getDetail(int debate_no); //상세
	public int update(DebateVO vo); //수정
	public int delete(int debate_no); //삭제

}
