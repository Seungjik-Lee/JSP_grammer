
public class DBox<L,R> {
	private L l;
	private R r;
	
	// ?????? ctrl + shift + s -> o
	public DBox(L l, R r) {
		super();
		this.l = l;
		this.r = r;
	}
	
	// toString ctrl + shift + s -> s
	@Override
	public String toString() {
		return "DBox [l=" + l + ", r=" + r + "]";
	}
	
	
}
