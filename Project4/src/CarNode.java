public class CarNode{
	
	protected Car data;
	protected CarNode next;
	protected static final Car dummy = new Car("","",0,0);
	
	public CarNode(){
		this(dummy, null);
	}
	
	public CarNode(Car data){
		this(data,null);
	}
	
	public CarNode(Car data, CarNode next){
        this.data = data;
        this.next = next;
    }
	
	public String toString(){
		return this.data.toString();
	}
}