package UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Window_control_catalog {
    Display display;
    public Window_control_catalog(Shell old_shell)
    {
        display=old_shell.getDisplay();
        old_shell.close();
        Shell shell =new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));
        Font font_text=new Font(display,new FontData( "Arial", 18, SWT.BOLD ));

        Label label=new Label(shell,SWT.NONE);
        label.setText("Мой каталог");
        label.setFont(font_text);
        RowData data =new RowData(400,40);
        Button film1 = new Button(shell,SWT.NONE);
        Button film2 = new Button(shell,SWT.NONE);
        Button film3 = new Button(shell,SWT.NONE);

        film1.setLayoutData(data);
        film2.setLayoutData(data);
        film3.setLayoutData(data);

        film1.setText("Маска");
        film2.setText("Мстители");
        film3.setText("Довод");


        Label label1=new Label(shell,SWT.NONE);
        label1.setText("Добавить фильм");

        label1.setFont(font_text);

        Text text=new Text(shell,SWT.NONE);
        text.setLayoutData(data);

        Button button = new Button(shell,SWT.NONE);
        button.setLayoutData(data);
        button.setText("Добавить");

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
    public void refactor_catalog()
    {

    }

    public void add_media()
    {

    }

    public void play_media()
    {

    }

    public void delete_media()
    {

    }

    public void refactor_media()
    {

    }

}
