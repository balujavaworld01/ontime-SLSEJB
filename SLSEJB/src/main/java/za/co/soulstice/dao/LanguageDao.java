package za.co.soulstice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import za.co.soulstice.model.Language;

public interface LanguageDao extends JpaRepository<Language, Long>, JpaSpecificationExecutor<Language> {
	
}
