package com.edu.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity // 클래스 선언부에 반드시@Entity가 설정되어야 한다.
@Table(name="tbl_board")
//Table을 설정하는 경우에는 기본적으로 데이터베이스의 클래스명과 동일한 이름으로 생성한다.
//만일 클래스명을 다른 이름으로 테이블 명을 지정하고 싶을때에는 @Table의 name 속성을 사용한다.

public class BoardDTO {

	@Id
	//가장 중요한 어노테이션
	//id는 해당 컬럼이 식별키(Primary Key)라는 것을 의미한다.
	@GeneratedValue(strategy = GenerationType.AUTO)
	//ID는 주로 @GeneratedValue와 같이 이용해서 식별키를 어떤 전략으로 생성하는지를 명시한다.
	//GeneratedValue는 strategy 속과 generator 속성으로 구분된다.
	//strategy 속성   
	//			AUTO: 특정 데이터베이스에 맞게 자동으로 생성되는 방
	//			TABLE: 기본 키 생성 방식 자체를 데이터베이스에게 위임하는 방
	//			SEQUENCE: 데이터베이스에서 시퀀스를 이용해서 식별키를 생성한다.(ORACLE)
	//			TABLE: 별도의 키를 생성해주는 채번 테이블(번호를 취할 목적으로 만든 테이블)을 이용하는 방
	//generator 속성 : @TableGenerator, @SequenceGenerator
	private Long	bno;
	private String	title;
	private String	writer;
	private String	content;
	
	//아래의 시간 관련 어노테이션은 Hibernate만의 고유한 설정이다.
	//엔티티가 생성되거나 업데이트되는 시점의 날짜 데이터를 기록하는 설정이다.
	@CreationTimestamp
	private Timestamp	regdate;	//게시글 등록일자
	@UpdateTimestamp
	private Timestamp 	updatedate;	//게시글 수정일자
	
}
