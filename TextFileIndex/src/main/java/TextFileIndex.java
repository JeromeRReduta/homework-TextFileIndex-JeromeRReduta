import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Path location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Path location, String word) {
		// TODO Auto-generated method stub
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

  // TODO Modify class declaration to implement the Index interface for String elements
  // TODO Modify anything within this class as necessary

}
