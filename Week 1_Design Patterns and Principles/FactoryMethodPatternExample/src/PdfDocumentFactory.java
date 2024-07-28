public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("Creating a Pdf Document");
        return new PdfDocumentImpl();
    }
}
