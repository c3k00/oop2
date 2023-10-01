package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    static ArrayList<Actor> orders = new ArrayList<>();
    Queue<Actor> queue = new ArrayDeque<>();

    @Override
    public void takeInQueue(Actor actor) {
        if (orders.contains(actor)) {
            System.out.print(actor.getName() + " в очереди. ");
            queue.add(actor);
            System.out.println("В очереди " + queue.size() + " человек.");
            orders.remove(actor);
        }
    }

        @Override
        public void takeOrders() {
            if (queue.peek() != null) {
                queue.peek().isMakeOrder = true;
                System.out.println(queue.peek().getName() + " сделал(а) заказ");
            }
        }

        @Override
        public void giveOrders () {
            if (queue.peek() != null) {
                queue.peek().isTakeOrder = true;
                System.out.println(queue.peek().getName() + " забрал(а) заказ");
                releaseFromQueue();
            }
        }

        @Override
        public void releaseFromQueue () {
            System.out.print(queue.peek().getName() + " больше не в очереди. ");
            orders.add(queue.remove());
            System.out.print(queue.size() + " человек осталось в очереди.");
            System.out.println();
        }

        @Override
        public void acceptToMarket (Actor actor){
            System.out.print(actor.getName() + " в магазине. ");
            orders.add(actor);
            System.out.println("Всего человек в магазине: " + (orders.size() + queue.size()));
        }

        @Override
        public void releaseFromMarket (List <Actor> actors) {
            for (int i = 0; i < actors.size(); i++) {
                if (actors.get(i).isTakeOrder) {
                    System.out.print(actors.get(i).getName() + " больше не в магазине. ");
                    actors.remove(actors.get(i));
                    System.out.println("Всего человек в магазине: " + (orders.size() + queue.size()));
                }
            }
        }

        @Override
        public void update() {
            takeOrders();
            giveOrders();
        }
}
