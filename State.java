import java.lang.Comparable;
public class State implements Comparable<State>
{
    
    private int population, seats = 1;
    private String name; 
    private double priority;
    
    
    public State (String name, int population){
        this.population = population;
        this.name = name;
        huntington();
    }
    
    public void act(){
        seats++;
        huntington();
    }
    
    public int compareTo(State state)
    {
        return state.getPriority() == getPriority() ? 0 : (state.getPriority() > getPriority() ? 1 : -1);
    }
    
    public String getName(){ return name; }
    public Double getPriority(){ return priority;}
    public int getSeats(){ return seats; }
    public int getPopulation(){ return population; }
    private void huntington(){ priority = population / (Math.sqrt(seats*(seats+1))); }
}