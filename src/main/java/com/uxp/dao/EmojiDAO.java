package com.uxp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uxp.model.Emoji;

@Transactional
public interface EmojiDAO extends CrudRepository<Emoji, Long> {
	
}
