//A has a B : 포함 관계 : 상속?!

//이름이 Andrew Kim, 남자, 핸드폰 번호 010-1234-5678
//이런 정보를 담아서 출력

//강남 포차, 논현동, 02-1111-2222, Andrew Kim의 식당
//출력 , 식당 주인의 정보까지 출력

//이름 : 계란말이, 가격 : 2,000 ,강남포차에서 팜- 이것과 관련된 모든 정보를 출력

//석쇠 불고기, 25,000, 강남포차에서 팜 - 관련된 모든 정보를 출력

//석쇠 5,000원 석쇠 불고기를 담은 접시 - 관련된 전체 정보를 출력

//가락시장, 송파구 - 석쇠를 구매한 시장

//곽두팔, 가락시장 상인 - 관련된 전체 정보를 출력

public class HMain1 {

		public static void main(String[] args) {
			
			
			Person Kim = new Person("Andrew Kim", "male", "010-1234-5678");
			Kim.print_Person_info();
			System.out.println("---");
			
			Store south_river= new Store("강남 포차","논현동", "02-1111-2222", Kim);
			south_river.print_Store_info();
			System.out.println("---");
			
			Menu egg_roll= new Menu("계란말이", 2000, south_river);
			egg_roll.print_Menu_info();
			System.out.println("---");
			
			Menu k_bbq= new Menu("석쇠 불고기", 25000, south_river);
			k_bbq.print_Menu_info();
			System.out.println("---");
			
			
			
			Person kwak = new Person("곽두팔", "male", "010-1111-2222");
		
			Market song = new Market("가락시장", "송파구",  kwak,"석쇠");
			
			
			kwak.favorite=song;
			
			//서로 순환 참조...?
			Plate grill = new Plate(song.catalog, k_bbq, song, kwak);
			
			song.catalog_plate=grill;
					
			kwak.print_Person_info();
			System.out.println("---");
			
			grill.print_Plate_info();
			System.out.println("---");

			song.print_Market_info();
			System.out.println("---");
			
			System.out.println("===================================");
			
			//곽두팔씨의 이름만 출력
			System.out.println("곽두팔씨의 이름만 출력");
			System.out.println(kwak.name);
			System.out.println("===================================");
			
			//곽두팔씨가 좋아하는 시장 정보를 전체 출력
			System.out.println("곽두팔씨가 좋아하는 시장 정보를 전체 출력");
			song.print_Market_info();
			System.out.println();
			System.out.println("===================================");
			
			//곽두팔씨가 좋아하는 시장은 어디에 있는지 출력
			System.out.println("곽두팔씨가 좋아하는 시장은 어디에 있는지 출력");
			System.out.println(song.location);
			System.out.println("===================================");
			
			//곽두팔씨가 좋아하는 시장에서 산 접시 전체 정보 출력
			System.out.println("곽두팔씨가 좋아하는 시장에서 산 접시 전체 정보 출력");
			kwak.favorite.catalog_plate.print_Plate_info();
			System.out.println();
			System.out.println("===================================");
			
			//곽두팔씨가 좋아하는 시장에서 산 접시에 담긴 메뉴의 전체 정보
			System.out.println("곽두팔씨가 좋아하는 시장에서 산 접시에 담긴 메뉴의 전체 정보");
			kwak.favorite.catalog_plate.used_for.print_Menu_info();
			System.out.println();
			System.out.println("===================================");
			
			//곽두팔씨가 좋아하는 시장에서 산 접시에 담긴 메뉴의 가격
			System.out.println("곽두팔씨가 좋아하는 시장에서 산 접시에 담긴 메뉴의 가격");
			System.out.println(kwak.favorite.catalog_plate.used_for.price);
			System.out.println("===================================");
			
			//곽두팔씨가 좋아하는 시장에서 산 접시에 담긴 메뉴를 판 식당의 연락처
			System.out.println("곽두팔씨가 좋아하는 시장에서 산 접시에 담긴 메뉴를 판 식당의 연락처");
			System.out.println(kwak.favorite.catalog_plate.used_for.selling_place.p_num);
			System.out.println("===================================");
			
			//곽두팔씨가 좋아하는 시장에서 산 접시에 담긴 메뉴의 판 식당의 주인의 연락처
			System.out.println("곽두팔씨가 좋아하는 시장에서 산 접시에 담긴 메뉴의 판 식당의 주인의 연락처");
			System.out.println(kwak.favorite.catalog_plate.used_for.selling_place.owner.p_num);	
			System.out.println("===================================");
			
			//계란말이를 파는 사람의 연락처
			System.out.println("계란말이를 파는 사람의 연락처");
			System.out.println(egg_roll.selling_place.owner.p_num);
			System.out.println("===================================");
			
			
		}
		
}
