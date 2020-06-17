import src.SimData;

public class Physics2dSimulator {

    public Simulation simulation;

  public Physics2dSimulator(Simulation simulation) {
      this.simulation = simulation;
  }

  public Physics2dSimulator() {
      this.simulation = new Simulation();
  }

  public addCirleInit() {

  }

  public static void main() {

      if(this.simulation != null) {
          this.simulation = Physics2dInteraction.getUserWorld() // runs the UI, user creates world, returns sim obj.
      }
  }
}