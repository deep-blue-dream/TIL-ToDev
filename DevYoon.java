import java.util.HashSet;
import java.util.Set;

public class DevYoon {

    class Card {
        String name;
        String number;

        public Card(String name, String number){
            this.name = name;
            this.number = number;
        }

        /*public String toString() {
            return "Card {" + "name='" + name + "\'" + ", number = " + number + '}';
        }*/
    }
    public void makeSet() {
        Set<Card> cardSet = new HashSet<>();
        cardSet.add(new Card("Samsung", "1234-5678-0000"));
        cardSet.add(new Card("Samsung", "1234-5678-0000"));

        for (Card card : cardSet) {
            System.out.println(card.toString());
        }
        System.out.println("size : " + cardSet.size());
    }
    public static void main(String[] args) {
        DevYoon dev = new DevYoon();
        dev.makeSet();
    }

}
