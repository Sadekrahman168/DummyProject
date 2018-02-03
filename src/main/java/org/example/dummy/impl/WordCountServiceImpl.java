package org.example.dummy.impl;

import java.util.Map;
import org.example.dummy.service.WordCountService;
import org.example.dummy.utility.SortingDirection;
import org.springframework.stereotype.Service;
import org.example.dummy.wordprocessor.MapReduceWordCountProcessor;

/**
 * This Class is responsible for processing large String and finding out unique
 * counts.
 * 
 * @author sadekrahman
 *
 */
@Service
public class WordCountServiceImpl implements WordCountService {

	MapReduceWordCountProcessor mapReduceWordProccessor;

	public WordCountServiceImpl() {

	}

	/**
	 * This method returns words with their counts / frequencies.
	 */
	@Override
	public Map<String, Integer> getWordCounts(String text, String sortDirection) {
		/*
		 * 
		 * TODO : Better Approach would be Chunk by Chunk processing With Spring Batch.
		 * 
		 */
		mapReduceWordProccessor = new MapReduceWordCountProcessor(SortingDirection.valueOf(sortDirection));
		return mapReduceWordProccessor.getCount(text);
	}

}
