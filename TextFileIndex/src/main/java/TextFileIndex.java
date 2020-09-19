import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
		return false;
	}

	@Override
	public Collection<Path> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> get(Path location) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		Set<Path> keys = map.keySet();
		Iterator<Path> it = keys.iterator();
		StringBuilder result = new StringBuilder();
		
		result.append("{");
		
		if (it.hasNext()) {
			Path current = it.next();
			result.append("\n\t" + current.toString() + ": " + map.get(current).toString());
		}
		while (it.hasNext()) {
			Path current = it.next();
			result.append(",\n\t" + current.toString() + ": " + map.get(current).toString());
		}
		
		result.append("\n}");
		
		return result.toString();
	}

  // TODO Modify class declaration to implement the Index interface for String elements
  // TODO Modify anything within this class as necessary
	
	public static void main(String[] args) {
		TextFileIndex tfi = new TextFileIndex();
		
		tfi.add(Path.of("Bob"), "Dylan");
		tfi.add(Path.of("Dylan"), "Dylan also");
		tfi.add(Path.of("Dylan"), "not actually Dylan");
		

		System.out.println(tfi);
	}

}
