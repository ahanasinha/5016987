public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("Creating a Word Document");
        return new WordDocumentImpl();
    }
}
