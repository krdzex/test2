
public class Main {

	public static void main(String[] args) {
		JSONProcessor j = new JSONProcessor();
		//System.out.println(j.read("CKB123: P-100, P-50, U-200, P-150, U-100, P-500, U-50"));

	//System.out.println(j.readJSON("it_students.txt"));
	//System.out.println(j.filter(j.readJSON("it_students.txt"), "Matematika,XML tehnologije,Telekomunikacioni sistemi"));
	System.out.println(j.createJSON("Voli: Kafa sa mlijekom 1.5, Coca Cola 2, Fanta 1.8, Kolac 3.5"));
	System.out.println(j.readFile("donuts.txt"));
	System.out.println(j.treciZad(j.readFile("donuts.txt"), "Chocolate"));
	}


}
