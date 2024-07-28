public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("Creating a Excel Document");
        return new ExcelDocumentImpl();
    }
}
