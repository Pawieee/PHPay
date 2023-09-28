package PHPay;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DocumentSizeFilter extends DocumentFilter {
    private int maxChar;

    public DocumentSizeFilter(int maxChar) {
        this.maxChar = maxChar;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        if ((fb.getDocument().getLength() + string.length()) <= maxChar) {
            super.insertString(fb, offset, string, attr);
        } else {
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        if ((fb.getDocument().getLength() + text.length() - length) <= maxChar) {
            super.replace(fb, offset, length, text, attrs);
        } else {
        }
    }
}