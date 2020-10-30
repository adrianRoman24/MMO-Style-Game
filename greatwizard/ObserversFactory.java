package greatwizard;

public final class ObserversFactory {
    private ObserversFactory() { }
    /**@return GreatWizard creator.*/
    public static GreatWizard newGreatWizard() {
        return new GreatWizard();
    }
}
