import java.util.PriorityQueue;

public class Congress{

	public Congress(String filename, boolean output){
		In input = new In(filename);
        int numberOfStates = Integer.valueOf(input.readLine());
        int numberOfSeats = Integer.valueOf(input.readLine());
  
		PriorityQueue<State> queue = new PriorityQueue(numberOfStates);
        for(int i = 0; i < numberOfStates ; ++i){
			queue.add(new State(input.readLine(), Integer.valueOf(input.readLine()))); 
		}


		for(int i = 0; i < numberOfSeats-numberOfStates; i++){
			State s = queue.poll();
			s.act();
			queue.add(s);
		}
  
		if(output){
			Out out = new Out("result_" + filename);
			for(int i = 0; i < numberOfStates; i++){
				State s = queue.poll();
				out.println(s.getName() + " " + s.getSeats());
			}
			out.close();
		}
	}
 

	public static void main(String[] args)
	{
		String file = args.length == 1 ? args[0] : "2000-in.txt";
		Stopwatch timer = new Stopwatch();
		new Congress(file, true);
		double time = timer.elapsedTime();
		StdOut.println("Runtime: " + time);
	}
}