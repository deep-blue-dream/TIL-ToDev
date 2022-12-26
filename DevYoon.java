import java.util.HashSet;
import java.util.Set;

public class main {

    class Card {
        String name;
        String number;

        public Card(String name, String number){
            this.name = name;
            this.number = number;
        }

        public String toString() {
            return "Card{" + "name='" + name + '\'' + ", number" + number + '}';
        }
    }
    public void makeSet() {
        Set<Card> cardSet = new HashSet<>();
        set.add(new Card("Hyundai", "0000-0000-0000"));
        set.add(new Card("Hyundai", "0000-0000-0000"));

        for (Card card : set) {
            System.out.println(card.toString());
        }
        System.out.println("size : "+set.size());
    }


}
