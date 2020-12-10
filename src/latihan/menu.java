package latihan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class menu implements receipt {		
	private static char opsi;
	private String nama,harga2;
	private int harga,jumlah;
	private int ppn;
	private int total=0;
	private static int pilih;
	Scanner scan=new Scanner(System.in);
	String list[][]= {
			{"1","Makanan","Nasi Goreng","15000"},
			{"2","Makanan","Mie Goreng","15000"},
			{"3","Makanan","Capjay Goreng","15000"},
			{"4","Makanan","Ikan Goreng","15000"},
			{"5","Makanan","Ayam Goreng","15000"}};
	
	String list2[][]= {
			{"1","Minuman","Jus Jeruk","8000"},
			{"2","Minuman","Jus Melon","8000"},
			{"3","Minuman","Jus Alpukat","8000"},
			{"4","Minuman","Es Teh","5000"},
			{"5","Minuman","Air Putih","3000"}};
	
	String list3[][]= {
			{"1","Paket A","Nasi Goreng+Jus Jeruk","20000"},
			{"2","Paket B","Mie Goreng+Jus Melon","20000"},
			{"3","Paket C","Capjay Goreng+Es Teh","17000"},
			{"4","Paket D","Ayam Goreng+Jus Alpukat","20000"},
			{"5","Paket E","Ikan Goreng+Air Putih","15000"}};
	
	ArrayList<menu> pilihan = new ArrayList<menu>();
	
	public menu() {
		
	}
	
	public menu(String nama,String harga2,int jumlah) {		
		this.nama=nama;
		this.harga2=harga2;
		this.jumlah=jumlah;
	}
	
	public static <T> void printArray(T[][] elementInput) {
		for (int i = 0; i < elementInput.length; i++) {
			for (int j = 0; j < elementInput[i].length; j++) {
				System.out.println(elementInput[i][j]);
			}
			System.out.println();
		}
	}
	
	public void addFood() {
		do {
		printArray(list);		
		System.out.print("Pesan Makanan Nomor = ");
		pilih=scan.nextInt()-1;		
		harga=Integer.valueOf(list[pilih][3]);		
		for (int j = 0; j < list[pilih].length; j++) {
			nama=list[pilih][2];
			harga2=list[pilih][3];			
		}				
		System.out.print("Jumlah Pesanan = ");
		jumlah=scan.nextInt();
		menu s1=new menu(nama,harga2,jumlah);
		pilihan.add(s1);		
		total=total+(harga*jumlah);				
		System.out.println("Pesanan berhasil ditambah");
		System.out.println();
		System.out.print("Pesanan sudah selesai? Y/N ");
		opsi=scan.next().charAt(0);
		}
		while (opsi=='N' || opsi=='N'); 						
	}

	public void addDrink() {			
		do {
			printArray(list2);		
			System.out.print("Pesan Makanan Nomor = ");
			pilih=scan.nextInt()-1;		
			harga=Integer.valueOf(list2[pilih][3]);		
			for (int j = 0; j < list2[pilih].length; j++) {
				nama=list2[pilih][2];
				harga2=list2[pilih][3];			
			}				
			System.out.print("Jumlah Pesanan = ");
			jumlah=scan.nextInt();
			menu s1=new menu(nama,harga2,jumlah);
			pilihan.add(s1);		
			total=total+(harga*jumlah);				
			System.out.println("Pesanan berhasil ditambah");
			System.out.println();
			System.out.print("Pesanan sudah selesai? Y/N ");
			opsi=scan.next().charAt(0);
			}
			while (opsi=='N' || opsi=='N'); 	
	}
	
	public void addPacket() {
		do {
			printArray(list3);		
			System.out.print("Pesan Makanan Nomor = ");
			pilih=scan.nextInt()-1;		
			harga=Integer.valueOf(list3[pilih][3]);		
			for (int j = 0; j < list3[pilih].length; j++) {
				nama=list3[pilih][2];
				harga2=list3[pilih][3];			
			}				
			System.out.print("Jumlah Pesanan = ");
			jumlah=scan.nextInt();
			menu s1=new menu(nama,harga2,jumlah);
			pilihan.add(s1);		
			total=total+(harga*jumlah);				
			System.out.println("Pesanan berhasil ditambah");
			System.out.println();
			System.out.print("Pesanan sudah selesai? Y/N ");
			opsi=scan.next().charAt(0);
			}
			while (opsi=='N' || opsi=='N'); 	
	}
	
	
	public void viewDetail() {	
		int a=1;
		int totalharga=0;
		int b=pilihan.size();		
		if (b==0) {
			System.out.println("Pesanan masih Kosong");
		} else {
			    while (a<=b) {
			    	for (int i = 0; i < pilihan.size(); i++) {
			    		totalharga=pilihan.get(i).jumlah*Integer.valueOf(pilihan.get(i).harga2);
				    	System.out.println(a+" "+pilihan.get(i).nama+" "+pilihan.get(i).harga2+" QTY= "+pilihan.get(i).jumlah+" Total = "+totalharga);			    				   
				    	a++;
					}			    	 						    			    
			    	 System.out.println("");			    	 
			    	 System.out.println("SubTotal = "+total);
			  } } 
		
	}
	
	public void Delete() {		
		int b=pilihan.size();		
		if (b==0) {
			System.out.println("Pesanan masih Kosong");
		} else {			    
			    System.out.println();
			    System.out.print("Nomor pesanan yang akan dihapus = ");
				pilih=scan.nextInt()-1;
				total=total-(Integer.valueOf(pilihan.get(pilih).harga2)*pilihan.get(pilih).jumlah);
			    pilihan.remove(pilih);			    			    
			    System.out.println();			   
	} 	
		}	
	
	@Override
	public void receiptpembayaran() {
		
		char opsi2;
		System.out.print("Apakah pesanan sudah selesai? Y/N");
		System.out.println("");
		opsi2=scan.next().charAt(0);
		if (opsi2=='Y' || opsi=='y'){
			System.out.println("");
			LocalDateTime datetime= LocalDateTime.now();
			int b=pilihan.size();
			if (b==0) {
				System.out.println("Pesanan masih kosong");
			} else {
				DateTimeFormatter formatter2= DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");			
				String format=datetime.format(formatter2);
				System.out.println(format);
				System.out.println("");
				for (int i = 0; i < pilihan.size(); i++) {
					System.out.println(pilihan.get(i));
				}
				System.out.println("");
				ppn=(int) (total*0.1);
				System.out.println("Subtotal = "+total);
				System.out.println("Harga PPN = "+ppn);
				System.out.println("Total Harga = "+Integer.valueOf((total+ppn)));
				pilihan.clear();
				total=0;
			}
		}
				
	}

	@Override
	public String toString() {
		int totalharga=0;
		totalharga=Integer.valueOf(this.harga2)*this.jumlah;
		return this.nama+" "+this.harga2+" QTY = "+this.jumlah+" Total = "+totalharga;
	}
	
}
