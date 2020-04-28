package physics2dobjects.src.main.java.com.leilanihagen.physics2dobjects;

public class Tester {

    public static void main() {
        Circle c1 = new Circle("red", 2, 3.55, 7.85, 4.1);
        Circle c2 = new Circle("blue", 2, -3.55, -7.85, 4.1);
        Rectangle r1 = new Rectangle("blue", 2, -3.55, -7.85, 4.1, 4.3);


        System.out.println(c1.getId());
        System.out.println(c2.getId());
        System.out.println(r1.getId());
    }
}
