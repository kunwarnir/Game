public class SpecialDeck extends DeckOfCards {

    private int length;
    
    public SpecialDeck(int length){
      super();
      
      this.length = length;
      
      deck.clear();

      for (int i = 0; i< length; i++){
        setDeck();
      }
    }
}