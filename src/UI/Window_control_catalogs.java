package UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Window_control_catalogs {

   Display display;
    public Window_control_catalogs(Shell old_shell)
    {
        display =old_shell.getDisplay();
        old_shell.close();
        Shell shell=new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        RowData data =new RowData(400,40);
        Button button1= new Button(shell,SWT.NONE);
        Font font_text=new Font(button1.getDisplay(),new FontData( "Arial", 18, SWT.BOLD ));
        button1.setFont(font_text);
        button1.setText("Мой каталог");
        button1.setLayoutData(data);

        button1.addSelectionListener(new Catalog_listener(shell));


        Text text =new Text(shell,SWT.NONE);
        text.setFont(font_text);

        text.setLayoutData(data);

        Button button2=new Button(shell, SWT.NONE);
        button2.setFont(font_text);
        button2.setText("Создать каталог");
        button2.setLayoutData(data);

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }

    public void open_catalog()
    {

    }

    public void create_catalog()
    {

    }

    public void delete_catalog()
    {

    }

    public void show_all_catalogs()
    {

    }
}
