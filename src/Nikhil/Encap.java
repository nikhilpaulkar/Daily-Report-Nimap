package Nikhil;

 class Encap {
 private String name;
 private int id;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 public  class Test
 {
	 public static void main(String args[])
	 {
		 Encap e1= new Encap();
		 e1.setName("nikhi");
		 e1.setId(8);
		 System.out.println(e1.getName()+"" +e1.getId());
	 }
 }
}
