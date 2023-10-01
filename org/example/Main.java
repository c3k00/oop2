package org.example;

import static org.example.Market.orders;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human aleksandr = new Human();
        aleksandr.setName("Александр");
        Human evgeniy = new Human();
        Human fedya = new Human();
        fedya.setName("Федя");
        evgeniy.setName("Евгений");
        Human zina = new Human();
        zina.setName("Зина");
        Human nastya = new Human();
        nastya.setName("Настя");


        market.acceptToMarket(aleksandr);
        market.takeInQueue(aleksandr);
        market.update();
        market.releaseFromMarket(orders);

        market.acceptToMarket(evgeniy);
        market.acceptToMarket(nastya);

        market.takeInQueue(evgeniy);
        market.takeInQueue(nastya);
        
        market.update();
        market.releaseFromMarket(orders);
        market.update();
        market.releaseFromMarket(orders);

        market.acceptToMarket(zina);
        market.acceptToMarket(fedya);
        market.takeInQueue(zina);
        market.takeInQueue(fedya);
        market.update();
        market.releaseFromMarket(orders);

        market.update();
        market.releaseFromMarket(orders);
        market.update();
        market.releaseFromMarket(orders);

    }
}