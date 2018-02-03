package org.example.dummy.wordprocessor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.example.dummy.utility.SortingDirection;

import com.google.common.base.Splitter;

/**
 * A custom MAP-REDUCE way to count words in a given Text and count number of
 * occurrences of those words.For large volume of Data it processes chunk by
 * chunk.
 * 
 * 
 * @author sadekrahman
 *
 */
public class MapReduceWordCountProcessor {

	private static final int _NUMBER_OF_CHUNKS = 4;
	private static final String DELIMETER = " ";
	Map<String, Integer> resultedMap;
	SortingDirection sortDirection;

	public MapReduceWordCountProcessor(SortingDirection sortDirection) {

		if (sortDirection == SortingDirection.desc) {
			resultedMap = new TreeMap<>((Comparator<String>) (o1, o2) -> o2.compareTo(o1));
		} else {
			resultedMap = new TreeMap<>((Comparator<String>) (o1, o2) -> o1.compareTo(o2));
		}

	}

	/**
	 * Mapes each word into a HasMap or put them into proper bucket.
	 * 
	 * @param text
	 * @return
	 */
	public Map<String, Integer> map(String text) {

		if (null == text || text.isEmpty()) {
			throw new IllegalArgumentException("Can't perform count on Empty String");
		}

		Map<String, Integer> result = new HashMap<String, Integer>();
		// TODO: Is there any ignore Char List?

		List<String> words = Splitter.on(DELIMETER).trimResults().omitEmptyStrings().splitToList(text);

		words.forEach(word -> {
			word = word.toLowerCase(); // Case agnostic.
			if (result.containsKey(word)) {
				result.put(word, result.get(word) + 1);
			} else {
				result.put(word, 1);
			}

		});
		return result;
	}

	/**
	 * Perform final counts on each word.
	 * 
	 * @param words
	 */
	public void reduce(Map<String, Integer> words) {

		words.forEach((key, value) -> resultedMap.put(key,
				resultedMap.get(key) != null ? resultedMap.get(key) + value : value));

	}

	/**
	 * Get count Chunk By chunk
	 * 
	 * @param paragraph
	 * @return
	 */
	public Map<String, Integer> getCount(String paragraph) {

		// == Chunk the data and process each chunk at a time.
		for (final String token : Splitter.on(DELIMETER).limit(_NUMBER_OF_CHUNKS).omitEmptyStrings().split(paragraph)) {
			// == Perform map
			Map<String, Integer> output = map(token);
			// == Perform Reduce
			reduce(output);
		}

		return resultedMap;
	}

}
