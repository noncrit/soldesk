
public class Plate {
	String catalog;
	Menu used_for;
	Market bought_from;
	Person seller;
	

	
	public Plate(String catalog, Menu used_for, Market bought_from, Person seller) {
		super();
		this.catalog = catalog;
		this.used_for = used_for;
		this.bought_from = bought_from;
		this.seller = seller;
	}



	public void print_Plate_info() {
		
		System.out.printf("이름	: %s\n",this.catalog);
		System.out.printf("사용처	: %s\n",this.used_for.name);
		System.out.printf("구입처	: %s\n",this.bought_from.name);
		System.out.printf("판매자	: %s\n",this.seller.name);
		used_for.print_Menu_info();
		bought_from.print_Market_info();
		seller.print_Person_info();
		System.out.println("---");
	}
}
