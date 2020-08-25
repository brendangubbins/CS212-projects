public abstract class CarList{
	
	protected CarNode first;
	protected CarNode last;
	public int length;
	protected static final Car dummy = new Car("","",0,0);
	
	public CarList(){
		this.first = new CarNode(dummy);
		this.last = this.first;
		this.length = 0;
	}
	
	public void append(Car data){
		CarNode newCarNode = new CarNode(data);
		
		this.last.next = newCarNode;
		this.last = newCarNode;
		this.length++;
	}
	
	public void prepend(Car data){
		CarNode newCarNode = new CarNode(data);
		
		newCarNode.next = this.first.next;
		this.first.next = newCarNode;
		
		if (this.last == this.first)
			last = newCarNode;
		this.length++;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (CarNode i = first.next; i != null; i = i.next){
			sb.append(i.toString() + "\n");
		}
		return sb.toString();
	}
}