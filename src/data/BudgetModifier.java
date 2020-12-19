package data;

public class BudgetModifier {
    private int level;
    private double budgetInfluencePerStep;

    public int getValueBudget() {
        return level;
    }
    public double getBudgetInfluencePerStep() {
        return budgetInfluencePerStep;
    }

    public void setLevel(int level) { this.level = level; }
    public void setCost(double budgetInfluencePerStep) { this.budgetInfluencePerStep = budgetInfluencePerStep; }

    public BudgetModifier() {
    };
    public void Dispose() {
    };
}
//+