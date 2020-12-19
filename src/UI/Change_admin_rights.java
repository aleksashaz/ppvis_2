package UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Change_admin_rights {
    Display display;
    public Change_admin_rights(Shell old_shell)
    {
        display=old_shell.getDisplay();
        old_shell.close();
        Shell shell= new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Label title =new Label(shell,SWT.NONE);
        Font font_text=new Font(title.getDisplay(),new FontData( "Arial", 20, SWT.BOLD ));
        title.setFont(font_text);
        title.setText("Передать права главы семьи");

        RowData data =new RowData(200,20);

        Label label1 =new Label(shell,SWT.NONE);
        label1.setText("Пользователь");
        Text text1 = new Text(shell,SWT.NONE);
        text1.setLayoutData(data);


        Button button =new Button(shell,SWT.NONE);
        button.setLayoutData(data);
        button.setText("Передать права");

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
