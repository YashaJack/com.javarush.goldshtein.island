package managers;

import simulation.IslandSimulation;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationScheduler {
    private final ScheduledExecutorService scheduler;

    public SimulationScheduler(IslandSimulation simulation, int cycleTime) {
        scheduler = Executors.newScheduledThreadPool(3);
        scheduler.scheduleAtFixedRate(simulation::growPlants, 2, cycleTime, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(simulation::updateAnimals, 4, cycleTime, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(simulation::printStatistics, 6, cycleTime, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdown();
    }
}
