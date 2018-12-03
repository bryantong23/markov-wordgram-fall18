/**
 * WordGram objects represent a k-gram of strings/words.
 *
 * @author Bryan Tong
 *
 */

public class WordGram {

	private String[] myWords;
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source array containing strings to be copied into myWords
	 * @param start index in source to start copying from
	 * @param size size of myWords
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		int i = 0;
		for (int j = start; j < start + size && j < source.length; j++){
			myWords[i] = source[j];
			i++;
		}
		myToString = null;
		myHash = 0;
		// TODO: initialize myWords and ...
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return return size of the WordGram
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	/**
	 * returns true if two objects are equal, false otherwise
	 */
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		if (this.length() != (wg.length())){
			return false;
		}
		for (int i = 0; i < wg.length(); i++){
			if (!myWords[i].equals(wg.myWords[i])){
				return false;
			}
		}
		// TODO: complete this method
		return true;
	}

	@Override
	/**
	 * returns hashcode for object
	 */
	public int hashCode(){
		// TODO: complete this method
		if(myHash == 0){
			myHash = this.toString().hashCode();
		}
		return myHash;
	}


	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return return new WordGram object whose first k-1 entries are the same as the last k-1 entires of this WordGram
	 * and whose last entry is the parameter last
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,1, myWords.length);
		// TODO: Complete this method
		wg.myWords[myWords.length - 1] = last;
		return wg;
	}

	@Override
	/**
	 * return words in myWords joined into one string separated by a space
	 */
	public String toString(){
		// TODO: Complete this method
		if(myToString == null){
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
