/**
 * 2. Абстрактний базовий клас для елементів бібліотеки.
 * Реалізує інтерфейс LibraryItem та надає спільні поля і логіку.
 */
public abstract class AbstractLibraryItem implements LibraryItem {

    protected String title;
    protected String catalogId;
    protected int totalCopies;

    public AbstractLibraryItem(String title, String catalogId, int totalCopies) {
        this.title = title;
        this.catalogId = catalogId;
        this.totalCopies = totalCopies;
    }

    // --- Реалізація методів інтерфейсу (геттери) ---

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getCatalogId() {
        return this.catalogId;
    }

    @Override
    public int getAvailableCopies() {
        // У реальній системі тут була б логіка (totalCopies - checkedOutCopies)
        return this.totalCopies;
    }

    /**
     * Базова реалізація.
     * За замовчуванням, більшість елементів можна видавати на абонемент.
     */
    @Override
    public boolean isLoanable() {
        return true;
    }

    // --- Реалізація методів для виводу ---

    /**
     * Базова реалізація для GUI.
     * Класи-нащадки будуть ДОПОВНЮВАТИ цей рядок.
     * Використовує StringBuilder для ефективного складання рядка.
     */
    @Override
    public String getDetailsAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Назва: ").append(title).append("\n"); // \n - новий рядок
        sb.append("ID каталогу: ").append(catalogId).append("\n");
        sb.append("Доступно екземплярів: ").append(getAvailableCopies()).append("\n");
        String loanStatus = isLoanable() ? "Так (Абонемент)" : "Ні (Тільки читальний зал)";
        sb.append("Доступно для видачі: ").append(loanStatus);

        return sb.toString();
    }

    /**
     * Старий консольний метод тепер просто викликає новий метод.
     */
    @Override
    public void displayDetails() {
        System.out.println(this.getDetailsAsString());
    }
}