public class SpecialDeck extends DeckOfCards {

    public SpecialDeck(int length){
      super();
      
      deck.clear();

      for (int i = 0; i< length; i++){
        setDeck();
      }
    }
}