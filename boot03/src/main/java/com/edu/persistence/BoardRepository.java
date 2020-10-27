package com.edu.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.edu.dto.BoardDTO;

public interface BoardRepository extends CrudRepository<BoardDTO, Long> {
	
	//제목에 의한 검색
	public List<BoardDTO> findBoardByTitle(String title);
	public List<BoardDTO> findBoardByWriter(String title);
	
	//작성자에 대한 like % keyword % 
	public Collection<BoardDTO> findByWriterContaining(String writer);
	
	public Collection<BoardDTO> findByTitleContainingAndBnoGreaterThan(String title, Long bno);
	
	//Order by
	public Collection<BoardDTO> findByBnoGreaterThanOrderByBnoDesc(long bno);
	
	//페이징 처리, 정렬
	//Where bno > ? order by bno desc limit ?, ?
	public List<BoardDTO> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
	
	//페이징 처리, Sort
	//public List<BoardDTO> findByBnoGreaterThan(Long bno, Pageable paging);
	
	public Page<BoardDTO> findByBnoGreaterThan(Long bno, Pageable paging);
}
