import java.util.Arrays;

public class Autocomplete {
	Term[] terms;
	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] terms) { 
		if (terms == null){
			throw new NullPointerException();
		}
		this.terms = terms; 
		Arrays.sort(terms); //uses lexographic order 
	}

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
	public Term[] allMatches(String prefix) {
		int first = BinarySearch.<Term>firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
		int last = BinarySearch.<Term>lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
		if(first == -1 || last == -1){
			return null;
		}
		Term[] soln = Arrays.copyOfRange(terms, first, last+1);
		Arrays.sort(soln, Term.byDescendingWeightOrder());
		return soln;
	}

}