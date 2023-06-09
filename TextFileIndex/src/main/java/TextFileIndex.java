import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * A special type of {@link SimpleIndex} that indexes the UNIQUE words that were
 * found in a text file.
 *
 * @author CS 212 Software Development
 * @author University of San Francisco
 * @version Fall 2020
 */
public class TextFileIndex implements SimpleIndex {
	
	Map<Path, TreeSet<String>> map = new HashMap<>();

	@Override
	public void add(Path location, String word) {
		if (!map.containsKey(location)) {
			map.put(location,  new TreeSet<String>());
			
		}
		
		map.get(location).add(word);
	}

	@Override
	public int size(Path location) {
		return map.get(location) != null ? map.get(location).size() : 0;
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean contains(Path location) {
		return map.containsKey(location);
	}

	@Override
	public boolean contains(Path location, String word) {
		return map.containsKey(location) ? map.get(location).contains(word) : false;
	}

	@Override
	public Collection<Path> get() {
		return new TreeSet<Path>(map.keySet());
	}

	@Override
	public Collection<String> get(Path location) {
		return map.containsKey(location) ? new TreeSet<String>(map.get(location)) : new TreeSet<>();
	}
	/**
	 * toString() function
	 * 
	 * @returns JSON-ish string representation of the index
	 * 
	 */
	
	@Override
	public String toString() {
		Iterator<Path> it = map.keySet().iterator();
		StringBuilder result = new StringBuilder();
		
		//Case: Head
		result.append("{");
		
		if (it.hasNext()) {
			Path current = it.next();
			result.append("\n\t" + current.toString() + ": " + map.get(current).toString());
		}
		
		//Case: Other values
		while (it.hasNext()) {
			Path current = it.next();
			result.append(",\n\t" + current.toString() + ": " + map.get(current).toString());
		}
		
		//Case: Tail (after appending all values)
		result.append("\n}");
		
		return result.toString();
	}
}
