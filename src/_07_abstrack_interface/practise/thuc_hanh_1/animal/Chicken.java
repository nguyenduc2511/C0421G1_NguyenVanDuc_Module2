package _07_abstrack_interface.practise.thuc_hanh_1.animal;

import _07_abstrack_interface.practise.thuc_hanh_1.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cuc tac cuc tac cluck-cluck";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }

}
