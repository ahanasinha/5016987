public class Main {
    public static void main(String[] args) {
        System.out.println("Testing factory method pattern");
        WordDocumentFactory wordDoc= new WordDocumentFactory();
        Document word= wordDoc.createDocument();
        word.open();

        PdfDocumentFactory pdfDoc= new PdfDocumentFactory();
        Document pdf= pdfDoc.createDocument();
        pdf.open();

        ExcelDocumentFactory excelDoc= new ExcelDocumentFactory();
        Document excel= excelDoc.createDocument();
        excel.open();
    }
}