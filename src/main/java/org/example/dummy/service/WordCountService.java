package org.example.dummy.service;

import java.util.Map;

/**
 * processes large String and finding out unique counts.
 * 
 * @author sadekrahman
 *
 */
public interface WordCountService {
	/**
	 * Returns words with their counts / frequencies.
	 * 
	 * @param text
	 * @param sortDirection
	 * @return
	 */
	Map<String, Integer> getWordCounts(String text, String sortDirection);
}
