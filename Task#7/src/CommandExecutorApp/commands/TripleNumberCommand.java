package CommandExecutorApp.commands;

public class TripleNumberCommand implements Command{

    private Double doubleNum;
    private Integer intNum;
    public TripleNumberCommand(Number number) {
        CheckClass(number);
    }

    private void CheckClass(Number number){
        switch (number.getClass().getSimpleName()){
            case "Integer":
                this.intNum=(Integer)number;
                break;
            case "Double":
                this.doubleNum=(Double)number;
                break;
        }
    }

    @Override
    public Number execute() {
        if (intNum!=null){
            return intNum*3;
        } else {
            return doubleNum*3;
        }
    }
}
