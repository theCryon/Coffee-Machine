package machine;

import java.util.Scanner;

public class CoffeeMachine{
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

        public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money){
            this.water = water;
            this.milk = milk;
            this.coffeeBeans = coffeeBeans;
            this.disposableCups = disposableCups;
            this.money = money;
        }
        public void run(){
            String action;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                switch(action = scanner.next()){
                    case "buy":
                        buy();
                        break;
                    case "fill":
                        fill();
                        break;
                    case "take":
                        take(money);
                        break;
                    case "remaining":
                        displayState(water, milk, coffeeBeans, disposableCups, money);
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println("Unknown operation");
                }
            }while(!action.equals("exit"));
        }

    private void displayState(int water, int milk, int coffeeBeans, int disposableCups, int money){
        System.out.println("The coffee machine has:");
        System.out.println(water+" of water");
        System.out.println(milk+" of milk");
        System.out.println(coffeeBeans+" of coffee beans");
        System.out.println(disposableCups+" of disposable cups");
        System.out.println(money+" of money");
    }

    private void take(int money){
        System.out.println("I gave you $"+money);
        this.money = 0;
    }

    private void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.disposableCups += scanner.nextInt();
    }

    private void buy(){
        Scanner scanner = new Scanner(System.in);
        String in;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch(in = scanner.next()){
            case "1":
                if ((this.water >= 250)&&(this.coffeeBeans >= 16)&&(this.disposableCups >= 1)){
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 250;
                    this.coffeeBeans -= 16;
                    this.disposableCups--;
                    this.money += 4;
                }
                else if (this.water < 250)
                    System.out.println("Sorry, not enough water!");
                else if (this.coffeeBeans < 16)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (this.disposableCups < 1)
                    System.out.println("Sorry, not enough disposable cups!");
                break;
            case "2":
                if ((this.water >= 350)&&(this.milk >= 75)&&(this.coffeeBeans >= 20)&&(this.disposableCups >= 1)){
                    this.water -= 350;
                    this.milk -= 75;
                    this.coffeeBeans -= 20;
                    this.disposableCups--;
                    this.money += 7;
                }
                else if (this.water < 350)
                    System.out.println("Sorry, not enough water!");
                else if (this.milk < 75)
                    System.out.println("Sorry, not enough milk!");
                else if (this.coffeeBeans < 20)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (this.disposableCups < 1)
                    System.out.println("Sorry, not enough disposable cups!");
                break;
            case "3":
                if ((this.water >= 200)&&(this.milk >= 100)&&(this.coffeeBeans >= 12)&&(this.disposableCups >= 1)){
                    this.water -= 200;
                    this.milk -= 100;
                    this.coffeeBeans -= 12;
                    this.disposableCups--;
                    this.money += 6;
                }
                else if (this.water < 200)
                    System.out.println("Sorry, not enough water!");
                else if (this.milk < 100)
                    System.out.println("Sorry, not enough milk!");
                else if (this.coffeeBeans < 12)
                    System.out.println("Sorry, not enough coffee beans!");
                else if (this.disposableCups < 1)
                    System.out.println("Sorry, not enough disposable cups!");
                break;
            case "back":
                break;
            default:
                System.out.println("Unknown operation");
        }
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        machine.run();
    }
}
