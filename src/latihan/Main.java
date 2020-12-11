package latihan;

import java.util.Scanner;

public class Main {
	private static int opsi;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);		
		menu Menu=new menu();
		while (opsi!=7) {			
			System.out.println("1.Tambah Makanan");
			System.out.println("2.Tambah Minuman");
			System.out.println("3.Tambah Paket");
			System.out.println("4.Lihat Pesanan");
			System.out.println("5.Batal Pesanan");
			System.out.println("6.Print Struck");
			System.out.println("7.Exit");
			System.out.print("Pilih Opsi= ");
			opsi=scan.nextInt();
			System.out.println();
			switch(opsi) {
			case 1:						
				Menu.addFood();
				break;
			case 2:
				Menu.addDrink();
				break;
			case 3:													
				Menu.addPacket();
				break;
			case 4:
				Menu.viewDetail();
				break;
			case 5:
				Menu.delete();
				break;
			case 6:
				Menu.receiptpembayaran();
				break;
			case 7:				
				System.out.println("Thank you ");
				break;
			default:				
				System.out.println("Invalid Option "); 
			}
			System.out.println("");
			}
		scan.close();
	}
}
