package homework;

import homework.Line.Position;

public class Snake {

    private static Snake theSnake;

    public static Snake getTheSnake() {
        if (theSnake == null) {
            theSnake = new Snake();
        }
        return theSnake;
    }

    private Snake() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step,line);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step,Line line) {
        String[] couple = step.split("<->");
        Linable monster1 = line.getMonsterByRank(Integer.parseInt(couple[0]));
        Linable monster2 = line.getMonsterByRank(Integer.parseInt(couple[1]));
        Position p = monster2.getPosition();
        monster1.getPosition().setLinable(monster2);
        p.setLinable(monster1);
    }

}
