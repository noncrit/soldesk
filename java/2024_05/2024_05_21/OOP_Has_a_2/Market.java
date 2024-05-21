
public class Market {
	String name;
	String location;
	Person trader;
	String catalog;
	Plate catalog_plate;
	

	public Market(String name, String location, Person trader,String catalog) {
		super();
		this.name = name;
		this.location = location;
		this.trader = trader;
		this.catalog = catalog;
	}




	public void print_Market_info() {
		
		System.out.printf("이름	: %s\n",this.name);
		System.out.printf("위치	: %s\n",this.location);
		System.out.printf("상인	: %s\n",this.trader.name);
		System.out.println("▼연관된 정보▼");
		trader.print_Person_info();
		System.out.println("---");
	}
	
	
	
	
}
