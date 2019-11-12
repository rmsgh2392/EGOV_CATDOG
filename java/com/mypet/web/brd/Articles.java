package com.mypet.web.brd;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Articles {
	private String articleseq, image , uid, comments, msg, rating, boardType, title, content ;
}
