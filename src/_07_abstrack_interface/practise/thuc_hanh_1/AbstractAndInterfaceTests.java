package _07_abstrack_interface.practise.thuc_hanh_1;

import _07_abstrack_interface.practise.thuc_hanh_1.Edible;
import _07_abstrack_interface.practise.thuc_hanh_1.animal.Animal;
import _07_abstrack_interface.practise.thuc_hanh_1.animal.Chicken;
import _07_abstrack_interface.practise.thuc_hanh_1.animal.Tiger;
import _07_abstrack_interface.practise.thuc_hanh_1.fruit.Apple;
import _07_abstrack_interface.practise.thuc_hanh_1.fruit.Fruit;
import _07_abstrack_interface.practise.thuc_hanh_1.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0]=new Tiger();
        animals[1]=new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
