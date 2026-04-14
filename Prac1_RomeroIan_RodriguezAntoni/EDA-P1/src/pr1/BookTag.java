package pr1;

public class BookTag implements Comparable<BookTag>{

	// Atributs
	private String left;
	private int mid;
	private String right;

	// Constructor
	public BookTag (String left, int mid, String right) { // Parametres
		check(left, mid, right);
		// Atri
		this.left = left.toUpperCase();
		this.mid = mid;
		this.right = right.toUpperCase();
	}
	
	
	@Override
	public int compareTo(BookTag other) {
		int cmp = this.left.compareTo(other.left);
		int cmp2 = this.right.compareTo(other.right);
		if (cmp<0) return 1;
		else if (cmp==0) {
			if (this.mid < other.mid) return 1;
			else if (this.mid == other.mid) {
				if(cmp2>0) return 1;
				else if (cmp2 == 0);
			}
		}
		else return -1;


		/* Booktags are sorted as follows:
		 	- first go booktags with lowest left attribute. If left attributes cannot discriminate...
		 	- ... first go booktags with the lowest mid attribute. If mid cannot discriminate...
		 	- ... first go booktags with HIGHEST right attribute. 
		 */
		
		/* COMPLETE */

		
		return 0; //TODO: Change this!
	}
	
	@Override
	public boolean equals (Object arg) {
		BookTag other;
		if (arg == this) {
			return true;
		}
		if (!(arg instanceof BookTag)) {
			return false;
		}
		other = (BookTag) arg;
		return (this.compareTo(other) == 0);
		
	}
	
	@Override
	public String toString () {
		return "["+left+"-"+mid+"-"+right+"]";
	}
	
	
	@Override
	public int hashCode () {
		return left.hashCode()%mid+right.hashCode()%mid;
	}
	
	
	@Override
	public BookTag clone() {
		return new BookTag(new String(left), mid, new String(right));
	}

	
	private static void check (String left, int mid, String right) {
		if (left.length()!=4) throw new IllegalArgumentException("Bad left size: "+left);
		if (mid<10 || mid>99) throw new IllegalArgumentException("Bad mid number: "+mid);
		if (right.length()!=2) throw new IllegalArgumentException("Bad right size: "+left);
	}
	
}
