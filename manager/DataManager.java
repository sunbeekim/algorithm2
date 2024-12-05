package basic.algorithm2.manager;

public class DataManager {
    private final DataStructureManager dataStructureManager;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;


    public DataManager() {
        this.dataStructureManager = new DataStructureManager();
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();    
    }

    public DataStructureManager getDataStructureManager() {
        return dataStructureManager;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }    

}

