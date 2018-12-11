package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceLanguages;
import com.example.pompsynchronizationdata.source.service.SourceLanguagesService;
import com.example.pompsynchronizationdata.target.entity.TargetLanguages;
import com.example.pompsynchronizationdata.target.service.TargetLanguagesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/6 10:07
 * description:
 */
@Component
public class LanguageCopy extends PageHandler<SourceLanguages> {

    @Autowired
    SourceLanguagesService sourceLanguagesService;

    @Autowired
    TargetLanguagesService targetLanguagesService;

    @Override
    protected int handleDataOfPerPage(List<SourceLanguages> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
        	cpb.show(i);
        	SourceLanguages sourceLanguages = list.get(i);
        	Long sourceLanguagesId = sourceLanguages.getId();
        	String sourceLanguagesName = sourceLanguages.getName();
        	LocalDateTime sourceLanguagesTime = sourceLanguages.getTime();
        	
        	if(sourceLanguagesTime != null && sourceLanguagesId != null && sourceLanguagesName!=null) {
        		LocalDateTime time = sourceLanguagesTime;
        		Long id = sourceLanguagesId;
        		String name = sourceLanguagesName;
        		TargetLanguages targetLanguages = new TargetLanguages();
        		targetLanguages.setId(id);
        		targetLanguages.setName(name);
        		targetLanguages.setTime(time);
        		targetLanguagesService.save(targetLanguages);
        	}
        	
        }
        return size;
    }

    @Override
    protected Page<SourceLanguages> getPageList(int pageNumber) {
        return sourceLanguagesService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }


}
