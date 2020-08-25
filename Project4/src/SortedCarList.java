public class SortedCarList extends CarList{
	
	public SortedCarList(){
		super();
	}
	
	public void add(Car data){
		CarNode n = new CarNode(data);
		CarNode i = this.first;
		while (i.next != null && i.next.data.compareTo(data) <= 0)
			i = i.next;
		n.next = i.next;
		i.next = n;
		if (i == this.last)
			this.last = n;
		this.length++;
	}
}