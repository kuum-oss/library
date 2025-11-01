/**
 * 5. Конкретний клас: Випуск журналу.
 */
public class JournalIssue extends AbstractLibraryItem {

    protected String publisher;
    protected int issueNumber;

    public JournalIssue(String title, String catalogId, String publisher, int issueNumber, int totalCopies) {
        super(title, catalogId, totalCopies);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    /**
     * Перевизначаємо метод для GUI.
     */
    @Override
    public String getDetailsAsString() {
        String baseDetails = super.getDetailsAsString();
        return "--- [ЖУРНАЛ] ---\n" +
                baseDetails + "\n" +
                "Видавництво: " + publisher + "\n" +
                "Номер випуску: " + issueNumber;
    }
}