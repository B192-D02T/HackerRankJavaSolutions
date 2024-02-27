import java.util.Scanner;
//Solved By Betül Kuyucu  https://github.com/Betulk96
/*
Bu problemde size bir Food interface veriliyor. Food interface implement eden iki class Pizza ve Cake vardır ve her ikisi de getType() yöntemini içerir.

Main sınıfındaki main işlevi, FoodFactory sınıfının bir örneğini oluşturur. FoodFactory sınıfı, parametresine göre yeni bir Pizza veya Cake örneği döndüren getFood(String) yöntemini içerir.

 */
interface Food {
    String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) { //stirng tipinde Bir değer alır
        if ("pizza".equalsIgnoreCase(order)) {
            return new Pizza();
        } else if ("cake".equalsIgnoreCase(order)) {
            return new Cake();
        }
        return null;
    }

}

public class FactoryPattern {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        FoodFactory foodFactory = new FoodFactory();


        Food food = foodFactory.getFood(scanner.nextLine());

        System.out.println("The factory returned " + food.getClass());  // getFood içine kullanıcıdan aldığımız değri koyuyoruz.
        System.out.println(food.getType());



    }
}



