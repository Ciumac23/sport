public class Context {
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public void executeStrategy(BasketballCompetitions t){
      strategy.calculatePoints(t);
   }
   public void executeStrategy(HandballCompetitions t){
	      strategy.calculatePoints(t);
   }
   public void executeStrategy(FootballCompetitions t){
	      strategy.calculatePoints(t);
	   }
}