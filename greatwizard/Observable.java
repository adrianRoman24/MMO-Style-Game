package greatwizard;

public interface Observable {
    /**@param observer to be added to observer list.*/
    void addObserver(Observer observer);
    /**function that will be overloaded
     * with different types of parameters
     * (angels and heroes or both).
     */
    void notifyAllObservers();
}
