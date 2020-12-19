package UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main_menu {
    Display display;

    public Main_menu(Shell old_shell)
    {
        this.display=old_shell.getDisplay();
        old_shell.close();
        Shell shell=new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Button button1 = new Button(shell, SWT.NONE);
        Button button2 = new Button(shell, SWT.NONE);
        Button button3 = new Button(shell, SWT.NONE);

        button1.setText("Загрузить медиа");
        button2.setText("Семья");
        button3.setText("Каталоги");

        Font font_text=new Font(button1.getDisplay(),new FontData( "Arial", 18, SWT.BOLD ));
        button1.setFont(font_text);
        button2.setFont(font_text);
        button3.setFont(font_text);

        button1.addSelectionListener(new Media_listener(shell));
        button2.addSelectionListener(new Famely_listener(shell));
        button3.addSelectionListener(new Catalogs_listener(shell));

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }

    }


}
