package steps;

public abstract class CheckoutStep {
    private static boolean editMode;

    public static void setEditMode(boolean mode) {
        editMode = mode;
    }

    public static boolean isEditMode() {
        return editMode;
    }
}
